package main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean;

import java.io.Serializable;

public class TC implements Serializable {
   private int tid;
   private int cid;
   private float ave_score;

   public TC() {
   }

   public int getTid() {
      return tid;
   }

   public void setTid(int tid) {
      this.tid = tid;
   }

   public int getCid() {
      return cid;
   }

   public void setCid(int cid) {
      this.cid = cid;
   }

   public float getAve_score() {
      return ave_score;
   }

   public void setAve_score(float ave_score) {
      this.ave_score = ave_score;
   }
}
