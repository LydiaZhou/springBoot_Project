<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Editting Page</title>
    </head>
    <body>
<%--        <th:block th:include="/_header"></th:block>--%>
<%--        <th:block th:include="/_menu"></th:block>--%>

        <div class="page-title">Food List</div>

        <table>
            <c:forEach items="${fruits}" var="dataItem">
                <tr>
                    <td><img src="${dataItem.img}"></img></td>
                    <td>${dataItem.foodName}</td>
                    <td>${dataItem.calories}</td>
                    <td>${dataItem.category}</td>
                </tr>
            </c:forEach>
        </table>

<%--        <th:block th:include="/_footer"></th:block>--%>
    </body>
</html>