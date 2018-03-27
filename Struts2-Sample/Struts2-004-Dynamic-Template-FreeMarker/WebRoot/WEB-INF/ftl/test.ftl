
<html>
<head>
  <title>Welcome!</title>
</head>
<body>


 
   <!-- if表达式测试二 -->
   <h6> if object?exists object </h6>
  
  <#if user?exists>
      <h6>Welcome ${user}!</h6>
  </#if>
  
  <hr/>
   
   <!--if表达式测试二 -->
   <h6>if user?? A else B</h6>
   <#if user??>
      A
   <#else>
       B
  </#if>
  
  <hr/>
  
   <h6>if object?? elseif object=="admin" else C </h6>
   <#if user??>
     A
   <#elseif user=="admin">
     B
   <#else>
     C
  </#if>
  
   <h6>Struts2 IF TAG with freemarker</h6>
   
  <@s.if test="user==null">
				A
			</@s.if>
			<@s.else>
				B
  </@s.else>
  


 


  
 
</body>
</html>