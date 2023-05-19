package com.proyectoDualWebService.controllers;


import com.proyectoDualWebService.dao.UsuarioDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioController {

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") int id){
        return Response.ok()
                .entity(new UsuarioDAO().findbyId(id))
                .build();
    }

    @GET
    @Path("/get/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmail(@PathParam("email") String email){
        return Response.ok()
                .entity(new UsuarioDAO().findbyEmail(email))
                .build();
    }

    @GET
    @Path("/get/nombreExacto/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNombreExacto(@PathParam("name") String name){
        return Response.ok()
                .entity(new UsuarioDAO().findByNombreExacto(name))
                .build();
    }
}
