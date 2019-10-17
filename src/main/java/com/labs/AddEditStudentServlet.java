package com.labs;

import com.labs.bean.StudentBean;
import com.labs.domain.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddEditStudentServlet extends HttpServlet {

    @EJB
    private StudentBean studentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("edit") != null) {
            long id = Long.valueOf(req.getParameter("edit"));
            Student student = studentBean.get(id);
            req.setAttribute("student", student);
        }
        req.getRequestDispatcher("/addStudent.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String fullname = req.getParameter("fullname");
        int age = Integer.valueOf(req.getParameter("age"));
        String task = req.getParameter("task");

        if(!req.getParameter("id").equals("")) {
            long id = Long.valueOf(req.getParameter("id"));
            Student student = studentBean.get(id);
            student.setAge(age);
            student.setFullname(fullname);
            student.setTask_id(task);

            studentBean.update(student);
        }
        else studentBean.add(new Student(fullname,age,task));
        resp.sendRedirect(req.getContextPath()+ "/list");
    }
}
