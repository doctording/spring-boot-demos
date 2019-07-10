package com.example.demo.api.intercept;

import com.example.demo.api.syncrecord.Record;
import com.example.demo.api.syncrecord.Recorder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @Author mubi
 * @Date 2019/7/9 11:54 PM
 */
@Component
@Aspect
@Slf4j
public class HttpLoggerInterceptor {

    @Autowired
    Recorder recorder;

    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    @Around(value = "@within(com.example.demo.api.annotation.HttpLogger) ||"
            + "@annotation(com.example.demo.api.annotation.HttpLogger)")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        log.info("@Around：before method...");
        //访问目标方法的参数：
        Object[] args = point.getArgs();
        String newStr = "";
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            String oldStr = (String)args[0];
            newStr = "prefix_" + oldStr;
        }
        args[0] = newStr;
        //用改变后的参数执行目标方法
        Object returnValue = point.proceed(args);
        log.info("@Around：after method...");
        log.info("@Around：around object：" + point.getTarget());
        return returnValue;
    }

    @AfterReturning(pointcut = "@annotation(com.example.demo.api.annotation.AfterLogger)",
            returning="returnValue")
    public void log(JoinPoint point, Object returnValue) {
        log.info("@AfterReturning：logger start");
        log.info("@AfterReturning：method：" +
                point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        log.info("@AfterReturning：params：" +  Arrays.toString(point.getArgs()));
        log.info("@AfterReturning：returnValue：" + returnValue);
        log.info("@AfterReturning：object：" + point.getTarget());
    }

    @Around(value = "@within(com.example.demo.api.annotation.RecordLogger) ||"
            + "@annotation(com.example.demo.api.annotation.RecordLogger)")
    public Object record(ProceedingJoinPoint point) throws Throwable {

        //获取连接点的方法签名对象
        Signature signature = point.getSignature();
        log.info("toLongString" + signature.toLongString());
        log.info("toShortString" + signature.toShortString());
        log.info("toString:" + signature.toString());
        //获取方法名
        log.info("methodName:" + signature.getName());

        log.info("@Around：before method...");
        Object[] args = point.getArgs();
        long start = System.currentTimeMillis();
        log.info("start:" + df.format(start));
        Object returnValue = point.proceed(args);
        long end = System.currentTimeMillis();
        log.info("end:" + df.format(start));
        Record record = new Record();
        record.setQueryTime(start);
        record.setQueryCostTime(end-start);
        log.info("@Around：end method：" + record);
        recorder.record(record);
        return returnValue;
    }
}
