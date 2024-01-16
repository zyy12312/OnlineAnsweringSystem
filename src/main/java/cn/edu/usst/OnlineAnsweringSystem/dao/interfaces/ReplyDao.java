package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Reply;

import java.util.ArrayList;

public interface ReplyDao extends Dao {
    // 添加回复
    public boolean addReply (Reply Reply) throws DaoException;

    // 按id删除回复
    public boolean delReply (int id) throws DaoException;

    // 按Question ID查找回复
    public ArrayList<Reply> findById (int question_id) throws DaoException;

    //修改回复信息
    public boolean update (Reply Reply) throws DaoException;

}
