package com.proyectoDualWebService.controller;

//TODO REVISAR BIEN LOS CONTROLADORES

import com.proyectoDualWebService.service.UsuarioService;
import com.proyectoDualWebService.dto.Usuario;
import com.proyectoDualWebService.persistence.manager.impl.ManagerUsuarioImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioDAO;

    public UsuarioController(){
        this.usuarioDAO = new UsuarioService(new ManagerUsuarioImpl());
    }

    @GET
    @Path("/getAllUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException {
        return Response.ok().entity(usuarioDAO.findAllUsuario()).build();
    }

    @GET
    @Path("/getUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Integer id) {
        if (id == null){
            return Response.status(400).entity("Parámetros incorrectos").build();
        } else {
            return Response.ok().entity(usuarioDAO.findById(id)).build();
        }
    }

    @POST
    @Path("/createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(Usuario usuario){
        int id = usuarioDAO.createUser(usuario);
        if (id > 0) {
            return Response.status(201).entity(usuarioDAO.findById(id)).build();
        } else {
            return Response.status(500).entity("Error interno").build();
        }

    }

    @PUT
    @Path("/updateUser/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, Usuario usuario){
        Usuario usuarioBD = usuarioDAO.findById(usuario.getId());
        if (usuarioBD != null){
            if (usuarioDAO.updateUser(usuario)){
                return Response.status(200).entity(usuarioDAO.findById(usuario.getId())).build();
            } else {
                return Response.status(500).entity("Error interno").build();
            }
        } else {
            return Response.status(404).entity("Usuario no encontrado").build();
        }
    }

    @DELETE
    @Path("/deleteUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") int id){
        try {
            Usuario usuario = usuarioDAO.findById(id);
            if (usuario != null){
                if (usuarioDAO.deleteUser(id)) {
                    return Response.status(200).entity(usuario).build();
                } else {
                    return Response.status(304).entity("Usuario no eliminado").build();
                }
            } else {
                return Response.status(404).entity("Usuario no encontrado").build();
            }
        } catch (SQLException | ClassNotFoundException e){
            return Response.status(500).entity("Error interno").build();
        }
    }

}