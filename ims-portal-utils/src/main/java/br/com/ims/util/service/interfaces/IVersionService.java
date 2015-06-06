package br.com.ims.util.service.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.ims.utils.entity.VersionEntity;
import br.com.ims.util.service.*;

@Path(value = ServiceName.VERSION_SERVICE)
@Produces(ServiceConstants.MEDIA_TYPE)
@Consumes(ServiceConstants.MEDIA_TYPE)
public interface IVersionService extends IGenericService<VersionEntity, Long> {

	@GET
	@Path("/findOne/{pk}")
	public VersionEntity findOne(@PathParam("pk") Long pk);

	@GET
	@Path(value = "/find/{description}")
	public List<VersionEntity> findByDescription(@PathParam("description") String description);

	@GET
	@Path(value = "/count/{description}")
	public int countByDescriptionName(@PathParam("description") String description);
}
