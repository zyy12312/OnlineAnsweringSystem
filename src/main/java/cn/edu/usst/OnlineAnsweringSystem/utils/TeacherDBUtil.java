package main.java.cn.edu.usst.OnlineAnsweringSystem.utils;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.QuestionImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.TeacherImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.QuestionDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.TeacherDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.TC;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;

import java.util.ArrayList;

public class TeacherDBUtil {
    static private TeacherDao teacherDao=new TeacherImpl();
    
    public static boolean addTeacher(Teacher teacher) {
        try {
            return teacherDao.addTeacher(teacher);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static boolean delTeacher(int id) {
        try {
            return teacherDao.delTeacher(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static Teacher findById(int id) {
        try {
            return teacherDao.findById(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static Teacher findByCId(int cid) {
        try {
            TC tc = TCDBUtil.findByCId(cid);
            return teacherDao.findById(tc.getTid());
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static ArrayList<Teacher> findAllTeacher() {
        try {
            return teacherDao.findAllTeacher();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static boolean update(Teacher teacher) {
        try {
            return teacherDao.update(teacher);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }


}
