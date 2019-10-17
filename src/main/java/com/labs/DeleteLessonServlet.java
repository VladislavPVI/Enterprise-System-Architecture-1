package com.labs;

import com.labs.bean.LessonBean;
import com.labs.bean.StudentBean;
import com.labs.domain.Lesson;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteLesson")
public class DeleteLessonServlet extends HttpServlet {

    @EJB
    private LessonBean lessonBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if (req.getParameter("id")!=null && req.getParameter("id")!="") {
           lessonBean.delete(Long.valueOf(req.getParameter("id")));
       }
        resp.sendRedirect(req.getContextPath()+ "/list");
    }
}
