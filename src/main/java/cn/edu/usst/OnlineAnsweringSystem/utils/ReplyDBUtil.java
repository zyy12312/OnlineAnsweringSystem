package main.java.cn.edu.usst.OnlineAnsweringSystem.utils;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.ReplyImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.StudentImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.ReplyDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.StudentDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Reply;

import java.util.ArrayList;

public class ReplyDBUtil{
    static private ReplyDao replyDao=new ReplyImpl();

    
    public static boolean addReply(Reply reply) {
        try {
            return replyDao.addReply(reply);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static boolean delReply(int id) {
        try {
            return replyDao.delReply(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static ArrayList<Reply> findById(int question_id) {
        try {
            return replyDao.findById(question_id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static boolean update(Reply reply) {
        try {
            return replyDao.update(reply);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
