<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    body {
        background: url(img/bg_header_bottom.jpg) repeat-y;
        color: white;
    }
</style>
<head>
    <title>Список пользователей</title>
</head>
<body>

<h3>Все пользователи:</h3>(<a href="addStudent">добавить</a>)
<ol>
    <c:forEach items="${students}" var="student">
        <li>
            ФИО: ${student.fullname}
            Возраст: ${student.age}
            Задание: ${student.task_id}
            <a href="addStudent?edit=${student.id}">редактировать</a> | <a href="delete?id=${student.id}">удалить</a>

        </li>
    </c:forEach>

</ol>
<h3>Все занятия:</h3>(<a href="addLesson">добавить</a>)
<c:forEach items="${lessons}" var="lesson">
    <li>
        ФИО:

        <c:forEach items="${students}" var="student">
        <c:if test="${student.id==lesson.student_id}">
            ${student.fullname}
        </c:if>
    </c:forEach>
        Дата: ${lesson.localDateTime}
        <a href="addLesson?edit=${lesson.id}">редактировать</a> | <a href="deleteLesson?id=${lesson.id}">удалить</a>

    </li>
</c:forEach>

    <img src="img/teacher.png" style="float: right;">


</body>
</html>