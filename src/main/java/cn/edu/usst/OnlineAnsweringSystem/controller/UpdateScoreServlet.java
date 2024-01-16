package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="UpdateScoreServlet",value={"/updateScore.do"})
public class UpdateScoreServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取出前端传过来的数据（course_id,score）
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        float score = Float.parseFloat((request.getParameter("score")));
        int question_id = Integer.parseInt((request.getParameter("question_id")));
        DBService.updateTCScore(course_id, score, question_id);
    }
}