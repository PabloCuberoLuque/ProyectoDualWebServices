package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dto.Servicio;
import com.proyectoDualWebService.persistence.manager.impl.ManagerServicioImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/servicios")
public class ServicioController {
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllServicio() {
        List<Servicio> servicios = new ManagerServicioImpl().findAll();
        return Response.ok()
                .entity(servicios)
                .build();
    }

    @GET
    @Path("/{id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServicio(@PathParam("id") int id) {
        return Response.ok()
                .entity(new ManagerServicioImpl().findById(id))
                .build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertServicio(Servicio servicio) {
        new ManagerServicioImpl().insert(servicio);
        return Response.status(Response.Status.CREATED)
                .entity("Servicio creado correctamente")
                .build();
    }

    @PUT
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateServicio(@PathParam("id") int id, Servicio servicio) {
        servicio.setId(id);
        new ManagerServicioImpl().update(servicio);
        return Response.ok()
                .entity("Servicio actualizado correctamente")
                .build();
    }

    @DELETE
    @Path("/{id}/delete")
    public Response deleteServicio(@PathParam("id") int id) {
        new ManagerServicioImpl().delete(id);
        return Response.ok()
                .entity("Servicio eliminado correctamente")
                .build();
    }
}
