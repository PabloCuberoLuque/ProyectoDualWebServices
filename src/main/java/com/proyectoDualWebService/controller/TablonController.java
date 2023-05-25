package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.service.TablonService;
import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.manager.impl.ManagerTablonImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/tablones")
public class TablonController {

    private final TablonService tablonDAO;

    public TablonController() {
        this.tablonDAO = new TablonService(new ManagerTablonImpl());
    }

    @GET
    @Path("getAllTablon")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException {
        return Response.ok().entity(tablonDAO.findAll()).build();
    }

    @GET
    @Path("/getTablon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById (@PathParam("id") Integer id){
        if (id == null){
            return Response.status(400).entity("Parámetros incorrectos").build();
        } else {
            return Response.ok().entity(tablonDAO.findById(id)).build();
        }
    }

    @POST
    @Path("/createrTablon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTablon(Tablon tablon){
        int id = tablonDAO.createTablon(tablon);
        if (id > 0) {
            return Response.status(201).entity(tablonDAO.findById(id)).build();
        } else {
            return Response.status(500).entity("Error interno").build();
        }
    }

    @PUT
    @Path("/updateTablon/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTablon(@PathParam("id") int id, Tablon tablon){
        Tablon tablonBD = tablonDAO.findById(tablon.getId());
        if (tablonBD != null){
            if (tablonDAO.updateTablon(tablon)){
                return Response.status(200).entity(tablonDAO.findById(tablon.getId())).build();
            } else {
                return Response.status(500).entity("Error interno").build();
            }
        } else {
            return Response.status(404).entity("Tablon no encontrado").build();
        }
    }

    @DELETE
    @Path("/deleteTablon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarTablon(@PathParam("id") int id) {
        Tablon tablon = tablonDAO.findById(id);
        if (tablon != null) {
            if (tablonDAO.deleteTablon(id)) {
                return Response.status(200).entity(tablon).build();
            } else {
                return Response.status(304).entity("Tablón no eliminado").build();
            }
        } else {
            return Response.status(404).entity("Tablón no encontrado").build();
        }
    }
}

