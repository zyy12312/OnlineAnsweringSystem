package main.java.cn.edu.usst.OnlineAnsweringSystem.model.service;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Student;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;

public class CalculateService {
   public static float calculate_avg_score(float score_old,float score_new){
      if(score_old!=0) return (score_old+score_new)/2;
      else return score_new;
   }

   public static int canModify(Student student, int userId, Teacher teacher){
      if(student.getId()!=userId && teacher.getId()!=userId)
         return 0;
      return 1;
   }

}
