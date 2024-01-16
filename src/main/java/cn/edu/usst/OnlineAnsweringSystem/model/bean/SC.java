package main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean;

import java.io.Serializable;

public class SC implements Serializable {
   private int sid;
   private int cid;

   public SC() {
   }

   public int getSid() {
      return sid;
   }

   public void setSid(int sid) {
      this.sid = sid;
   }

   public int getCid() {
      return cid;
   }

   public void setCid(int cid) {
      this.cid = cid;
   }

}
