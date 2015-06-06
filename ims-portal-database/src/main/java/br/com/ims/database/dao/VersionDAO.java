package br.com.ims.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.ims.database.util.PostgresConn;
import br.com.ims.utils.entity.VersionEntity;

public class VersionDAO {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public List<VersionEntity> findAll(){
			
		PostgresConn conn = new PostgresConn("IVR");
		
		String sql = "select * from flow.version";
		ResultSet rs;
		java.util.List<VersionEntity> versions = new ArrayList<VersionEntity>();
		try {
			rs = conn.ExecuteQuery(sql);
			while (rs.next()) {
				VersionEntity v = new VersionEntity();
				v.setId(rs.getLong(1));
				v.setDescription(rs.getString(2));
				versions.add(v);
			}
		} catch (SQLException e) {
			logger.error("Erro ao executar operação findAll Version");
		}
		return versions;
	}
	
}
