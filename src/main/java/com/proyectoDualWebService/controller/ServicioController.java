package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dao.ServicioDAO;
import com.proyectoDualWebService.model.Servicio;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/servicios")
public class ServicioController {

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServicio(@PathParam("id") int id){
        return Response.ok()
                .entity(new ServicioDAO().obtenerServicio(id))
                .build();
    }

    @GET
    @Path("/obtenerTodoServicio")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTodoServicio(){
        List<Servicio> servicios = new ServicioDAO().obtenerTodoServicio();
        return Response.ok()
                .entity(servicios)
                .build();
    }

    @POST
    @Path("/insertarServicio")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarServicio(Servicio servicio){
        new ServicioDAO().insertarServicio(servicio);
        return Response.status(Response.Status.CREATED)
                .entity("Servicio creado correctamente")
                .build();
    }

    @PUT
    @Path("/actualizarServicio/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarServicio(@PathParam("id") int id, Servicio servicio){
        servicio.setId(id);
        new ServicioDAO().actualizarServicio(servicio);
        return Response.ok()
                .entity("Servicio actualizado correctamente")
                .build();
    }

    @DELETE
    @Path("/eliminarServicio/{id}")
    public Response eliminarServicio(@PathParam("id") int id){
        new ServicioDAO().eliminarServicio(id);
        return Response.ok()
                .entity("Servicio eliminado correctamente")
                .build();
    }
}
