package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.*;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.CourseDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.QuestionDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.SCDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.TeacherDBUtil;

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

@WebServlet(name="SelectCoursesServlet",value={"/selectCourses.do"})
public class SelectCoursesServlet extends HttpServlet {
    HttpSession session;
    int userId;

    public void init(HttpServletRequest request) {
        session = request.getSession(true);
        userId = (int) session.getAttribute("userId");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init(request);
        //数据库操作
        ArrayList<SelectCoursesInfo> selectCoursesInfoList = DBService.getSelectCListBySid(userId);
        //传给selectCourses.jsp页面
        request.setAttribute("coursesList", selectCoursesInfoList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/selectCourses.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        Map<String, String[]> map = request.getParameterMap();
        //数据库操作
        DBService.insertSC(map,userId);
        //跳转回所有课程界面
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/myCourses.do");
        rd.forward(request, response);
    }

}