<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring Form 登陆</title>
</head>
<body>
       login with Spring Form

      <form:form action="/form/loginWithSpringValidate" method="Post" modelAttribute="user">
          名字:<form:input path="username"/><br/>
          密码:<form:input path="password"/>
          <input type="submit" title="submit">
      </form:form>

</body>
</html>