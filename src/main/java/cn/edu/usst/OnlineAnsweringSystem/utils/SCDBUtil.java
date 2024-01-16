package main.java.cn.edu.usst.OnlineAnsweringSystem.utils;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.SCImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.StudentImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.SCDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.StudentDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.SC;

import java.util.ArrayList;

public class SCDBUtil {
    static private SCDao scDao=new SCImpl();

    
    public static boolean addSC(SC sc) {
        try {
            return scDao.addSC(sc);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static boolean delSC(SC sc) {
        try {
            return scDao.delSC(sc);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static ArrayList<SC> findBySId(int sid) {
        try {
            return scDao.findBySId(sid);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static ArrayList<SC> findByCId(int cid) {
        try {
            return scDao.findByCId(cid);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
