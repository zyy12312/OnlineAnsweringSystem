package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.*;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.CalculateService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.*;

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

@WebServlet(name="QuestionDetailServlet",value={"/questionDetail.do"})
public class QuestionDetailServlet extends HttpServlet {
   Question question;
   ArrayList<Reply> replyList;
   Student student;
   Course course;
   Teacher teacher;
   HttpSession session;
   int userId;
   String userKind;
   public void init(HttpServletRequest request) {
      session = request.getSession(true);
      userId = (int) session.getAttribute("userId");
      userKind = (String) session.getAttribute("userKind");
   }
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      init(request);
      //取出前端传过来的数据（question_id）
      int question_id;
      try {
         //前端传过来的question_id
         question_id = Integer.parseInt(request.getParameter("question_id"));
      }catch (Exception e){
         //从AddReplyServlet页面回退时传过来的question_id
         question_id = (int) request.getAttribute("question_id");
      }
      //数据库操作
      Map<String, Object> map = DBService.getInfoFromQid(question_id ,userKind);
      replyList= (ArrayList<Reply>) map.get("replyList");
      question= (Question) map.get("question");
      teacher= (Teacher) map.get("teacher");
      student= (Student) map.get("student");
      course= (Course) map.get("course");

      //能不能删除评论/问题（只有是本人发布的/回答的才可以删除）
      int canModify= CalculateService.canModify(student, userId, teacher);
      //将信息传给详情页
      request.setAttribute("replyList", replyList);
      request.setAttribute("question", question);
      request.setAttribute("canModify", canModify);
      request.setAttribute("teacher", teacher);
      request.setAttribute("student", student);
      request.setAttribute("course_id", course.getId());
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/questionDetail.jsp");
      rd.forward(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
   }
}
