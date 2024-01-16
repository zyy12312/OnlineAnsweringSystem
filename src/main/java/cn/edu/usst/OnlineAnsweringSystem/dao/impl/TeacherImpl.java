package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.TeacherDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherImpl implements TeacherDao {
	// 插入一条Teacher记录
	public boolean addTeacher(Teacher Teacher) throws DaoException {
		String sql = "INSERT INTO Teacher VALUES(?,?,?,?,?,?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Teacher.getId());
			pstmt.setString(2, Teacher.getName());
			pstmt.setString(3, Teacher.getPassword());
			pstmt.setString(4, Teacher.getDetail());
			pstmt.setString(5, Teacher.getLevel());
			pstmt.setString(6, Teacher.getAvatar());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}
	}

	// 按id删除Teacher方法
	@Override
	public boolean delTeacher(int id) throws DaoException {
		String sql = "delete from Teacher where id =?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}

	// 按id查询Teacher记录
	public Teacher findById(int id) throws DaoException {
		String sql = "SELECT * FROM Teacher WHERE id =?";
		Teacher Teacher = new Teacher();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					Teacher.setId(rst.getInt("id"));
					Teacher.setName(rst.getString("name"));
					Teacher.setPassword(rst.getString("password"));
					Teacher.setDetail(rst.getString("detail"));
					Teacher.setLevel(rst.getString("level"));
					Teacher.setAvatar(rst.getString("avatar"));
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return Teacher;
	}

	// 查询所有Teacher信息
	public ArrayList<Teacher> findAllTeacher() throws DaoException {
		Teacher Teacher = null;
		ArrayList<Teacher> custList = new ArrayList<Teacher>();
		String sql = "SELECT * FROM Teacher";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Teacher = new Teacher();
				Teacher.setId(rst.getInt("id"));
				Teacher.setName(rst.getString("name"));
				Teacher.setPassword(rst.getString("password"));
				Teacher.setDetail(rst.getString("detail"));
				Teacher.setLevel(rst.getString("level"));
				Teacher.setAvatar(rst.getString("avatar"));
				custList.add(Teacher);
			}
			return custList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(Teacher Teacher) throws DaoException {
		String sql = "UPDATE Teacher SET ID=?,NAME=?,PASSWORD=?,DETAIL=?,LEVEL=?,AVATAR=? WHERE ID=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Teacher.getId());
			pstmt.setString(2, Teacher.getName());
			pstmt.setString(3, Teacher.getPassword());
			pstmt.setString(4, Teacher.getDetail());
			pstmt.setString(5, Teacher.getLevel());
			pstmt.setString(6, Teacher.getAvatar());
			pstmt.setInt(7, Teacher.getId());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}
}

