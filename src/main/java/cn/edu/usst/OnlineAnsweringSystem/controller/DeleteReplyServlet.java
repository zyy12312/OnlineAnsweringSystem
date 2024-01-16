package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.ReplyDBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="DeleteReplyServlet",value={"/deleteReply.do"})
public class DeleteReplyServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //取出前端传过来的数据（reply_id）
        int reply_id = Integer.parseInt(request.getParameter("reply_id"));
        //删除
        ReplyDBUtil.delReply(reply_id);
        //回到该界面
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/questionDetail.do");
        rd.forward(request, response);
    }
}