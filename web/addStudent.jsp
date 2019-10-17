<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

<form action="addStudent" method="post">
    <label for="fullname">Введите ФИО:
        <input type="text" id="fullname" value="${student.fullname}" name="fullname" />
    </label>  <br />
     <label for="age">Введите возвраст:
        <input type="number" id="age" value="${student.age}" name="age" />
    </label>  <br />
    <label for="task">Введите задание:
        <input type="text" id="task" value="${student.task_id}" name="task" />
    </label>  <br />
    <input type="hidden" name="id" value="${student.id}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>