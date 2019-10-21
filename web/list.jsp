<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    .center {
        width: 450px; /* Ширина элемента в пикселах */
        padding: 10px; /* Поля вокруг текста */
        margin: auto; /* Выравниваем по центру */
        background: #fc0; /* Цвет фона */

        color: black;
    }
    body {
        background: url(img/bg_header_bottom.jpg);
        color: white;
        background-size: 100%;
        font-size:20px;
    }
</style>
<head>
    <title>Работа с учениками</title>
</head>
<p>
<details>
    <summary>
        Все пользователи:
    </summary>
    (<a href="addStudent">добавить</a>)
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
</details>


<details>
    <summary>
        Все занятия:
    </summary>
(<a href="addLesson">добавить</a>)
    <ol>
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
    </ol>
</details>
<p align="center" style="font-size:30px">
    Привет! Это твой помощник по работе с учениками!</p>
<p align="center" style="font-weight: bold;">
    ${now}</p>

<p align="center" style="font-size:20px">Все занятия сегодня:

    (<a href="addLesson">добавить</a>)
</p>
<div class="center">
<c:if test="${!empty lessons_today}">
    <c:forEach items="${lessons_today}" var="lesson">
        <li>
           ${lesson}
        </li>
    </c:forEach>
</c:if>
<c:if test="${empty lessons_today}">


        Сегодня занятий нет
</c:if>
</div>

    <img src="img/teacher.png" style="position: fixed; bottom: 0; right: 0;">


</body>
</html>