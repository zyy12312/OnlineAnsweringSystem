package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.TCDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.TC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TCImpl implements TCDao {
	// 插入一条TC记录
	public boolean addTC(TC TC) throws DaoException {
		String sql = "INSERT INTO TC VALUES(?,?,?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, TC.getTid());
			pstmt.setInt(2, TC.getCid());
			pstmt.setFloat(3, TC.getAve_score());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}
	}

	// 按id删除TC方法
	@Override
	public boolean delTC(TC tc) throws DaoException {
		String sql = "delete from TC where tid =? and cid=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, tc.getTid());
			pstmt.setInt(2, tc.getCid());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}

	// 按TID查询TC记录
	@Override
	public ArrayList<TC> findByTId(int tid) throws DaoException {
		TC TC = null;
		ArrayList<TC> custList = new ArrayList<TC>();
		String sql = "SELECT * FROM TC WHERE TID=?";
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, tid);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				TC = new TC();
				TC.setTid(rst.getInt("tid"));
				TC.setCid(rst.getInt("cid"));
				TC.setAve_score(rst.getFloat("ave_score"));
				custList.add(TC);
			}
			return custList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 按CID查询TC记录
	@Override
	public TC findByCId(int cid) throws DaoException {
		String sql = "SELECT * FROM TC WHERE CID =?";
		TC TC = new TC();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, cid);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					TC.setTid(rst.getInt("tid"));
					TC.setCid(rst.getInt("cid"));
					TC.setAve_score(rst.getFloat("ave_score"));
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return TC;

	}

	@Override
	public boolean updateScore(int cid, float score) throws DaoException {
		String sql = "UPDATE TC SET AVE_SCORE=? WHERE CID=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setFloat(1, score);
			pstmt.setInt(2, cid);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}
}

