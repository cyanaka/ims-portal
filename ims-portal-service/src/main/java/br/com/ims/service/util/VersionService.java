package br.com.ims.service.util;

import java.util.List;

import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ims.util.service.interfaces.IVersionService;
import br.com.ims.utils.entity.VersionEntity;

@Named
public class VersionService extends AbstractGenericService<VersionEntity, Long> implements IVersionService{

	
	
	@Override
	public VersionEntity findOne(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VersionEntity> findByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByDescriptionName(String description) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected JpaRepository<VersionEntity, Long> getGenericRepository() {
		// TODO Auto-generated method stub
		return null;
	}

}
