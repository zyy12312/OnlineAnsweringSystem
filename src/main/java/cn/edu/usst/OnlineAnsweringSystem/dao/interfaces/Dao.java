package main.java.cn.edu.usst.OnlineAnsweringSystem.dao.interfaces;

import main.java.cn.edu.usst.OnlineAnsweringSystem.dao.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Dao {
    public default Connection getConnection() throws DaoException {
		//1.加载驱动-把驱动对象加载到内存
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//com.mysql.cj.jdbc是一个packet,Driver是一个类。这个包和类可以在左边的External Libraries--com.mysql--cj--jdbc下找到Driver类
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动失败");
		}
		//2.创建数据库连接
		String url,user,password;
		url="jdbc:mysql://localhost:3306/JavaWebDB";//url="jdbc:mysql://114.132.44.105:3306/demo01";//url是连接标识（是网址的形式）（最后面是数据库的名称）
		user="root";
		password="87654321";
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		}catch (SQLException e){
			System.out.println("fail!"+e.getMessage());
		}
		return connection;
   }
}

