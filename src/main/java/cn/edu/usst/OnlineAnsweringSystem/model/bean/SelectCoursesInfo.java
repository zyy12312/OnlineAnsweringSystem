package main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean;

public class SelectCoursesInfo {
   private int courseId;
   private String courseName;
   private String teacherName;
   private String teacherLevel;
   private String teacherAvatar;
   private int courseStatus; //未选：1，已选：2，已满：3
   //private String time;

   public SelectCoursesInfo() {
   }

   public int getCourseId() {
      return courseId;
   }

   public String getTeacherAvatar() {
      return teacherAvatar;
   }

   public void setTeacherAvatar(String teacherAvatar) {
      this.teacherAvatar = teacherAvatar;
   }

   public void setCourseId(int courseId) {
      this.courseId = courseId;
      if (courseId % 4 == 0) {
         setCourseStatus(3);
      }
   }

   public String getCourseName() {
      return courseName;
   }

   public void setCourseName(String courseName) {
      this.courseName = courseName;
   }

   public String getTeacherName() {
      return teacherName;
   }

   public void setTeacherName(String teacherName) {
      this.teacherName = teacherName;
   }

   public String getTeacherLevel() {
      return teacherLevel;
   }

   public void setTeacherLevel(String teacherLevel) {
      this.teacherLevel = teacherLevel;
   }

   public int getCourseStatus() {
      return courseStatus;
   }

   public void setCourseStatus(int courseStatus) {
      this.courseStatus = courseStatus;
   }

}
