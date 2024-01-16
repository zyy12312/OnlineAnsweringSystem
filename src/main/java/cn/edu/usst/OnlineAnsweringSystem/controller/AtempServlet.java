package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.CourseDBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="ATempServlet",value={"/admin.do"})
public class AtempServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        //读所有课程
        ArrayList<Course> coursesList = CourseDBUtil.findAllCourse();
        //titleList
        ArrayList<String> titleList=getTitleList();
        //传给主页面
        request.setAttribute("infoList", coursesList);
        request.setAttribute("titleList", titleList);
        getServletContext().getRequestDispatcher("/adminModify.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
    }

    ArrayList<String> getTitleList(){
        ArrayList<String> titleList=new ArrayList<>();
        titleList.add("id");
        titleList.add("name");
        titleList.add("detail");
        return titleList;
    }

}
