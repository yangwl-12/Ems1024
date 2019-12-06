<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/25
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload/test3" enctype="multipart/form-data" method="post">
    <input type="file" name="aa">
    <input type="submit" value="提交">
</form>

<h1>提供下载链接</h1>

<li>
    toux
    <a href="${pageContext.request.contextPath}/upload/down?fileName=toux.jpg&openStyle=inline">预览</a>
    <a href="${pageContext.request.contextPath}/upload/down?fileName=toux.jpg">附件下载</a>
</li>
<li>
    123
    <a href="${pageContext.request.contextPath}/upload/down?fileName=你好.jpg&openStyle=inline">预览</a>
    <a href="${pageContext.request.contextPath}/upload/down?fileName=你好.jpg">附件下载</a>
</li>

</body>
</html>
