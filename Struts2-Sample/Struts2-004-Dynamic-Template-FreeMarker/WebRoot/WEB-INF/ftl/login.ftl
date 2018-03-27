<html>
<head>
<title>Login Form</title>
</head>
<body>



please input username and password login<br>



<@s.form action="LoginValidate.action" method="post">
 <@s.textfield name="username" label="username"/>
 <@s.password name="password" label="password" />
 <@s.submit value="submit" />
</@s.form >

</body>
</html>