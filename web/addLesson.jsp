<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

<form action="addLesson" method="post">

    <label for="datetime">Дата и время занятия:
        <input type="datetime-local" id="datetime" value="${lesson.localDateTime}" name="localDateTime"  />
    </label>  <br />

    <label>ФИО ученика:
       ${student.fullname}
    </label>

    <select name="student_id" required>
        <option value="${lesson.student_id}">Изменить</option>
        <c:forEach items="${students}" var="student">
            <option value="${student.id}"><c:out value="${student.fullname}" /></option>
        </c:forEach>
    </select>
    <br />
    <input type="hidden" name="id" value="${lesson.id}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>