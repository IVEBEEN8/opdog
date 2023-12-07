package com.opdoghoho.doginfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB관련 작업을 할 땐 어차피 연결코드를 쓴 이후 작업 채움
// 다 쓰면 닫음

// 그걸 AOP하자
public class DBManager {
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@DB202204301707_medium?TNS_ADMIN=/Users/namjajeonghowon/Desktop/hw/Wallet_DB202204301707";
		String id = "Hohowon";
		String pw = "wonHoho0731!!";
		return DriverManager.getConnection(url,id,pw);

	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				
			}
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
