package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.CourseDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.QuestionDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.StudentDBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@WebServlet(name="QuestionsServlet",value={"/questions.do"})
public class QuestionsServlet extends HttpServlet {
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
        //读该user的所有问题，并读出每一个问题的课程名，以及统计有多少未读信息
        Map<String, Object> map = DBService.getQInfoFromUserInfo(userId, userKind);
        ArrayList<Question> questionList = (ArrayList<Question>) map.get("questionList");
        Map<Integer, String> courseNameMap = (Map<Integer, String>) map.get("courseNameMap");
        Map<Integer, String> studentNameMap = (Map<Integer, String>) map.get("studentNameMap");
        int unchecked_num = (int) map.get("unchecked_num");
        //传给主页面
        request.setAttribute("unchecked_num", unchecked_num);
        request.setAttribute("questionList", questionList);
        request.setAttribute("courseNameMap", courseNameMap);
        request.setAttribute("studentNameMap", studentNameMap);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/questions.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
