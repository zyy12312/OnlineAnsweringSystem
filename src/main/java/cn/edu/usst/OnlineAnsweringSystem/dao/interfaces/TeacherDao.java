package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;

import java.util.ArrayList;

public interface TeacherDao extends Dao {
    //添加
    public boolean addTeacher (Teacher teacher) throws DaoException;

    // 按id删除
    public boolean delTeacher (int id) throws DaoException;

    // 按id查询
    public Teacher findById (int id) throws DaoException;

    // 查询所有
    public ArrayList<Teacher> findAllTeacher ()throws DaoException;

    //修改
    public boolean update (Teacher teacher) throws DaoException;
}
