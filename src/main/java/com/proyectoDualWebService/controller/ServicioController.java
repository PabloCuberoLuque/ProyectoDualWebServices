package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.service.ServicioService;
import com.proyectoDualWebService.dto.Servicio;
import com.proyectoDualWebService.persistence.manager.impl.ManagerServicioImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/servicios")
public class ServicioController {

    private final ServicioService servicioDAO;

    public ServicioController() {
        this.servicioDAO = new ServicioService(new ManagerServicioImpl());
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getServicio(@PathParam("id") Integer id){
        if (id == null){
            return Response.status(400).entity("Parámetros incorrectos").build();
        } else {
            return Response.ok().entity(servicioDAO.findByIdServicio(id)).build();
        }
    }

    @GET
    @Path("/getAllServicio")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllServicio() {
        return Response.ok().entity(servicioDAO.findAllServicio()).build();
    }

    @POST
    @Path("/createServicio")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createServicio(Servicio servicio){
        int id = servicioDAO.createServicio(servicio);
        if (id > 0) {
            return Response.status(201).entity(servicioDAO.findByIdServicio(id)).build();
        } else {
            return Response.status(500).entity("Error interno").build();
        }
    }

    @PUT
    @Path("/updateServicio/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarServicio(@PathParam("id") int id, Servicio servicio){
        Servicio servicioBD = servicioDAO.findByIdServicio(servicio.getId());
        if (servicioBD != null){
            if (servicioDAO.updateServicio(servicio)){
                return Response.status(200).entity(servicioDAO.findByIdServicio(servicio.getId())).build();
            } else {
                return Response.status(500).entity("Error interno").build();
            }
        } else {
            return Response.status(404).entity("Servicio no encontrado").build();
        }
    }

    @DELETE
    @Path("/eliminarServicio/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteServicio(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        Servicio servicio = servicioDAO.findByIdServicio(id);
        if (servicio != null){
            if (servicioDAO.deleteServicio(id)) {
                return Response.status(200).entity(servicio).build();
            } else {
                return Response.status(304).entity("Servicio no eliminado").build();
            }
        } else {
            return Response.status(404).entity("Servicio no encontrado").build();
        }
    }
}
