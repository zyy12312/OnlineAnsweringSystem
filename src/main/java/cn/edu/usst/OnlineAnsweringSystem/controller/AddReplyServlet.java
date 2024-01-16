package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Reply;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.FormService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name="AddReplyServlet",value={"/addReply.do"})
public class AddReplyServlet extends HttpServlet {
    HttpSession session;
    String userKind;
    public void init(HttpServletRequest request) {
        session = request.getSession(true);
        userKind = (String) session.getAttribute("userKind");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init(request);
        //获取表单数据
        Map<String, String[]> map=request.getParameterMap();
        //处理表单数据
        Reply reply = FormService.getReplyFromMap(map,userKind);
        //数据库操作
        DBService.insertRByRAndUserKind(reply,userKind);
        //跳转回主页面
        request.setAttribute("question_id",reply.getQuestion_id());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/questionDetail.do");
        rd.forward(request, response);
    }


}
