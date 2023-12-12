package com.opdoghw.centerinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 이건 java 쌩으론 연결x 웹으로 연결해야되서 모델링을 해줘야한다.
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBManager_khw {
//db 관련 작업을 할 때 연결코드를 쓴 이후 작업 해옴.
//다 쓰면 닫음
// 그걸 AOP하자
	private static BasicDataSource dataSource;

	static {
		// DBCP (Apache Commons Database Connection Pooling) 설정
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		// 희
		dataSource.setUrl(
				"jdbc:oracle:thin:@k9ytr1put6n556o8_high?TNS_ADMIN=/Users/heewon/Desktop/vscodeWorkSpace/Wallet_K9YTR1PUT6N556O8");
//	    dataSource.setUrl("jdbc:oracle:thin:@k9ytr1put6n556o8_high?TNS_ADMIN=/Users/namjajeonghowon/Desktop/hw/Wallet_K9YTR1PUT6N556O8");
		dataSource.setUsername("ADMIN");
		dataSource.setPassword("Thfeptmzm802!!");

		// 다양한 DBCP 설정들을 추가할 수 있습니다.
	}

	public static Connection connect() throws SQLException {
		System.out.println("connect~~");
		return dataSource.getConnection();
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
