package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;

import java.util.ArrayList;

public interface QuestionDao extends Dao {
    //添加问题方法
    public boolean addQuestion (Question question) throws DaoException;

    // 按id删除问题方法
    public boolean delQuestion (int id) throws DaoException;

    // 查询
    public ArrayList<Question> query (String sql,Object[] objects)throws DaoException;

    //修改问题信息
    public boolean update (Question question) throws DaoException;
}
