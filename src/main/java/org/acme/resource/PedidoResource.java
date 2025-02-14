package org.acme.resource;

import java.util.List;

import org.acme.model.Pedido;
import org.acme.service.PedidoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService pedidoService;

    @GET
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Pedido pedido = pedidoService.buscarPorId(id);
        if (pedido != null) {
            return Response.ok(pedido).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/usuario/{usuarioId}")
    public List<Pedido> buscarPorUsuario(@PathParam("usuarioId") Long usuarioId) {
        return pedidoService.buscarPorUsuario(usuarioId);
    }

    @POST
    public Response criar(Pedido pedido) {
        pedidoService.criar(pedido);
        return Response.status(Response.Status.CREATED).entity(pedido).build();
    }

    @PUT
    @Path("/{id}/status")
    public Response atualizarStatus(@PathParam("id") Long id, String status) {
        pedidoService.atualizarStatus(id, status);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        pedidoService.deletar(id);
        return Response.noContent().build();
    }
}