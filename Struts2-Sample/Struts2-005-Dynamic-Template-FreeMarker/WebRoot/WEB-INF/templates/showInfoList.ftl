<#import "./common/common.ftl" as com>
<#escape x as x?html>
<@com.page title="Index">

  <a href="form.a">Add new message</a> 
  
  <#if managerBeanList?size = 0>
    <p>No messages.
  <#else>
    <p>The messages are:
    <table cellspacing=2 cellpadding=2 width="100%">
      <tr align=center valign=top>
        <th bgcolor="#C0C0C0">管理员ID
        <th bgcolor="#C0C0C0">管理员用户名
        <th bgcolor="#C0C0C0">管理员密码
        <th bgcolor="#C0C0C0">管理员Token</th>
      <#list managerBeanList as e>
        <tr align=center valign=top>
          <td bgcolor="#E0E0E0">${e.managerId}
          <td bgcolor="#E0E0E0">${e.managerUserName}
          <td bgcolor="#E0E0E0">${e.managerPassword}
          <td bgcolor="#E0E0E0">${e.managerToken}<td>
      </#list>
    </table>
  </#if>
  
</@com.page>

</#escape>
