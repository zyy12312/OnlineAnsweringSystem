package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name="AdminCourseServlet",value={"/adminCourse.do"})
public class UserSettingServlet extends HttpServlet {
    HttpSession session;
    int userId;

    public void init(HttpServletRequest request) {
        session = request.getSession(true);
        userId = (int) session.getAttribute("userId");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        Map<String, String[]> map = request.getParameterMap();
        //数据库操作
        DBService.insertSC(map,userId);
        //跳转回userSetting.jsp
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/userSetting.jsp");
        rd.forward(request, response);
    }

}
