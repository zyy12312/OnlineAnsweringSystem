package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;

import java.util.ArrayList;
public interface CourseDao extends Dao {
    //添加课程方法
    public boolean addCourse (Course Course) throws DaoException;

    // 按id删除课程方法
    public boolean delCourse (int id) throws DaoException;

    // 按id查询课程方法
	public Course findById (int id) throws DaoException;

    // 按name查询课程方法
    public Course findByName (String name) throws DaoException;

    // 查询所有课程方法
    public ArrayList<Course> findAllCourse ()throws DaoException;


    //修改课程信息
    public boolean update (Course Course) throws DaoException;
}

