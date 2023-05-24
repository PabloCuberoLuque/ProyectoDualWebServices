package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dto.Grupo;
import com.proyectoDualWebService.persistence.manager.impl.ManagerGrupoImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/grupos")
public class GrupoController {
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGrupo() {
        List<Grupo> grupos = new ManagerGrupoImpl().findAll();
        return Response.ok()
                .entity(grupos)
                .build();
    }

    @GET
    @Path("/{id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGrupo(@PathParam("id") int id) {
        return Response.ok()
                .entity(new ManagerGrupoImpl().findById(id))
                .build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrupo(Grupo grupo) {
        new ManagerGrupoImpl().insert(grupo);
        return Response.status(Response.Status.CREATED)
                .entity("Grupo creado correctamente")
                .build();

    }

    @PUT
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGrupo(@PathParam("id") int id, Grupo grupo) {
        grupo.setId(id);
        new ManagerGrupoImpl().update(grupo);
        return Response.status(Response.Status.CREATED)
                .entity("Grupo actualizado correctamente")
                .build();
    }

    @DELETE
    @Path("/{id}/delete")
    public Response deleteGrupo(@PathParam("id") int id) {
        new ManagerGrupoImpl().delete(id);
        return Response.ok()
                .entity("Grupo eliminado correctamente")
                .build();
    }
}
