package com.tianmg.dubbot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc访问数据库基类
 * @author TianMingGang
 * 2015年6月12日
 */
public class JDBC_BASE {
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@192.168.2.181:1521:amdb";
	private static final String USERNAME = "aq";
	private static final String PASSWORD = "aq1234";
	
	//JDBC接口
    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;
    
    /**
     * 获取数据库连接
     * @author TianMingGang
     * 2015年6月12日
     * @return
     */
    public static Connection getConntion(){  
    	Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("数据库连接成功...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
        return conn;
    }
    
    /**
     * 关闭pstmt和rs
     * @author TianMingGang
     * 2015年7月7日
     */
    public static void closeRS(ResultSet rs, PreparedStatement pstmt){
    	if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 关闭连接
     * @author TianMingGang
     * 2015年6月12日
     */
    public static void closeConn(ResultSet rs, PreparedStatement pstmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
