package com.opdogkl.shop;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager {
		
		// ����
	public static Connection connect() throws Exception {
		String url = "jdbc:oracle:thin:@k9ytr1put6n556o8_high?TNS_ADMIN=C:/Bada/Wallet_K9YTR1PUT6N556O8";
		return DriverManager.getConnection(url,"ADMIN","Thfeptmzm802!!");
		
		
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			
			if (rs != null) {
				rs.close();
			}
			pstmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
