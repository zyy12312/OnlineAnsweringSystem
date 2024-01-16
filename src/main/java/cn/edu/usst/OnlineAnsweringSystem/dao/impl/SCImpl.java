package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.SCDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.SC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SCImpl implements SCDao {
	// 插入一条SC记录
	public boolean addSC(SC SC) throws DaoException {
		String sql = "INSERT INTO SC VALUES(?,?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, SC.getSid());
			pstmt.setInt(2, SC.getCid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}
	}

	// 删除
	@Override
	public boolean delSC(SC SC) throws DaoException {
		String sql = "delete from SC where sid =? and cid =?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, SC.getSid());
			pstmt.setInt(2, SC.getCid());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<SC> findBySId(int sid) throws DaoException {
		SC SC = null;
		ArrayList<SC> scList = new ArrayList<SC>();
		String sql = "SELECT * FROM SC WHERE SID=?";
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, sid);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				SC = new SC();
				SC.setSid(rst.getInt("sid"));
				SC.setCid(rst.getInt("cid"));
				scList.add(SC);
			}
			return scList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<SC> findByCId(int cid) throws DaoException {
		SC SC = null;
		ArrayList<SC> scList = new ArrayList<SC>();
		String sql = "SELECT * FROM SC WHERE CID=?";
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, cid);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				SC = new SC();
				SC.setSid(rst.getInt("sid"));
				SC.setCid(rst.getInt("cid"));
				scList.add(SC);
			}
			return scList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

