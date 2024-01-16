package main.java.cn.edu.usst.OnlineAnsweringSystem.utils;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.StudentImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.TCImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.StudentDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.TCDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.TC;

import java.util.ArrayList;

public class TCDBUtil {
    static private TCDao tcDao=new TCImpl();

    
    public static boolean addTC(TC tc) {
        try {
            return tcDao.addTC(tc);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static boolean delTC(TC tc) {
        try {
            return tcDao.delTC(tc);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static ArrayList<TC> findByTId(int tid) {
        try {
            return tcDao.findByTId(tid);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static TC findByCId(int cid) {
        try {
            return tcDao.findByCId(cid);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static boolean updateScore(int cid, float score) {
        try {
            return tcDao.updateScore(cid, score);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
