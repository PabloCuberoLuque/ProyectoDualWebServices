package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.manager.impl.ManagerTablonImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/tablones")
public class TablonController {
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllTablon() {
        List<Tablon> tablones = new ManagerTablonImpl().findAll();
        return Response.ok()
                .entity(tablones)
                .build();
    }

    @GET
    @Path("/{id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTablon(@PathParam("id") int id) {
        return Response.ok()
                .entity(new ManagerTablonImpl().findById(id))
                .build();
    }


    @GET
    @Path("/{id}/getAllUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTablonUser(@PathParam("id") int id) {
        return Response.ok()
                .entity(new ManagerTablonImpl().findByIdUser(id))
                .build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTablon(Tablon tablon) {
        new ManagerTablonImpl().insert(tablon);
        return Response.status(Response.Status.CREATED)
                .entity(tablon)
                .build();
    }

    @PUT
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTablon(@PathParam("id") int id, Tablon tablon) {
        tablon.setId(id);
        new ManagerTablonImpl().update(tablon);
        return Response.ok()
                .entity("Tablon actualizado correctamente")
                .build();
    }

    @DELETE
    @Path("/{id}/delete")
    public Response deleteTablon(@PathParam("id") int id) {
        new ManagerTablonImpl().delete(id);
        return Response.ok()
                .entity("Tablon eliminado correctamente")
                .build();
    }
}

