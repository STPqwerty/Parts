<!-- обратите внимание на spring тэги -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
</head>


<body>
<table class="tg" border="1">
    <tr>
        <th width="180">Наименование</th>
        <th width="40">Необходимость</th>
        <th width="80">Кол-во</th>
    </tr>
    <c:forEach items="${model.parts}" var="p">
        <tr>
            <td>${p.name}</td>

            <c:if test="${p.requared}">
                <td>Да</td>
            </c:if>
            <c:if test="${!p.requared}">
                <td>Нет</td>
            </c:if>

            <td>${p.count}</td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan = "3">Можно собрать: ${model.compCount} компьютеров</th>
    </tr>
    <tr>
        <th colspan = "3">
        <c:forEach items="${curentPage}" var="page">
        <a href="/parts/${page}">  ${page} </a> &#8195; </c:forEach></th>
    </tr>
</table>
</body>

</html>

