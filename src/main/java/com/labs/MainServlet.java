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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

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
        ArrayList<String> allLessonToday = new ArrayList<>();
        for (Lesson i : allLesson)
                     if(i.getLocalDateTime().toLocalDate().equals(LocalDate.now()))
                allLessonToday.add("ФИО: " + studentBean.get(i.getStudent_id()).getFullname()+" Время: "+i.getLocalDateTime().toLocalTime());
        req.setAttribute("lessons",allLesson);
        req.setAttribute("lessons_today",allLessonToday);
        req.setAttribute("now", DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDate.now()));
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}