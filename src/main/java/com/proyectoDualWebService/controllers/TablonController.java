package com.proyectoDualWebService.controllers;

import com.proyectoDualWebService.dao.TablonDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tablon")
public class TablonController {

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok()
                .entity(new TablonDAO().findAll())
                .build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id){
        return Response.ok()
                .entity(new TablonDAO().findById(id))
                .build();
    }

    @GET
    @Path("/getallUser/{id}")
    @Produces
    public Response getAllUser(@PathParam("id") int id){
        return Response.ok()
                .entity(new TablonDAO().findByUserId(id))
                .build();
    }

}
