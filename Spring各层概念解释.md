## Spring各层概念与作用介绍
**1. entity层=pojo层。**
存放我们的属性值，与数据库中的数据表基本保持一致。

**2. model**
在Spring MVC中，Controller负责处理DispatcherServlet分发的请求，它把用户请求的数据经业务处理层（service）处理后得到的结果封装成一个Model，然后再把该Model返回给对应的View进行展示。

**3.service层。**
存放业务逻辑处理，也是一些关于数据库处理的操作，但不是直接和数据库打交道。它有接口还有接口的实现方法，在接口的实现方法中需要导入mapper层。mapper层是直接跟数据库打交道的，它也是个接口，只有方法名字，具体实现是在mapper.xml文件里，service是供我们使用的方法。

**4. mapper层=dao层**
现在用Mybatis逆向工程生成的mapper层，其实就是dao层。mapper层包括对数据库进行数据持久化操作，它的方法语句是直接针对数据库操作的，而service层是针对我们controller，也就是针对使用者。service的impl是把mapper和service进行整合的文件。
在ssm框架中，mapper层包括mapper接口和mapper.xml文件；

**5.controller层**
控制器，导入service层。controller接收前端传过来的参数，通过service层进行业务操作，之后将操作结果传送到前端，并返回一个逻辑路径对应前端页面。

各层之间的关系
浏览器请求 <——> servlet <——> controller层 <——> service层 <——> mapper层 <——> 数据库




