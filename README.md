所有项目demo都基于`idea gradle + SpringBoot`来开发构建

源代码见`code`目录，以及源码写的`README.md`，相关知识点如下

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

## 异步队列（见`code/demoSentinel`）

* LinkedBlockingQueue

* 线程池

## 统一异常处理，统一返回，handler处理等(见`code/demoSentinel`）

### 正确返回

* request

```java
curl -X GET \
  http://localhost:22368/test/permission \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 6650b628-5e98-468b-ab09-c291d67810ff' \
  -H 'cache-control: no-cache' \
  -H 'token: token'
```

* response body

```java
{
    "code": 0,
    "message": "OK",
    "data": "testNoPermission"
}
```

### hanlder处理，无权限等情况

* request

```java
curl -X GET \
  http://localhost:22368/test/permission \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 76f7da19-c150-4e96-9180-724128e56d94' \
  -H 'cache-control: no-cache'
```

* response body

```java
{
    "code": 2,
    "message": "No permission",
    "data": null
}
```

## TODO
