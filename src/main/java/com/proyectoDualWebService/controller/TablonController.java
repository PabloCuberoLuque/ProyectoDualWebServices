package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dao.TablonDAO;
import com.proyectoDualWebService.model.Tablon;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tablones")
public class TablonController {

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTablon(@PathParam("id") int id){
        return Response.ok()
                .entity(new TablonDAO().obneterTablonPorId(id))
                .build();
    }

    @GET
    @Path("/obtenerTodoTablon")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTodoTablon(){
        List<Tablon> tablones = new TablonDAO().obtenerTodoTablon();
        return Response.ok()
                .entity(tablones)
                .build();
    }

    @POST
    @Path("/insertarTablon")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarTablon(Tablon tablon){
        new TablonDAO().insertarTablon(tablon);
        return Response.status(Response.Status.CREATED)
                .entity("Tablon creado correctamente")
                .build();
    }

    @PUT
    @Path("/actualizarTablon/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarTablon(@PathParam("id") int id, Tablon tablon){
        tablon.setId(id);
        new TablonDAO().actualizarTablon(tablon);
        return Response.ok()
                .entity("Tablon actualizado correctamente")
                .build();
    }

    @DELETE
    @Path("/eliminarTablon/{id}")
    public Response eliminarTablon(@PathParam("id") int id){
        new TablonDAO().eliminarTablon(id);
        return Response.ok()
                .entity("Tablon eliminado correctamente")
                .build();
    }
}

