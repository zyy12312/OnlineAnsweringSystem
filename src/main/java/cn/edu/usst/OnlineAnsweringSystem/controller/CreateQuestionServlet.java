package main.java.cn.edu.usst.OnlineAnsweringSystem.controller;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.FormService;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.service.DBService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name="CreateQuestionServlet",value={"/createQuestion.do"})
public class CreateQuestionServlet extends HttpServlet {
    HttpSession session;
    int userId;
    public void init(HttpServletRequest request) {
        session = request.getSession(true);
        userId = (int) session.getAttribute("userId");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init(request);
        //读该同学的所有课程
        List<String> courseNameList= DBService.getCNameListFromSid(userId);
        //传给主页面
        request.setAttribute("courseNameList", courseNameList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/createQuestion.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建磁盘工厂对象
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //创建servlet文件上传核心对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //使用servlet文件上传核心对象ServletFileUpload解析request请求，获取请求中表单提交过来的数据
        List<FileItem> fileItemList = new ArrayList<>();
        try {
            fileItemList = servletFileUpload.parseRequest(request);
        } catch (FileUploadException e) {
            System.out.println(e);
        }
        //获取表单数据
        Map<String,Object> map = FormService.getFormData(fileItemList,diskFileItemFactory,userId);
        Question question = (Question) map.get("question");
        String courseName = (String) map.get("courseName");;
        //将表单数据存入数据库
        DBService.insertQByQAndCName(question,courseName);
        //跳转回主页面
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/questions.do");
        rd.forward(request, response);
    }


}