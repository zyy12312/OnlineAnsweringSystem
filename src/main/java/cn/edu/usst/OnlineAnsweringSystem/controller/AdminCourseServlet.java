package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.CourseDBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="AdminCourseServlet",value={"/abc.do"})
public class AdminCourseServlet extends DaoException {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读所有课程
        ArrayList<Course> coursesList = CourseDBUtil.findAllCourse();
        //titleList
        ArrayList<String> titleList=getTitleList();
        //传给主页面
        request.setAttribute("infoList", coursesList);
        request.setAttribute("titleList", titleList);
        request.getServletContext().getRequestDispatcher("/adminModify.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    ArrayList<String> getTitleList(){
        ArrayList<String> titleList=new ArrayList<>();
        titleList.add("id");
        titleList.add("name");
        titleList.add("detail");
        return titleList;
    }
}
