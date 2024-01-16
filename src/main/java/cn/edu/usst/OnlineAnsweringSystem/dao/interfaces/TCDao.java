package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.TC;

import java.util.ArrayList;

public interface TCDao extends Dao {
    //添加
    public boolean addTC (TC tc) throws DaoException;

    // 按id删除
    public boolean delTC (TC tc) throws DaoException;

    // 按TID查询TC记录（一个teacher可能有多个course）
    public ArrayList<TC> findByTId (int tid) throws DaoException;

    // 按CID查询TC记录（一个course只能有一个teacher）
    public TC findByCId (int cid) throws DaoException;

    //按CID找到TC记录之后更新score
    public boolean updateScore (int cid, float score) throws DaoException;

}
