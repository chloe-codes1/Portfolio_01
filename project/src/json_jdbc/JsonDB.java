package json_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.JDBC_util;

public class JsonDB {
/*
	public static void main(String[] args) {
		System.out.println(getJsonDept("20"));
		
		System.out.println("--------------------------------------");
		
		System.out.println(getAllJsonDept());
	
	}
*/	
	//JSON 객체 하나
	public static String getJsonDept(String deptno) {
		String sql = "select*from dept where deptno=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			con = JDBC_util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, deptno);
			rs = ps.executeQuery();
			//결과값 handling
			while(rs.next()) {
				map.put("deptno", rs.getString("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBC_util.close(con, ps, rs);
		}
		
		
		return JSONObject.toJSONString(map);
	}
	
	
	//JSON 배열
	public static String getAllJsonDept() {
		String sql = "select*from dept";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//JSON 배열
		JSONArray array = new JSONArray();
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			con = JDBC_util.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//결과값 handling
			while(rs.next()) {
				map.put("deptno", rs.getString("deptno"));
				map.put("dname", rs.getString("dname"));
				map.put("loc", rs.getString("loc"));
				
				//json 배열이 obj에 쌓이게 됨
				JSONObject obj =  new JSONObject(map);
				array.add(obj);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBC_util.close(con, ps, rs);
		}
		return JSONArray.toJSONString(array);
	}
	
	//id 중복검사
	public static String idCheck(String id) {
		String sql = "select*from users where id=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			con = JDBC_util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			//결과값 handling
			while(rs.next()) {
				map.put("id", rs.getString("id"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			JDBC_util.close(con, ps, rs);
		}
		return JSONObject.toJSONString(map);
	}
	
	
	//자주 쓰일 것 같아서 temp로 만들어놓음
	public String temp(String deptno) {
		String sql = "select*from dept where deptno=?";
		
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
