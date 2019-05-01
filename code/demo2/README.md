# code/demo2 项目

在demo项目的基础上加上日志处理

* Slf4j + logback（日志处理的种类很多，本次选用的是常用的 slf4j + logback）

* logback.xml 的配置

* 日志输出到控制台 和  文件中（当然日志输出是多样的，还可以使用第三方获取实时产生的日志）

注意：

1. build.gradle中的依赖添加

2. logback-spring.xml的编写（具体需要参考logback官网）

3. **项目运行仍存在一些 debug 日志没有处理 Todo**

日志的控制台输出和文件输出

![](../../imgs/log.jpg)

![](../../imgs/log_junit.jpg)

参考

1. logback官网.The logback manual[E/OL]https://logback.qos.ch/manual/index.html

2. aubdiy.logback.xml常用配置详解[E/OL]http://aub.iteye.com/blog/1110008