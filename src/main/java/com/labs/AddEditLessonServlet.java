package com.labs;

import com.labs.bean.LessonBean;
import com.labs.bean.StudentBean;
import com.labs.domain.Lesson;
import com.labs.domain.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/addLesson")
public class AddEditLessonServlet extends HttpServlet {

    @EJB
    private LessonBean lessonBean;

    @EJB
    private StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        List<Student> allStudent = studentBean.getAll();
        req.setAttribute("students",allStudent);
        req.setAttribute("now", LocalDateTime.now());
        if (req.getParameter("edit") != null) {
            long id = Long.valueOf(req.getParameter("edit"));
            Lesson lesson = lessonBean.get(id);
            req.setAttribute("lesson", lesson);
        }

        req.getRequestDispatcher("/addLesson.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

      java.time.LocalDateTime dateTime = LocalDateTime.parse(req.getParameter("localDateTime"));
      Long student_id = Long.valueOf(req.getParameter("student_id"));

        if(!req.getParameter("id").equals("")) {
            long id = Long.valueOf(req.getParameter("id"));
            Lesson lesson = lessonBean.get(id);
            lesson.setLocalDateTime(dateTime);
            lesson.setStudent_id(student_id);
            lessonBean.update(lesson);
        }
        else lessonBean.add(new Lesson(dateTime,student_id));
        resp.sendRedirect(req.getContextPath()+ "/list");
    }
}
