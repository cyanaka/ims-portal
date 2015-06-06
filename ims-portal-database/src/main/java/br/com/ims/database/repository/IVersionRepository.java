package br.com.ims.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import br.com.ims.utils.entity.VersionEntity;

public interface IVersionRepository extends JpaRepository<VersionEntity, Long> {
	

}
