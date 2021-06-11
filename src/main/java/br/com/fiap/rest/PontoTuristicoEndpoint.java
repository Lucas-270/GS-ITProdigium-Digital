package br.com.fiap.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.PontoTuristicoDao;
import br.com.fiap.model.PontoTuristico;

@Path("/pontos")
@Produces(MediaType.APPLICATION_JSON)
public class PontoTuristicoEndpoint {

	private PontoTuristicoDao dao = new PontoTuristicoDao();

	@GET
	public Response index() {
		try {
			List<PontoTuristico> list = dao.getAll();
			return Response.status(Response.Status.OK).entity(list).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(PontoTuristico ponto) {
		if (ponto == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			dao.saveApi(ponto);
			return Response.status(Response.Status.CREATED).entity(ponto).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		PontoTuristico ponto = dao.findById(id);
		if (ponto == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(ponto).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, PontoTuristico ponto) {
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (ponto == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (dao.findById(id) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		ponto.setId(id);
		try {
			dao.update(ponto);
			return Response.status(Response.Status.OK).entity(ponto).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ponto).build();
		}
	}

	@DELETE
	@Path("{id}")
	public Response destroy(@PathParam("id") Long id) {
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (dao.findById(id) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		PontoTuristico ponto = dao.findById(id);
		try {
			dao.delete(ponto);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
