/**
 * 
 */
package com.tianmg.dubbot.dao;

import java.sql.SQLException;

import com.tianmg.dubbot.bean.UserBean;

/**
 *
 * @author TianMingGang
 * 2016年3月8日
 */
public class UserDao {
	public int saveUser(UserBean user) throws SQLException{
		String sql = "insert into user_t(userName,password,age)VALUES(?,?,?)";
		if(JDBC_BASE.conn == null || JDBC_BASE.conn.isClosed()){
			JDBC_BASE.conn = JDBC_BASE.getConntion();
		}
		if(JDBC_BASE.pstmt == null || JDBC_BASE.pstmt.isClosed()){
			JDBC_BASE.pstmt = JDBC_BASE.conn.prepareStatement(sql);
		}
		JDBC_BASE.pstmt.setString(1, user.getUserName());
		JDBC_BASE.pstmt.setString(2, user.getPassword());
		JDBC_BASE.pstmt.setInt(3, user.getAge());
		
		return JDBC_BASE.pstmt.executeUpdate();
	}
}
