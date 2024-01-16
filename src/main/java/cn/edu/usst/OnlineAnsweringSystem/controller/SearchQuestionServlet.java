package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.TC;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.SearchService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.CourseDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.QuestionDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.TCDBUtil;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.TeacherDBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="SearchQuestionServlet",value={"/searchQuestion.do"})
public class SearchQuestionServlet extends HttpServlet {
    ArrayList<Course> courseList;
    ArrayList<Teacher> teacherList;
    ArrayList<Question> questionList;


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        Map<String, String[]> map = request.getParameterMap();
        String content = map.get("search")[0];
        //开始按照标题/课程/老师进行搜索
        search(content);
        //数据库查找操作
        Map<Integer, String> courseNameMap = DBService.getSelectQListByTAndC(courseList,teacherList,questionList);
        //跳转回主页面
        request.setAttribute("unchecked_num", 0);
        request.setAttribute("questionList", questionList);
        request.setAttribute("courseNameMap", courseNameMap);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/questions.jsp");
        rd.forward(request, response);
    }

    public void search (String content){
        courseList = SearchService.searchInCourses(CourseDBUtil.findAllCourse(),content);
        teacherList = SearchService.searchInTeachers(TeacherDBUtil.findAllTeacher(),content);
        questionList = SearchService.searchInQuestion(QuestionDBUtil.findAllQuestion(),content);
    }
}