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
import java.util.List;

@WebServlet("/list")
public class MainServlet extends HttpServlet {
    @EJB
    private LessonBean lessonBean;

    @EJB
    private StudentBean studentBean;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> allStudent = studentBean.getAll();
        req.setAttribute("students",allStudent);
        List<Lesson> allLesson = lessonBean.getAll();
        req.setAttribute("lessons",allLesson);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}