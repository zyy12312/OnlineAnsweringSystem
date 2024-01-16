package main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Question implements Serializable {
   private int id;
   private String title;
   private String content;
   private int sid;
   private int cid;
   private int reply_state; //1：已回答；0：未回答
   private int check_state; //1：已查看；0：未查看
   private int open; //1：公开；0：不公开
   private Timestamp date;
   private float score;
   private String file_name;


   public Question() {
   }

   public String getFile_name() {
      return file_name;
   }

   public void setFile_name(String file_name) {
      this.file_name = file_name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public int getSid() {
      return sid;
   }

   public void setSid(int sid) {
      this.sid = sid;
   }

   public int getReply_state() {
      return reply_state;
   }

   public void setReply_state(int reply_state) {
      this.reply_state = reply_state;
   }

   public int getCheck_state() {
      return check_state;
   }

   public void setCheck_state(int check_state) {
      this.check_state = check_state;
   }

   public int getOpen() {
      return open;
   }

   public void setOpen(int open) {
      this.open = open;
   }

   public float getScore() {
      return score;
   }

   public void setScore(float score) {
      this.score = score;
   }

   public Timestamp getDate() {
      return date;
   }

   public void setDate(Timestamp date) {
      this.date = date;
   }

   public int getCid() {
      return cid;
   }

   public void setCid(int cid) {
      this.cid = cid;
   }
}
