<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<H2> Продукты </H2>
<br>

<form:form action="" method="post">

    Наименование : <input type = "text" name = "name">
    <br><br>
    Количество min  <input type = "text" name = countMin">
    Количество max  <input type = "text" name = "countMax">
    <br><br>
    Цена min  <input type = "text" name = "priceMin">
    Цена max  <input type = "text" name = "priceMax">
    <br><br>
    <input type="submit" value="Поиск">

</form:form>
<br><br><br>
<table>
    <tr>
        <th>Наименование</th>
        <th>Описание</th>
        <th>Количество(кг/шт)</th>
        <th>Цена</th>
        <th>Действие</th>
    </tr>
    <c:forEach var="prod" items="${AllProducts}">

        <c:url var="update" value="/update">
            <c:param name="prodId" value="${prod.id}"/>
        </c:url>
        <c:url var="delete" value="/delete">
            <c:param name="prodId" value="${prod.id}"/>
        </c:url>

        <tr>
            <td>${prod.name}</td>
            <td>${prod.description}</td>
            <td>${prod.count}</td>
            <td>${prod.price}</td>
            <td>
                <input type="button" value="Обновить" onclick="window.location.href = '${update}'"/>
                <input type="button" value="Удалить" onclick="window.location.href = '${delete}'"/>
            </td>
        </tr>

    </c:forEach>

</table>
<br>

<input type="button" value="Добавить" onclick="window.location.href = 'add'"/>
</body>
</html>