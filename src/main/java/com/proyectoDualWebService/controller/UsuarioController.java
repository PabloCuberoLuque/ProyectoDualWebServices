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
    public Response findAllUsuario(){
        List<Usuario> usuarios = new ManagerUsuarioImpl().findAll();
        return Response.ok()
                .entity(usuarios)
                .build();
    }

    @GET
    @Path("/{id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") int id){
        return Response.ok()
                .entity(new ManagerUsuarioImpl().findById(id))
                .build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUsuario(Usuario usuario){
        new ManagerUsuarioImpl().update(usuario);
        return Response.status(Response.Status.CREATED)
                .entity("Usuario creado correctamente")
                .build();
    }

    @PUT
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUsuario(@PathParam("id") int id,  Usuario usuario){
        usuario.setId(id);
        new ManagerUsuarioImpl().update(usuario);
        return Response.ok()
                .entity("Usuario actualizado correctamente")
                .build();
    }

    @DELETE
    @Path("/{id}/delete")
    public Response eliminarUsuario(@PathParam("id") int id){
        new ManagerUsuarioImpl().delete(id);
        return Response.ok()
                .entity("Usuario eliminado correctamente")
                .build();
    }

}