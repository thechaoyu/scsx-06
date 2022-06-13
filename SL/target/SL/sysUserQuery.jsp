<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>userList页面</h1>
<table border="1" width="100%" cellpadding="0" cellspacing="0">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${p}" var="s" varStatus="st">
        <tr>
                <%--<td>${((p.pageNum-1)*p.pageSize)+st.count}</td>--%>
            <td>${s.id}</td>
            <td>${s.username}</td>
            <td>${s.statu}</td>
            <td>${s.email}</td>
            <td>
                <a href="SysUserget?sid=${s.id}">详情</a>
                <a href="SysUserdel?sid=${s.id}" onclick="return confirm('你确定要删除吗?')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
