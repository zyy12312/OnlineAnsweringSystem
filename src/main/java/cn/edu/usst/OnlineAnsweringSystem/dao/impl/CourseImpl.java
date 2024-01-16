package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.impl;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;
import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces.CourseDao;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class CourseImpl implements CourseDao {
	// 插入一条课程记录
	public boolean addCourse(Course course) throws DaoException {
		String sql = "INSERT INTO Course VALUES(?,?,?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, course.getId());
			pstmt.setString(2, course.getName());
			pstmt.setString(3, course.getDetail());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			System.out.println(se);
			return false;
		}
	}

	// 按id删除课程方法
	@Override
	public boolean delCourse(int id) throws DaoException {
		String sql = "delete from Course where id =?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}

	// 按id查询课程记录
	@Override
	public Course findById(int id) throws DaoException {
		String sql = "SELECT * FROM Course WHERE id =?";
		Course course = new Course();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					course.setId(rst.getInt("id"));
					course.setName(rst.getString("name"));
					course.setDetail(rst.getString("detail"));
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return course;
	}

	// 按name查询课程记录
	@Override
	public Course findByName(String name) throws DaoException {
		String sql = "SELECT * FROM Course WHERE name =?";
		Course course = new Course();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					course.setId(rst.getInt("id"));
					course.setName(rst.getString("name"));
					course.setDetail(rst.getString("detail"));
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return course;
	}

	// 查询所有课程信息
	public ArrayList<Course> findAllCourse() throws DaoException {
		Course course = null;
		ArrayList<Course> custList = new ArrayList<Course>();
		String sql = "SELECT * FROM Course";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				course = new Course();
				course.setId(rst.getInt("id"));
				course.setName(rst.getString("name"));
				course.setDetail(rst.getString("detail"));
				custList.add(course);
			}
			return custList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


		@Override
	public boolean update(Course course) throws DaoException {
		String sql = "UPDATE COURSE SET ID=?,NAME=?,DETAIL=? WHERE ID=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, course.getId());
			pstmt.setString(2, course.getName());
			pstmt.setString(3, course.getDetail());
			pstmt.setInt(4, course.getId());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			return false;
		}
		return true;
	}
}

