package com.proyectoDualWebService.controllers;

import com.proyectoDualWebService.dao.TablonDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
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

}
