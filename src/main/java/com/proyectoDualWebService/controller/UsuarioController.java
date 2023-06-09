package com.proyectoDualWebService.controller;


import com.proyectoDualWebService.dto.Usuario;
import com.proyectoDualWebService.persistence.manager.impl.ManagerUsuarioImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
public class UsuarioController {
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllUsuario() {
        List<Usuario> usuarios = new ManagerUsuarioImpl().findAll();
        return Response.ok()
                .entity(usuarios)
                .build();
    }

    @GET
    @Path("/{id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") int id) {
        return Response.ok()
                .entity(new ManagerUsuarioImpl().findById(id))
                .build();
    }

    @GET
    @Path("/{username}/getn")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioName(@PathParam("username") String username) {
        return Response.ok()
                .entity(new ManagerUsuarioImpl().findByUsername(username))
                .build();
    }

    @GET
    @Path("/{email}/getM")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioEmail(@PathParam("email") String email) {
        return Response.ok()
                .entity(new ManagerUsuarioImpl().findByEmail(email))
                .build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUsuario(Usuario usuario) {
        new ManagerUsuarioImpl().insert(usuario);
        return Response.status(Response.Status.CREATED)
                .entity(usuario)
                .build();
    }

    @PUT
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsuario(@PathParam("id") int id, Usuario usuario) {
        usuario.setId(id);
        new ManagerUsuarioImpl().update(usuario);
        return Response.ok()
                .entity(usuario)
                .build();
    }

    @DELETE
    @Path("/{id}/delete")
    public Response eliminarUsuario(@PathParam("id") int id) {
        new ManagerUsuarioImpl().delete(id);
        return Response.ok()
                .entity("Usuario eliminado correctamente")
                .build();
    }

}