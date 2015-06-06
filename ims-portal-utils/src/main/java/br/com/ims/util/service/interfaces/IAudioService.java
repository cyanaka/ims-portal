package br.com.ims.util.service.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.ims.util.service.ServiceConstants;
import br.com.ims.util.service.ServiceName;
import br.com.ims.utils.entity.AudioEntity;

@Path(value = ServiceName.AUDIO_SERVICE)
@Produces(ServiceConstants.MEDIA_TYPE)
@Consumes(ServiceConstants.MEDIA_TYPE)
public interface IAudioService {

	
	@GET
	@Path(value = "/find")
	public List<AudioEntity> getAll();
	
	@GET
	@Path(value = "/delete/{id}")
	public void delete(@PathParam("id") Long id);

	@POST
	@Path(value = "/insert")
	public void insert(Object jsonEntityObject);

	@PUT
	@Path(value = "/update")
	public void update(Object jsonEntityObject);
}
