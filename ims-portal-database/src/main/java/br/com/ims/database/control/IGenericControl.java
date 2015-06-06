package br.com.ims.database.control;

import java.io.Serializable;
import java.util.List;

import br.com.ims.utils.BaseEntity;

public interface IGenericControl <T extends BaseEntity<PK>, PK extends Serializable>  {
		
		public List<T> findAll();

		public void insert(Object jsonEntityObject);

		public void delete(Object jsonKeyObject);

		public void update(Object jsonEntityObject);

	
}
