package com.proyectoDualWebService.controller;


import com.proyectoDualWebService.service.GrupoService;
import com.proyectoDualWebService.dto.Grupo;
import com.proyectoDualWebService.persistence.manager.impl.ManagerGrupoImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/grupos")
public class GrupoController {

    private final GrupoService grupoDAO;

    public GrupoController(GrupoService grupoDAO) {
        this.grupoDAO = new GrupoService(new ManagerGrupoImpl());
    }

    @GET
    @Path("/getGrupo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Integer id) {
        if (id == null){
            return Response.status(400).entity("Parámetros incorrectos").build();
        } else {
            return Response.ok().entity(grupoDAO.findByIdGrupo(id)).build();
        }
    }

    @GET
    @Path("/getAllGrupo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException {
        return Response.ok().entity(grupoDAO.findAllGrupo()).build();
    }

    @POST
    @Path("/createGrupo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGrupo(Grupo grupo){
        int id = grupoDAO.createGrupo(grupo);
        if (id > 0){
            return Response.status(201).entity(grupoDAO.findByIdGrupo(id)).build();
        } else {
            return Response.status(500).entity("Error interno").build();
        }
    }

    @PUT
    @Path("/updateGrupo/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGrupo(@PathParam("id") int id, Grupo grupo){
       Grupo grupoBD = grupoDAO.findByIdGrupo(grupo.getId());
       if (grupoBD != null) {
           if (grupoDAO.updateGrupo(grupo)){
               return Response.status(200).entity(grupoDAO.findByIdGrupo(grupo.getId())).build();
           } else {
               return Response.status(500).entity("Error interno").build();
           }
       } else {
           return Response.status(404).entity("Grupo no encontrado").build();
       }
    }

    @DELETE
    @Path("/deleteGrupo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteGrupo(@PathParam("id") int id){
        try {
            Grupo grupo = grupoDAO.findByIdGrupo(id);
            if (grupo != null){
                if (grupoDAO.deleteGrupo(id)) {
                    return Response.status(200).entity(grupo).build();
                } else {
                    return Response.status(304).entity("Grupo no eliminado").build();
                }
            } else {
                return Response.status(404).entity("Grupo no encontrado").build();
            }
        } catch (SQLException | ClassNotFoundException e){
            return Response.status(500).entity("Error interno").build();
        }
    }
}
