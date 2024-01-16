package main.java.cn.edu.usst.OnlineAnsweringSystem.model.service;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.*;
import main.java.cn.edu.usst.OnlineAnsweringSystem.utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBService {

   public static List<String> getCNameListFromSid(int sid){
      //在SC表中找到该同学的所有课程编号
      ArrayList<SC> scList = SCDBUtil.findBySId(sid);
      //在Course表中找到返回课程名
      List<String> courseNameList=new ArrayList<>();
      for(SC sc:scList)
         courseNameList.add(CourseDBUtil.findById(sc.getCid()).getName());
      return courseNameList;
   }

   public static void insertQByQAndCName(Question question, String courseName){
      //通过courseName找到cid
      question.setCid(CourseDBUtil.findByName(courseName).getId());
      //将表单数据存入数据库
      QuestionDBUtil.addQuestion(question);
   }

   public static void insertSBySInfos(String userName,int userId, String password){
      Student student = new Student();
      student.setName(userName);
      student.setId(userId);
      student.setPassword(password);
      StudentDBUtil.addStudent(student);
   }
   public static void insertRByRAndUserKind(Reply reply, String userKind){
      //将reply存入数据库
      ReplyDBUtil.addReply(reply);
      //查找出该question
      Question question = QuestionDBUtil.findByQid(reply.getQuestion_id());
      //将Question的状态进行改变：如果是老师，则reply_state设置为1。如果是学生，则reply_state设置为0
      if(userKind.equals("student"))
         question.setReply_state(0);
      else question.setReply_state(1);
      QuestionDBUtil.update(question);
   }

   public static ArrayList<SelectCoursesInfo> getSelectCList(int userId, String userKind){
      //读该user的所有课程
      ArrayList<SelectCoursesInfo> selectCoursesInfoList=new ArrayList<>();
      ArrayList<Course> courseList;
      if(userKind.equals("student"))
         courseList = CourseDBUtil.findBySid(userId);
      else courseList = CourseDBUtil.findByTid(userId);
      //读课程对应的老师
      for(Course course:courseList) {
         Teacher teacher = TeacherDBUtil.findByCId(course.getId());
         SelectCoursesInfo info=new SelectCoursesInfo();
         info.setCourseId(course.getId());
         info.setCourseName(course.getName());
         info.setTeacherName(teacher.getName());
         info.setTeacherAvatar(teacher.getAvatar());
         info.setTeacherLevel(teacher.getLevel());
         selectCoursesInfoList.add(info);
      }
      return selectCoursesInfoList;
   }

   public static Map<String, Object> getInfoFromQid(int question_id, String userKind){
      //读出这个问题的全部信息
      Question question = QuestionDBUtil.findByQid(question_id);
      //user是学生，且reply=1,check=0 ：check改为1
      if(userKind.equals("student") && question.getReply_state()==1 && question.getCheck_state()==0) {
         //状态发生变化
         question.setCheck_state(1);
         //更新到数据库
         QuestionDBUtil.update(question);
      }
      Map<String, Object> map=new HashMap<>();
      //读出这个问题中存的所有评论
      map.put("replyList" , ReplyDBUtil.findById(question.getId()));
      //读学生名字
      map.put("student" , StudentDBUtil.findById(question.getSid()));
      //读课程名字
      Course course=CourseDBUtil.findById(question.getCid());
      map.put("course" , course);
      //读老师id
      TC tc = TCDBUtil.findByCId(course.getId());
      //读老师名字
      map.put("teacher" , TeacherDBUtil.findById(tc.getTid()));
      map.put("question" , question);

      return map;
   }

   public static Map<String, Object> getInfoByCid(int course_id){
      Map<String, Object> map=new HashMap<>();
      //读课程信息
      map.put("course", CourseDBUtil.findById(course_id));
      //读这个课程有关的question
      map.put("questionList", QuestionDBUtil.findByCid_All(course_id));
      return map;
   }

   public static Map<String, Object> getQInfoFromUserInfo(int userId, String userKind){
      int unchecked_num=0;
      ArrayList<Question> questionList;
      Map<Integer, String> courseNameMap = new HashMap<>();
      Map<Integer, String> studentNameMap = new HashMap<>();
      Map<String, Object> map=new HashMap<>();
      if(userKind.equals("student")) {//user是学生
         //读该user的所有问题
         questionList = QuestionDBUtil.findBySid(userId);
         for (Question question : questionList) {
            //统计有多少未读信息
            if (question.getReply_state() == 1 && question.getCheck_state() == 0)
               unchecked_num++;
            //读出每一个问题的课程名和提问学生名
            courseNameMap.put(question.getCid(), CourseDBUtil.findById(question.getCid()).getName());
            studentNameMap.put(question.getSid(), StudentDBUtil.findById(question.getSid()).getName());
         }
      }
      else{ //user是老师
         //读该user的所有问题
         questionList = QuestionDBUtil.findByTid(userId);
         for (Question question : questionList) {
            //统计有多少未回复信息
            if (question.getReply_state() == 0)
               unchecked_num++;
            //读出每一个问题的课程名和提问学生名
            courseNameMap.put(question.getCid(), CourseDBUtil.findById(question.getCid()).getName());
            studentNameMap.put(question.getSid(), StudentDBUtil.findById(question.getSid()).getName());
         }
      }
      map.put("unchecked_num",unchecked_num);
      map.put("questionList",questionList);
      map.put("courseNameMap",courseNameMap);
      map.put("studentNameMap",studentNameMap);
      return map;
   }

   public static ArrayList<SelectCoursesInfo> getSelectCListByTAndC(ArrayList<Teacher> teacherList, ArrayList<Course> courseList){
      //筛选到teacherList之后，找到这个老师负责的所有course，加入courseList
      for(Teacher teacher:teacherList) {
         ArrayList<TC> tcList = TCDBUtil.findByTId(teacher.getId());
         for(TC tc:tcList) {
            courseList.add(CourseDBUtil.findById(tc.getCid()));
         }
      }
      ArrayList<SelectCoursesInfo> selectCoursesInfoList = new ArrayList<>();
      //读课程对应的老师
      for(Course course:courseList) {
         Teacher teacher = TeacherDBUtil.findByCId(course.getId());
         SelectCoursesInfo info=new SelectCoursesInfo();
         info.setCourseId(course.getId());
         info.setCourseName(course.getName());
         info.setTeacherName(teacher.getName());
         info.setTeacherAvatar(teacher.getAvatar());
         info.setTeacherLevel(teacher.getLevel());
         selectCoursesInfoList.add(info);
      }
      return selectCoursesInfoList;
   }

   public static Map<Integer, String> getSelectQListByTAndC(ArrayList<Course> courseList, ArrayList<Teacher> teacherList, ArrayList<Question> questionList){
      //筛选到teacherList之后，找到这个老师负责的所有course，加入courseList
      Map<Integer, String> courseNameMap = new HashMap<>();
      for(Teacher teacher:teacherList) {
         ArrayList<TC> tcList = TCDBUtil.findByTId(teacher.getId());
         for(TC tc:tcList) {
            courseList.add(CourseDBUtil.findById(tc.getCid()));
         }
      }
      //筛选到courseList之后，找到这个course的所有question，加入questionList
      for(Course course:courseList){
         questionList.addAll(QuestionDBUtil.findByCid_All(course.getId()));
      }
      //找到所有questionList的courseName
      for (Question question : questionList) {
         courseNameMap.put(question.getCid(), CourseDBUtil.findById(question.getCid()).getName());
      }
      return courseNameMap;
   }

   public static ArrayList<SelectCoursesInfo> getSelectCListBySid(int sid){
      ArrayList<Integer> userCourseList = new ArrayList<>();
      ArrayList<SelectCoursesInfo> selectCoursesInfoList = new ArrayList<>();
      //读该同学的所有课程的id
      for (Course course : CourseDBUtil.findBySid(sid))
         userCourseList.add(course.getId());
      //读全部课程
      ArrayList<Course> allCourseList = CourseDBUtil.findAllCourse();
      for (Course course : allCourseList) {
         SelectCoursesInfo selectCoursesInfo = new SelectCoursesInfo();
         //读课程对应的教师
         Teacher teacher = TeacherDBUtil.findByCId(course.getId());
         if (userCourseList.contains(course.getId()))
            selectCoursesInfo.setCourseStatus(2);
         else selectCoursesInfo.setCourseStatus(1);
         selectCoursesInfo.setTeacherLevel(teacher.getLevel());
         selectCoursesInfo.setTeacherName(teacher.getName());
         selectCoursesInfo.setTeacherAvatar(teacher.getAvatar());
         selectCoursesInfo.setCourseName(course.getName());
         selectCoursesInfo.setCourseId(course.getId());
         selectCoursesInfoList.add(selectCoursesInfo);
      }
      return selectCoursesInfoList;
   }

   public static void insertSC(Map<String, String[]> map, int userId){
      for (String cid : map.keySet()) {
         //将这些cid存入SC表
         SC sc = new SC();
         sc.setCid(Integer.parseInt(cid));
         sc.setSid(userId);
         SCDBUtil.addSC(sc);
      }
   }

   public static void updateTCScore(int course_id, float score, int question_id){
      //获取question
      Question question = QuestionDBUtil.findByQid(question_id);
      //计算平均score
      question.setScore(CalculateService.calculate_avg_score(question.getScore(), score));
      //更新question的score
      QuestionDBUtil.update(question);
      //取出TC的score
      TC tc = TCDBUtil.findByCId(course_id);
      //计算平均score
      score=CalculateService.calculate_avg_score(tc.getAve_score(),score);
      //更新TC的score
      TCDBUtil.updateScore(course_id, score);
   }

}
