package main.java.cn.edu.usst.OnlineAnsweringSystem.utils;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.StudentImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl.TeacherImpl;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.StudentDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Student;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;

import java.util.ArrayList;

public class StudentDBUtil{
    static private StudentDao studentDao=new StudentImpl();

    
    public static boolean addStudent(Student student){
        try {
            return studentDao.addStudent(student);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static boolean delStudent(int id){
        try {
            return studentDao.delStudent(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    
    public static Student findById(int id){
        try {
            return studentDao.findById(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static ArrayList<Student> findAllStudent(){
        try {
            return studentDao.findAllStudent();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    
    public static boolean update(Student student){
        try {
            return studentDao.update(student);
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
