package br.com.ims.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.ims.database.util.PostgresConn;
import br.com.ims.utils.entity.AudioEntity;

@Named(value= "audioDao")
public class AudioDAO {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	
	public List<AudioEntity> getAll(){
			
		PostgresConn conn = new PostgresConn("IVR");
		
		String sql = "select * from flow.audio";
		ResultSet rs;
		java.util.List<AudioEntity> audios = new ArrayList<AudioEntity>();
		try {
			rs = conn.ExecuteQuery(sql);
			while (rs.next()) {
				AudioEntity a = new AudioEntity();
				a.setId(rs.getLong(1));
				a.setDescription(rs.getString("description"));
				a.setName(rs.getString("name"));
				a.setPath(rs.getString("path"));
				a.setProperty(rs.getString("property"));
				a.setType(rs.getString("type"));
				a.setVersionid(rs.getLong("versionid"));
				audios.add(a);
			}
		} catch (SQLException e) {
			logger.error("Erro ao executar findAll audio");
		}finally{
			conn.finalize();
		}
		return audios;
	}

	public void delete(Long id) {
		PostgresConn conn = new PostgresConn("IVR");
		String sql = "delete from flow.audio where id="+id;
		try {
			conn.ExecuteSql(sql);
		} catch (Exception e) {
			logger.error("Erro ao executar deletar audio");
		}finally{
			conn.finalize();
		}
	}

	public void insert(AudioEntity audio) {
		PostgresConn conn = new PostgresConn("IVR");
		Connection connection;
		PreparedStatement pstm = null;
		
		String sql = "insert into flow.audio (id, type, name, description, path, property, versionid)"
				+ "values (get_uid(),?,?,?,?,?,?)";
		
		try {
			connection = conn.getConnection();
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, audio.getType());
			pstm.setString(2, audio.getName());
			pstm.setString(3, audio.getDescription());
			pstm.setString(4, audio.getPath());
			pstm.setString(5, audio.getProperty());
			pstm.setLong(6, audio.getVersionid());
			
			pstm.execute();
			
		} catch (SQLException e) {
			logger.error("Erro ao executar insert audio");
		}finally{
			try {
				pstm.close();
			} catch (SQLException e) {
				logger.error("Erro ao executar insert audio - fechar pstm");
			}
			conn.finalize();
		}
		
	}

	public void update(AudioEntity audio) {
		PostgresConn conn = new PostgresConn("IVR");
		Connection connection;
		PreparedStatement pstm = null;
		
		String sql = "update flow.audio set type =?, name =?, description =?, path =?, property =?, versionid=? where id =?";
		
		
		try {
			connection = conn.getConnection();
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, audio.getType());
			pstm.setString(2, audio.getName());
			pstm.setString(3, audio.getDescription());
			pstm.setString(4, audio.getPath());
			pstm.setString(5, audio.getProperty());
			pstm.setLong(6, audio.getVersionid());
			pstm.setLong(7, audio.getId());
			
			pstm.execute();
			
		} catch (SQLException e) {
			logger.error("Erro ao executar update audio");
		}finally{
			try {
				pstm.close();
			} catch (SQLException e) {
				logger.error("Erro ao executar update audio - fechar pstm");
			}
			conn.finalize();
		}
	}
}
