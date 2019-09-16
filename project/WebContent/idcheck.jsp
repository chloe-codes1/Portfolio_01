<%@page import="json_jdbc.JsonDB"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.JDBC_util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<%
		String id = request.getParameter("id");
		String data = JsonDB.idCheck(id);	
		
	%>
	
	
	<%= data %>	
