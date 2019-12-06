<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    request.setAttribute("path", request.getContextPath());
%>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="${path}/regist.jsp">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Date
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach items="${list}" var="l">
                    <tr class="row1">
                        <td>
                                ${l.ee_id}
                        </td>
                        <td>
                                ${l.ee_name}
                        </td>
                        <td>
                                ${l.ee_salary}
                        </td>
                        <td>
                                ${l.ee_age}
                        </td>
                        <td>
                            <fmt:formatDate value="${l.ee_date}" pattern="yyyy-MM-dd"/>

                        </td>
                        <td>
                            <a href="${path}/Emp/deleteOne?id=${l.ee_id}">delete emp</a>&nbsp;
                            <a href="${path}/Emp/findOne?id=${l.ee_id}">update emp</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${path}/addEmp.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
