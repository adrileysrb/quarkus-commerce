package org.acme.resource;

import java.util.List;

import org.acme.model.Cupom;
import org.acme.service.CupomService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cupons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CupomResource {

    @Inject
    CupomService cupomService;

    @GET
    public List<Cupom> listarTodos() {
        return cupomService.listarTodos();
    }

    @GET
    @Path("/{codigo}")
    public Response buscarPorCodigo(@PathParam("codigo") String codigo) {
        Cupom cupom = cupomService.buscarPorCodigo(codigo);
        if (cupom != null) {
            return Response.ok(cupom).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response criar(Cupom cupom) {
        cupomService.criar(cupom);
        return Response.status(Response.Status.CREATED).entity(cupom).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        cupomService.deletar(id);
        return Response.noContent().build();
    }
}
