package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.ReplyDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyImpl implements ReplyDao {
	// 插入一条回复记录
	public boolean addReply(Reply reply) throws DaoException {
		String sql = "INSERT INTO Reply(question_id,content,sender) VALUES(?,?,?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, reply.getQuestion_id());
			pstmt.setString(2, reply.getContent());
			pstmt.setInt(3, reply.getSender());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	// 按id删除回复方法
	@Override
	public boolean delReply(int id) throws DaoException {
		String sql = "delete from Reply where reply_id =?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}

	// 按id查询回复记录(按照时间顺序，最早发布的排在最前面)
	public ArrayList<Reply> findById(int question_id) throws DaoException {
		String sql = "SELECT * FROM Reply WHERE question_id =? ORDER BY DATE";
		Reply reply = null;
		ArrayList<Reply> replyList=new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, question_id);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					reply = new Reply();
					reply.setReply_id(rst.getInt("reply_id"));
					reply.setQuestion_id(rst.getInt("Question_id"));
					reply.setContent(rst.getString("Content"));
					reply.setDate(rst.getTimestamp("date"));
					reply.setSender(rst.getInt("sender"));
					replyList.add(reply);
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return replyList;
	}

	@Override
	public boolean update(Reply reply) throws DaoException {
		String sql = "UPDATE Reply SET CONTENT=? WHERE REPLY_ID=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, reply.getContent());
			pstmt.setInt(2, reply.getQuestion_id());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}
}

