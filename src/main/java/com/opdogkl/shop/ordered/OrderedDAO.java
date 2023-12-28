package com.opdogkl.shop.ordered;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.opdoghw.centerinfo.DBManager_khw;
import com.opdoghw.login.LoginDTO;

public class OrderedDAO {

	public static void regOrdered(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into ordered_kl values (ordered_kl_seq.nextval,?,?,?,?,sysdate,?)";
		LoginDTO account = (LoginDTO) request.getSession().getAttribute("account");
		
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String brand = request.getParameter("brand");
		int sPrice = Integer.parseInt(request.getParameter("sPrice"));
		
		
		try {
			con = DBManager_khw.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title); 
			pstmt.setInt(2, price); 
			pstmt.setString(3, brand); 
			pstmt.setInt(4, sPrice);
			pstmt.setInt(5,account.getNo());
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록 실패");
		}finally {
			DBManager_khw.close(con, pstmt, rs);
		}
		
	}

}
