<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>Продукт</h2>
<br>

<form:form action="save" modelAttribute="product">

    <form:hidden path="id"/>

    Наименование <form:input path="name"/>
    <br><br>
    Описание <form:input path="description"/>
    <br><br>
    Количество <form:input path="count"/>
    <br><br>
    Цена <form:input path="price"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>
</body>
</html>