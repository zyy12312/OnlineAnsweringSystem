package main.java.cn.edu.usst.OnlineAnsweringSystem.utils;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.CourseImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.StudentImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.CourseDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.StudentDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.SC;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.TC;

import java.util.ArrayList;
import java.util.List;

public class CourseDBUtil{
    static private CourseDao courseDao=new CourseImpl();

    
    public static boolean addCourse(Course course) {
        try {
            return courseDao.addCourse(course);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static boolean delCourse(int id) {
        try {
            return courseDao.delCourse(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static Course findById(int id) {
        try {
            return courseDao.findById(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static Course findByName(String name) {
        try {
            return courseDao.findByName(name);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static ArrayList<Course> findAllCourse() {
        try {
            return courseDao.findAllCourse();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


    public static ArrayList<Course> findBySid(int sid) {
        try {
            //在SC表中找到该同学的所有课程编号
            ArrayList<SC> scList = SCDBUtil.findBySId(sid);
            //在Course表中找到并返回课程
            ArrayList<Course> courseList=new ArrayList<>();
            for(SC sc:scList)
                courseList.add(CourseDBUtil.findById(sc.getCid()));
            return courseList;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Course> findByTid(int tid) {
        try {
            //在TC表中找到该老师的所有课程编号
            ArrayList<TC> tcList = TCDBUtil.findByTId(tid);
            //在Course表中找到并返回课程
            ArrayList<Course> courseList=new ArrayList<>();
            for(TC tc:tcList)
                courseList.add(CourseDBUtil.findById(tc.getCid()));
            return courseList;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static boolean update(Course course) {
        try {
            return courseDao.update(course);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
