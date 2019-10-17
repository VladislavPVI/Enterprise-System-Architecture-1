<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

<form action="addLesson" method="post">
    <label for="fullname">Введите ФИО:
        <input type="number" id="fullname" value="${lesson.student_id}" name="student_id" />
    </label>  <br />

    <label for="datetime">Введите дату и время:
        <input type="datetime-local" id="datetime" value="${lesson.localDateTime}" name="localDateTime" min=${now} />
    </label>  <br />
    <select name="passenger">
        <c:forEach items="${students}" var="student">
            <option selected="${lesson.student_id}" value="${student.id}"><c:out value="${student.fullname}" /></option>
        </c:forEach>
    </select>

    <input type="hidden" name="id" value="${lesson.id}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>