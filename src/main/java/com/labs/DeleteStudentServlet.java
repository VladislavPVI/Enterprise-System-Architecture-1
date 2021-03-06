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

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
    @EJB
    private StudentBean studentBean;
    @EJB
    private LessonBean lessonBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if (req.getParameter("id")!=null && req.getParameter("id")!="") {
           studentBean.delete(Long.valueOf(req.getParameter("id")));
           List<Lesson> allLesson = lessonBean.getByStudent(Long.valueOf(req.getParameter("id")));
           for (Lesson i : allLesson) lessonBean.delete(i.getId());
       }
        resp.sendRedirect(req.getContextPath()+ "/list");
    }
}
