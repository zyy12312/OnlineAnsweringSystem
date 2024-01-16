package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.QuestionDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionImpl implements QuestionDao {
	// 插入一条问题记录
	public boolean addQuestion(Question question) throws DaoException {
		String sql = "INSERT INTO Question(title,content,sid,cid,reply_state,check_state,open,file_name) VALUES(?,?,?,?,0,0,?,?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, question.getTitle());
			pstmt.setString(2, question.getContent());
			pstmt.setInt(3, question.getSid());
			pstmt.setInt(4, question.getCid());
			pstmt.setInt(5, question.getOpen());
			pstmt.setString(6, question.getFile_name());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}
	}

	// 按id删除问题方法
	@Override
	public boolean delQuestion(int id) throws DaoException {
		String sql = "delete from Question where id =?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Question question) throws DaoException {
		String sql = "UPDATE Question SET Title=?,Content=?,Open=?,Reply_state=?,Check_state=?,Score=? WHERE ID=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, question.getTitle());
			pstmt.setString(2, question.getContent());
			pstmt.setInt(3, question.getOpen());
			pstmt.setInt(4, question.getReply_state());
			pstmt.setInt(5, question.getCheck_state());
			pstmt.setFloat(6, question.getScore());
			pstmt.setInt(7, question.getId());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Question> query(String sql,Object[] objects) throws DaoException {
		ArrayList<Question> list = new ArrayList<Question>();
		Question question = null;
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			for(int i=0;i<objects.length;i++)
				pstmt.setObject(i+1,objects[i]);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				question = new Question();
				question.setId(rst.getInt("id"));
				question.setTitle(rst.getString("title"));
				question.setContent(rst.getString("content"));
				question.setCheck_state(rst.getInt("check_state"));
				question.setOpen(rst.getInt("open"));
				question.setDate(rst.getTimestamp("date"));
				question.setScore(rst.getFloat("score"));
				question.setSid(rst.getInt("sid"));
				question.setCid(rst.getInt("cid"));
				question.setReply_state(rst.getInt("reply_state"));
				question.setFile_name(rst.getString("file_name"));
				list.add(question);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

