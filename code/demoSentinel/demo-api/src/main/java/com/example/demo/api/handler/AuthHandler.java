package com.example.demo.api.handler;

import com.example.demo.api.annotation.Authenticate;
import com.example.demo.api.exception.ErrorCode;
import com.example.demo.api.exception.ProException;
import com.example.demo.api.utils.CheckAuthUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Author mubi
 * @Date 2019/7/13 8:00 PM
 */
@Slf4j
@Component
public class AuthHandler extends HandlerInterceptorAdapter {
    /**
     * Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的
     * 可以同时存在多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，
     * 而且所有的Interceptor中的preHandle方法都会在Controller方法调用之前调用。
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("request path[{}] uri[{}]", request.getServletPath(),request.getRequestURI());
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Authenticate authenticate = method.getAnnotation(Authenticate.class);
        // 如果没有加注解,则 authenticate 为null
        if (Objects.nonNull(authenticate)) {
            String token = request.getHeader("token");
            if (authenticate.permission() && ! CheckAuthUtil.isAuth(token)){
                throw new ProException(ErrorCode.PERMISSION_ERROR);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
