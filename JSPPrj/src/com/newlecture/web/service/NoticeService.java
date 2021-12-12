package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	public List<Notice> getNoticeList(){
		
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page){
		
		return getNoticeList("title", "", page);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page){
		
		List<Notice> list = new ArrayList<>();
		
		String sql = "SELECT * FROM (" + 
				"    SELECT ROWNUM NUM, N.*" + 
				"    FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N" + 
				"    ) " + 
				"WHERE NUM BETWEEN 6 AND 10"; 
		
		// 회사
		//String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		// 집
		String url = "jdbc:oracle:thin:@localhost:1521/xe";

		String sql = "SELECT * FROM NOTICE";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//회사
			//Connection con = DriverManager.getConnection(url, "NEWLEC", "123456");
			// 집
			Connection con = DriverManager.getConnection(url, "newlec", "123456");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()){
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE"); 	
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				Notice notice = new Notice(
						id,
						title,
						writerId,
						regdate,
						hit,
						files,
						content
				);
				list.add(notice);
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int getNoticeCount() {
		
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		
		String sql = "SELECT * FROM (" + 
				"    SELECT ROWNUM NUM, N.*" + 
				"    FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N" + 
				"    ) " + 
				"WHERE NUM BETWEEN 6 AND 10";
		
		return 0;
	}
	
	public Notice getNotice(int id) {
		
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		return null;
	}
	
	public Notice getNextNotice(int id) {
		
		String sql = "SELECT * FROM NOTICE " + 
				"WHERE ID = (" + 
				"    SELECT ID FROM NOTICE " + 
				"    WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID=3) " + 
				"    AND ROWNUM = 1 " + 
				")";
		
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		
		String sql = "SELECT ID FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) " + 
				"WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID=3) " + 
				"AND ROWNUM =1";
		
		return null;
	}
}
