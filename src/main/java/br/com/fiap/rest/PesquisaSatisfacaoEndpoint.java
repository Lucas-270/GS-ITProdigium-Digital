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

import br.com.fiap.dao.PesquisaSatisfacaoDao;
import br.com.fiap.model.PesquisaSatisfacao;

@Path("/pesquisas")
@Produces(MediaType.APPLICATION_JSON)
public class PesquisaSatisfacaoEndpoint {

	private PesquisaSatisfacaoDao dao = new PesquisaSatisfacaoDao();

	@GET
	public Response index() {
		try {
			List<PesquisaSatisfacao> list = dao.getAll();
			return Response.status(Response.Status.OK).entity(list).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(PesquisaSatisfacao satis) {
		if (satis == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			dao.saveApi(satis);
			return Response.status(Response.Status.CREATED).entity(satis).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		PesquisaSatisfacao satis = dao.findById(id);
		if (satis == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(satis).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, PesquisaSatisfacao satis) {
		if (id == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (satis == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (dao.findById(id) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		satis.setId(id);
		try {
			dao.update(satis);
			return Response.status(Response.Status.OK).entity(satis).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(satis).build();
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

		PesquisaSatisfacao satis = dao.findById(id);
		try {
			dao.delete(satis);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
