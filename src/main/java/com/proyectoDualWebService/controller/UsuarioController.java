package com.proyectoDualWebService.controller;

//TODO REVISAR BIEN LOS CONTROLADORES

import com.proyectoDualWebService.dao.UsuarioDAO;
import com.proyectoDualWebService.model.Usuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
public class UsuarioController {

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") int id){
        return Response.ok()
                .entity(new UsuarioDAO().findById(id))
                .build();
    }

    @GET
    @Path("/obtenerTodoUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTodoUsuario(){
        List<Usuario> usuarios = new UsuarioDAO().obtenerTodoUsuario();
        return Response.ok()
                .entity(usuarios)
                .build();
    }

    @POST
    @Path("/insertarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarUsuario(Usuario usuario){
        new UsuarioDAO().insertarUsuario(usuario);
        return Response.status(Response.Status.CREATED)
                .entity("Usuario creado correctamente")
                .build();
    }

    @PUT
    @Path("/actualizarUsuario/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarUsuario(@PathParam("id") int id, Usuario usuario){
        usuario.setId(id);
        new UsuarioDAO().actualizarUsuario(usuario);
        return Response.ok()
                .entity("Usuario actualizado correctamente")
                .build();
    }

    @DELETE
    @Path("/eliminarUsuario/{id}")
    public Response eliminarUsuario(@PathParam("id") int id){
        new UsuarioDAO().eliminarUsuario(id);
        return Response.ok()
                .entity("Usuario eliminado correctamente")
                .build();
    }

}