/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servicio;
import com.model.Response;
import com.model.Medico;

/**
 *
 * @author Mateo
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Medico")
public interface MedicoServicio {

    /**
     *
     * @return
     */
    @GET
    @Path("/Crear")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Crear(Medico m);
    public Response Editar(@PathParam("id") int NumeroDocumento,
            @PathParam("PrimerNombre") String PrimerNombre,
            @PathParam("SegundoNombre") String SegundoNombre,
            @PathParam("PrimerApellido") String PrimerApellido,
            @PathParam("SegundoApellido") String SegundoApellido,
            @PathParam("FechaExpedicion") String FechaExpedicion);
    public Medico getInfo(@PathParam("id") int NumeroDocumento) ;
    public Response Eliminar(@PathParam("id") int NumeroDocumento) ;
    public Medico[] getMedicos();
    
}
