package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Student;

import java.util.ArrayList;

public interface StudentDao extends Dao {
    //添加
    public boolean addStudent (Student student) throws DaoException;

    // 按id删除
    public boolean delStudent (int id) throws DaoException;

    // 按id查询
    public Student findById (int id) throws DaoException;

    // 查询所有
    public ArrayList<Student> findAllStudent ()throws DaoException;

    //修改
    public boolean update (Student student) throws DaoException;
}
