package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Student;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.StudentDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.TeacherDBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name="LogOutServlet",value={"/logOut.do"})
public class LogOutServlet extends HttpServlet {
    HttpSession session;
    public void init(HttpServletRequest request) {
        session = request.getSession(true);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init(request);
        //删除所有session信息
        session.removeAttribute("userKind");
        session.removeAttribute("userName");
        session.removeAttribute("userId");
        //跳转到登陆页面
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

}
