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

    @GET
    @Path("{servicio}/getS")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServicioN(@PathParam("servicio") String nombre){
        return Response.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8080")
                .header("Access-Control-Allow-Methods", "GET")
                .header("Access-Control-Allow-Headers", "Content-Type")
                .entity(new ManagerServicioImpl().findByNombre(nombre))
                .build();
    }

    @GET
    @Path("{servicio}/{plan}/getSP")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServicioPlan(@PathParam("servicio") String nombre, @PathParam("plan") String plan){
        return Response.ok()
                .entity(new ManagerServicioImpl().findByParams(nombre, plan))
                .build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertServicio(Servicio servicio) {
        new ManagerServicioImpl().insert(servicio);
        return Response.status(Response.Status.CREATED)
                .entity(servicio)
                .build();
    }

    @PUT
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateServicio(@PathParam("id") int id, Servicio servicio) {
        servicio.setId(id);
        new ManagerServicioImpl().update(servicio);
        return Response.ok()
                .entity(servicio)
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
