# Struts2 学习案例源码库
## 1.1 Struts 2 使用须知
如果想使用Struts2,必须满足如下条件:
- Servlet API 2.4 +
- JSP 2.0+
- JDK 7+
## 1.2 如何创建一个Struts2 Web 应用程序
1.pom.xml引入Jetty插件并配置上下文
```xml 
     <build>
         <finalName>struts2-0x01-hello-world-sample</finalName>
         <!-- 定义项目的名称 -->
         <!-- 定义插件 -->
         <plugins>
             <!--定义这个插件允许我们使用mvn jetty:run命令运行我们当前这个项目-->
             <plugin>
                 <groupId>org.eclipse.jetty</groupId>
                 <artifactId>jetty-maven-plugin</artifactId>
                 <version>9.4.7.v20170914</version>
                 <configuration>
                     <webApp>
                         <contextPath>/${project.build.finalName}</contextPath>
                     </webApp>
                     <stopKey>CTRL+C</stopKey>
                     <stopPort>8999</stopPort>
                     <scanIntervalSeconds>10</scanIntervalSeconds>
                     <scanTargets>
                         <scanTarget>src/main/webapp/WEB-INF/web.xml</scanTarget>
                     </scanTargets>
                 </configuration>
             </plugin>
         </plugins>
     </build>
```
2.添加index.jsp
```html
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
  </head>
  <body>
    <h1>Welcome To Struts 2!</h1>
  </body>
</html>
```
3.当前项目pom.xml根目录执行
```
mvn jetty:run
```
4.添加Struts2 Jar 文件到ClassPath
```xml
<dependency>
    <groupId>org.apache.struts</groupId>
    <artifactId>struts2-core</artifactId>
    <version>2.5.20</version>
</dependency>
```
5.添加日志依赖

pom.xml添加log4j2依赖如下：
```xml
https://logging.apache.org/log4j/2.x/maven-artifacts.html
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.12.1</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.12.1</version>
</dependency>
```

## 参考资料
- [How To Create A Struts 2 Web Application](https://struts.apache.org/getting-started/how-to-create-a-struts2-web-application.html)
