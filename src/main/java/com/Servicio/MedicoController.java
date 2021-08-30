/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Servicio;

/**
 *
 * @author Mateo
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Medico;
import com.model.Response;

@Path("/Medico")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MedicoController implements MedicoServicio {
    private static Map<Integer,Medico> medicos = new HashMap<Integer,Medico>();
    
    @Override
    @POST
    @Path("/Crear")
    public Response Crear(Medico m) {
        Response response = new Response();
        if(medicos.get(m.getNumeroDocumento())!= null){
            response.setStatus(false);
            response.setMessage("El medico ya existe");
            return response;
        }else{
            medicos.put(m.getNumeroDocumento(),m);
            response.setStatus(true);
            response.setMessage("El medico se creo exitosamente");
            return response;
        }                
    }

    @Override
    @GET
    @Path("/{id}/{PrimerNomre}/{SegundoNombre}/{PrimerApellido}/{SegundoApellido}/{TipoDocumento}/{FechaExpedicion}/Editar")
    public Response Editar(@PathParam("id") int NumeroDocumento,
            @PathParam("PrimerNombre") String PrimerNombre,
            @PathParam("SegundoNombre") String SegundoNombre,
            @PathParam("PrimerApellido") String PrimerApellido,
            @PathParam("SegundoApellido") String SegundoApellido,
            @PathParam("FechaExpedicion") String FechaExpedicion) {
        Response response = new Response();
        if(medicos.get(NumeroDocumento)== null){
            response.setStatus(false);
            response.setMessage("El medico no existe");
            return response;
        }else{
            Medico medico = medicos.get(NumeroDocumento);
            medico.setPrimerNombre(PrimerNombre);
            medico.setSegundoNombre(SegundoNombre);
            medico.setPrimerApellido(PrimerApellido);
            medico.setSegundoApellido(SegundoApellido);
            medico.setFechaExpedicion(FechaExpedicion);
            response.setStatus(true);
            response.setMessage("Se ha cambiado la información del medico exitosamente");
            return response;
        }   
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Medico getInfo(@PathParam("id") int NumeroDocumento) {
        return medicos.get(NumeroDocumento);
    }

    @Override
    @GET
    @Path("/{id}/Eliminar")
    public Response Eliminar(@PathParam("id") int NumeroDocumento) {
        Response response = new Response();
        if(medicos.get(NumeroDocumento)== null){
            response.setStatus(false);
            response.setMessage("El medico no existe");
            return response;
        }else{
            medicos.remove(NumeroDocumento);
            response.setStatus(true);
            response.setMessage("El medico se ha eliminado exitosamente");
            return response;
        }           
    }
    
    @Override
    @GET
    @Path("/getAll")
    public Medico[] getMedicos(){
        Set<Integer> ids = medicos.keySet();
        Medico [] m = new Medico[ids.size()];
        int i=0;
        for(Integer id: ids){
            m[i] = medicos.get(id);
            i++;
        }
        return m;
    }
}
