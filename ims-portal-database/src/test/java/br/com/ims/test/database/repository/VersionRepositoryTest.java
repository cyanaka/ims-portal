package br.com.ims.test.database.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.ims.database.util.PostgresConn;
import br.com.ims.test.database.AbstractDatabaseTest;
import br.com.ims.utils.entity.VersionEntity;

public class VersionRepositoryTest extends AbstractDatabaseTest {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Test
	public void testFindAll(){
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
				e.printStackTrace();
			}
			
			logger.debug(versions);
		
		
	}
}
