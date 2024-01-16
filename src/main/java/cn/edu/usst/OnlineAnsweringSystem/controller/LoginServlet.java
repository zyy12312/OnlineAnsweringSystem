package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


@WebServlet(name="LoginServlet",value={"/login.do"})
public class LoginServlet extends HttpServlet {
    String userName;
    String userKind;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端数据
        int userId = Integer.parseInt(request.getParameter("ID"));
        String password = request.getParameter("Password");
        //查找该id对应的name和kind
        Map<String, String> map = LoginService.getNameAndKind(userId, password);
        userName=map.get("userName");
        if(map.containsKey("error"))
            error(request, response,map.get("error"));
        userKind=map.get("userKind");
        //在session中存用户信息
        HttpSession session = request.getSession(true);
        session.setAttribute("userId", userId);
        session.setAttribute("userName", userName);
        session.setAttribute("userKind", userKind);
        //跳转到主页面
        if(userKind.equals("admin"))
            getServletContext().getRequestDispatcher("/adminWelcome.jsp").forward(request, response); //管理员主界面
        else if(userKind.equals("student"))
            getServletContext().getRequestDispatcher("/questions.do").forward(request, response); //老师和学生主界面
        else
            getServletContext().getRequestDispatcher("/myCourses.do").forward(request, response); //老师和学生主界面
    }

    public static void error(HttpServletRequest request, HttpServletResponse response,String content) throws ServletException, IOException {
        request.setAttribute("errorContent", content);
        request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response); //error界面
    }
}
