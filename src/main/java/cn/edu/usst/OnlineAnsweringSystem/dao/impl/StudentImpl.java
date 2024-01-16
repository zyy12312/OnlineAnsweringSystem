package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.StudentDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentImpl implements StudentDao {
	// 插入一条Student记录
	public boolean addStudent(Student Student) throws DaoException {
		String sql = "INSERT INTO Student VALUES(?,?,?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Student.getId());
			pstmt.setString(2, Student.getName());
			pstmt.setString(3, Student.getPassword());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}
	}

	// 按id删除Student方法
	@Override
	public boolean delStudent(int id) throws DaoException {
		String sql = "delete from Student where id =?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}

	// 按id查询Student记录
	public Student findById(int id) throws DaoException {
		String sql = "SELECT * FROM Student WHERE id =?";
		Student Student = new Student();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					Student.setId(rst.getInt("id"));
					Student.setName(rst.getString("name"));
					Student.setPassword(rst.getString("password"));
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return Student;
	}

	// 查询所有Student信息
	public ArrayList<Student> findAllStudent() throws DaoException {
		Student Student = null;
		ArrayList<Student> custList = new ArrayList<Student>();
		String sql = "SELECT * FROM Student";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Student = new Student();
				Student.setId(rst.getInt("id"));
				Student.setName(rst.getString("name"));
				Student.setPassword(rst.getString("password"));
				custList.add(Student);
			}
			return custList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(Student Student) throws DaoException {
		String sql = "UPDATE Student SET ID=?,NAME=?,PASSWORD=? WHERE ID=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Student.getId());
			pstmt.setString(2, Student.getName());
			pstmt.setString(3, Student.getPassword());
			pstmt.setInt(4, Student.getId());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}
}

