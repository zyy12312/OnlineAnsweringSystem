package main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean;

import java.io.Serializable;

public class Course implements Serializable {
   private int id;
   private String name;
   private String detail;



   public Course() {
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDetail() {
      return detail;
   }

   public void setDetail(String detail) {
      this.detail = detail;
   }
}
