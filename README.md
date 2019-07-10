所有项目demo都基于`idea gradle + SpringBoot`来开发构建

源代码见`code`目录，以及源码写的`README.md`

---

## 关键词

* idea
* Java8
* SpringBoot
* gradle
* mybatis
* alibaba druid
* alibaba sentinel

## AOP & @Aspect & @interface

```java

@Aspect:作用是把当前类标识为一个切面供容器读取

@Pointcut：Pointcut是植入Advice的触发条件。每个Pointcut的定义包括2部分，一是表达式，二是方法签名。方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。

@Around：环绕增强，相当于MethodInterceptor

@AfterReturning：后置增强，相当于AfterReturningAdvice，方法正常退出时执行

@Before：标识一个前置增强方法，相当于BeforeAdvice的功能

@AfterThrowing：异常抛出增强，相当于ThrowsAdvice

@After: final增强，不管是抛出异常或者正常退出都会执行
```

## 异步队列

* LinkedBlockingQueue

* 线程池

## TODO
