package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.QuestionDBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="DeleteQuestionServlet",value={"/deleteQuestion.do"})
public class DeleteQuestionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //取出前端传过来的数据（question_id）
        int question_id = Integer.parseInt(request.getParameter("question_id2"));
        //删除
        QuestionDBUtil.delQuestion(question_id);
        //回到该界面
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/questions.do");
        rd.forward(request, response);
    }
}