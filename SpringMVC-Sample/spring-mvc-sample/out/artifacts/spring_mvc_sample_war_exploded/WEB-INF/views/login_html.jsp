<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HTML Form登陆页面</title>
</head>
<body>

      Login With HTML form
     <form action="/form/loginWithHTMLValidate" method="post">
         用户名<input type="text" name="username"><br/>
         登陆密码<input type="password" name="password"/><br/>
          <input type="submit" title="Submit">
     </form>
</body>
</html>