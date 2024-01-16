package main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean;

import java.sql.Timestamp;

public class Reply {
   private int reply_id;
   private int question_id;
   private String content;
   private Timestamp date;
   private int sender; //1老师，0学生

   public int getSender() {
      return sender;
   }

   public void setSender(int sender) {
      this.sender = sender;
   }

   public Reply() {
   }

   public int getReply_id() {
      return reply_id;
   }

   public void setReply_id(int reply_id) {
      this.reply_id = reply_id;
   }

   public int getQuestion_id() {
      return question_id;
   }

   public void setQuestion_id(int question_id) {
      this.question_id = question_id;
   }


   public Timestamp getDate() {
      return date;
   }

   public void setDate(Timestamp date) {
      this.date = date;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }
}
