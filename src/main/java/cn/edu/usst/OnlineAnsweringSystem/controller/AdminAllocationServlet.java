package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.CourseDBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name="AdminCourseServlet",value={"/adminCourse.do"})
public class AdminAllocationServlet extends HttpServlet {
    HttpSession session;
    int userId;

    public void init(HttpServletRequest request) {
        session = request.getSession(true);
        userId = (int) session.getAttribute("userId");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init(request);
        //获取表单数据
        Map<String, String[]> map = request.getParameterMap();
        //数据库操作
        DBService.insertSC(map,userId);
        //跳转回adminAllocation.jsp
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminAllocation.jsp");
        rd.forward(request, response);
    }

}
