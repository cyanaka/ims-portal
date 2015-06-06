package br.com.ims.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class PostgresConn {
	
	Logger log = Logger.getLogger(PostgresConn.class);
	
	InitialContext ctx = null;
	DataSource ds = null;
	Connection conn = null;
	Statement stmt = null;	
	ResultSet rs = null;
	PreparedStatement pstm = null;

	public PostgresConn() {
		this("IVR");
	}
	public PostgresConn(String base) {
						
		if(base.equalsIgnoreCase("IVR")){
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/ivr",
						"postgres", 
						"ewqiop3210-=");
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}		
	}

	public void finalize() {
		try { if(rs != null) rs.close();} catch(Exception e) {log.error(e.getMessage(), e);}
		try {if(stmt != null) stmt.close();} catch(Exception e) {log.error(e.getMessage(), e);}
		try {if(conn != null) conn.close();} catch(Exception e) {log.error(e.getMessage(), e);}
		try {if(ctx != null) ctx.close();} catch(Exception e) {log.error(e.getMessage(), e);}
	}

	public boolean ExecuteSql(String sql) {
		boolean answer = false;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql); 
			answer = true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			log.error(sql);
		}
		return answer;
	}

	public ResultSet ExecuteQuery(String sql) throws SQLException {
		rs = null;
		stmt = null;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
	    } catch (Exception e) {
	    	log.error(e.getMessage(), e);
	    }
	    return rs;
	}
	
	public Connection getConnection()throws SQLException{
		return this.conn;
	}
}
