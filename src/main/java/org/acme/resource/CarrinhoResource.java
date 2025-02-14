package org.acme.resource;

import org.acme.model.Carrinho;
import org.acme.model.ItemCarrinho;
import org.acme.service.CarrinhoService;

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

@Path("/carrinhos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoResource {

    @Inject
    CarrinhoService carrinhoService;

    @GET
    @Path("/usuario/{usuarioId}")
    public Response buscarPorUsuario(@PathParam("usuarioId") Long usuarioId) {
        Carrinho carrinho = carrinhoService.buscarPorUsuario(usuarioId);
        if (carrinho != null) {
            return Response.ok(carrinho).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/usuario/{usuarioId}/adicionar")
    public Response adicionarItem(@PathParam("usuarioId") Long usuarioId, ItemCarrinho item) {
        carrinhoService.adicionarItem(usuarioId, item.produto.id, item.quantidade);
        return Response.ok().build();
    }

    @DELETE
    @Path("/item/{itemCarrinhoId}")
    public Response removerItem(@PathParam("itemCarrinhoId") Long itemCarrinhoId) {
        carrinhoService.removerItem(itemCarrinhoId);
        return Response.noContent().build();
    }
}