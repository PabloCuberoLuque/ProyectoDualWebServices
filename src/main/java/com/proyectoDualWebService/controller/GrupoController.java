package com.proyectoDualWebService.controller;


import com.proyectoDualWebService.dao.GrupoDAO;
import com.proyectoDualWebService.model.Grupo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/grupos")
public class GrupoController {

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGrupo(@PathParam("id") int id){
        return Response.ok()
                .entity(new GrupoDAO().obtenerGrupoPorId(id))
                .build();
    }

    @GET
    @Path("/obtenerTodoGrupo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTodoGrupo(){
        List<Grupo> grupos = new GrupoDAO().obtenerTodoGrupo();
        return Response.ok()
                .entity(grupos)
                .build();
    }

    @POST
    @Path("/insertarGrupo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarGrupo(Grupo grupo){
        boolean resultado = new GrupoDAO().insertarGrupo(grupo);
        if (resultado) {
            return Response.status(Response.Status.CREATED)
                    .entity("Grupo creado correctamente")
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al crear el grupo")
                    .build();
        }
    }

    @PUT
    @Path("/actualizarGrupo/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarGrupo(@PathParam("id") int id, Grupo grupo){
        grupo.setId(id);
        boolean resultado = new GrupoDAO().actualizarGrupo(grupo);
        if (resultado) {
            return Response.ok()
                    .entity("Grupo actualizado correctamente")
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al actualizar el grupo")
                    .build();
        }
    }

    @DELETE
    @Path("/eliminarGrupo/{id}")
    public Response eliminarGrupo(@PathParam("id") int id){
        new GrupoDAO().eliminarGrupo(id);
        return Response.ok()
                .entity("Grupo eliminado correctamente")
                .build();
    }
}
