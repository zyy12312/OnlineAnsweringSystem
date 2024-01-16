package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
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

@WebServlet(name="AdminTeacherServlet",value={"/adminTeacher.do"})
public class AdminTeacherServlet extends HttpServlet {

    HttpSession session;
    int userId;

    public void init(HttpServletRequest request) {
        session = request.getSession(true);
        userId = (int) session.getAttribute("userId");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读所有课程
        ArrayList<Teacher> teachersList = TeacherDBUtil.findAllTeacher();
        //titleList
        ArrayList<String> titleList=getTitleList();
        //传给主页面
        request.setAttribute("infoList", teachersList);
        request.setAttribute("titleList", titleList);
        getServletContext().getRequestDispatcher("/adminModify.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init(request);
        //获取表单数据
        Map<String, String[]> map = request.getParameterMap();
        //数据库操作
        DBService.insertSC(map,userId);
        //跳转回adminModify.jsp
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminModify.jsp");
        rd.forward(request, response);
    }

    ArrayList<String> getTitleList(){
        ArrayList<String> titleList=new ArrayList<>();
        titleList.add("id");
        titleList.add("name");
        titleList.add("password");
        titleList.add("detail");
        titleList.add("level");
        return titleList;
    }

}
