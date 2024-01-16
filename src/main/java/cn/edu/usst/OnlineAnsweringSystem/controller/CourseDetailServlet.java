package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.*;
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

@WebServlet(name="CourseDetailServlet",value={"/courseDetail.do"})
public class CourseDetailServlet extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //取出前端传过来的数据（course_id）
      int course_id = Integer.parseInt(request.getParameter("course_id"));
      //数据库操作
      Map<String, Object> map = DBService.getInfoByCid(course_id);
      Course course = (Course) map.get("course");
      ArrayList<Question> questionList = (ArrayList<Question>) map.get("questionList");
      //将信息传给详情页
      request.setAttribute("course", course);
      request.setAttribute("questionList", questionList);
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/courseDetail.jsp");
      rd.forward(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
   }
}
