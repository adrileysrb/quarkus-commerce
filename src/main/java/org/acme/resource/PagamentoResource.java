package org.acme.resource;

import org.acme.model.Pagamento;
import org.acme.service.PagamentoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pagamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoResource {

    @Inject
    PagamentoService pagamentoService;

    @POST
    public Response processarPagamento(Pagamento pagamento) {
        pagamentoService.processarPagamento(pagamento);
        return Response.status(Response.Status.CREATED).entity(pagamento).build();
    }

    @GET
    @Path("/pedido/{pedidoId}")
    public Response buscarPorPedido(@PathParam("pedidoId") Long pedidoId) {
        Pagamento pagamento = pagamentoService.buscarPorPedido(pedidoId);
        if (pagamento != null) {
            return Response.ok(pagamento).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}