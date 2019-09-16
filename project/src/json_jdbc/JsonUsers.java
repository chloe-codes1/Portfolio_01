package json_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBC_util;

public class JsonUsers {

	public String getJsonUsers(String deptno) {
		String sql = "select*from users where id=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBC_util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, deptno);
			rs = ps.executeQuery();
			//결과값 handling
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBC_util.close(con, ps, rs);
			
		}
		
		
		
		return "";
	}
	
	
}
