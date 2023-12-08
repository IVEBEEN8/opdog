package com.opdoghw.centerinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;




public class CenterInfoDAO {

	public static void getCenterInfo(HttpServletRequest request) {
		
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from centerinfo_test";
			CenterInfoDTO c = null;
			ArrayList<CenterInfoDTO> center = new ArrayList<CenterInfoDTO>();
			try {
				con = DBManager.connect();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					c = new CenterInfoDTO();
					c.setNo(rs.getInt("c_no"));
					c.setCareNm(rs.getString("c_carenm"));
					c.setCareAddr(rs.getString("c_careaddr"));
					c.setLat(rs.getFloat("c_lat"));
					c.setLng(rs.getFloat("c_lng"));
					c.setVetPersonCnt(rs.getInt("c_vetpersoncnt"));
					c.setCareTel(rs.getString("c_caretel"));
					center.add(c);
				}
				request.setAttribute("centers", center);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(con, pstmt, rs);
			}
		}

	}

