package br.com.ims.util.service.interfaces;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import br.com.ims.utils.BaseEntity;
import br.com.ims.utils.entity.VersionEntity;

public interface IGenericService <T extends BaseEntity<PK>, PK extends Serializable> {
	
	@GET
	public List<T> findAll();

	@POST
	public void insert(Object jsonEntityObject);

	@DELETE
	public void delete(Object jsonKeyObject);

	@PUT
	public void update(Object jsonEntityObject);

}
