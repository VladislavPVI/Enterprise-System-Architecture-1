<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>

<h3>Все пользователи:</h3>(<a href="addStudent">добавить</a>)
<ol>
    <c:forEach items="${students}" var="student">
        <li>
            Fullname: ${student.fullname}
            Age: ${student.age}
            Task: ${student.task_id}
            <a href="addStudent?edit=${student.id}">редактировать</a> | <a href="delete?id=${student.id}">удалить</a>

        </li>
    </c:forEach>

</ol>
<h3>Все занятия:</h3>(<a href="addLesson">добавить</a>)
<c:forEach items="${lessons}" var="lesson">
    <li>
        Fullname: ${lesson.student_id}
        Date: ${lesson.localDateTime}
        <a href="addLesson?edit=${lesson.id}">редактировать</a> | <a href="delete?id=${lesson.id}">удалить</a>

    </li>
</c:forEach>
</body>
</html>