package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.SC;

import java.util.ArrayList;

public interface SCDao extends Dao {
    // 添加
    public boolean addSC (SC sc) throws DaoException;

    // 删除
    public boolean delSC (SC sc) throws DaoException;

    // 按SID查询SC记录
    public ArrayList<SC> findBySId (int sid) throws DaoException;

    // 按CID查询SC记录
    public ArrayList<SC> findByCId (int cid) throws DaoException;

}
