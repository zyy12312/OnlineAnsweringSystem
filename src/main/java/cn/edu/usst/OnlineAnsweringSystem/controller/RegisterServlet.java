package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Student;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.StudentDBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*只可以注册学生账号*/
@WebServlet(name="RegisterServlet",value={"/register.do"})
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端数据
        int userId = Integer.parseInt(request.getParameter("ID"));
        String password = request.getParameter("Password");
        String userName = request.getParameter("UserName");
        //LoginService.isRepeat(request,response,userId);
        //编号是否重复
        for (Student student : StudentDBUtil.findAllStudent())
            if (student.getId() == userId)
                error(request, response, "ID has already existed");
        //将该数据加入数据库
        DBService.insertSBySInfos(userName,userId,password);
        //在session中存用户信息
        HttpSession session = request.getSession(true);
        session.setAttribute("userId", userId);
        session.setAttribute("userName", userName);
        session.setAttribute("userKind", "student");
        //跳转回主页面
        getServletContext().getRequestDispatcher("/questions.do").forward(request, response); //学生主界面
    }

    public static void error(HttpServletRequest request, HttpServletResponse response,String content) throws ServletException, IOException {
        request.setAttribute("errorContent", content);
        request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response); //error界面
    }
}
