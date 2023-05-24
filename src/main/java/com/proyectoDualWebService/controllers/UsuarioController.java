package com.proyectoDualWebService.controllers;


import com.proyectoDualWebService.persistence.manager.impl.ManagerUsuarioImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
@Path("/usuarios")
public class UsuarioController {
    @GET
    @Path("/get/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") int id){
        return Response.ok().entity(new ManagerUsuarioImpl().findById(id)).build();
    }

    @GET
    @Path("/get/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("email") String email){
        return Response.ok().entity(new ManagerUsuarioImpl().findByEmail(email)).build();
    }




}