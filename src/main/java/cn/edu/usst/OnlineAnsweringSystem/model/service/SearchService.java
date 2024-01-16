package main.java.cn.edu.usst.OnlineAnsweringSystem.model.service;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;

import java.util.ArrayList;

public class SearchService {

   public static ArrayList<Teacher> searchInTeachers(ArrayList<Teacher> teacherList, String target){
      ArrayList<Teacher> newTeacherList = new ArrayList<>();
      for(Teacher teacher:teacherList){
         if(teacher.getName().contains(target))
            newTeacherList.add(teacher);
      }
      return newTeacherList;
   }

   public static ArrayList<Course> searchInCourses(ArrayList<Course> courseList, String target){
      ArrayList<Course> newCourseList = new ArrayList<>();
      for(Course course:courseList){
         if(course.getName().contains(target))
            newCourseList.add(course);
      }
      return newCourseList;
   }

   public static ArrayList<Question> searchInQuestion(ArrayList<Question> questionList, String target){
      ArrayList<Question> newQuestionList = new ArrayList<>();
      for(Question question:questionList){
         if(question.getTitle().contains(target))
            newQuestionList.add(question);
      }
      return newQuestionList;
   }
   
}
