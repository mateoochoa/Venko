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

import com.model.Paciente;
import com.model.Response;

@Path("/Paciente")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PacienteController implements PacienteServicio {
    private static Map<Integer,Paciente> Pacientes = new HashMap<Integer,Paciente>();
    
    @Override
    @POST
    @Path("/Crear")
    public Response Crear(Paciente m) {
        Response response = new Response();
        if(Pacientes.get(m.getNumeroDocumento())!= null){
            response.setStatus(false);
            response.setMessage("El Paciente ya existe");
            return response;
        }else{
            Pacientes.put(m.getNumeroDocumento(),m);
            response.setStatus(true);
            response.setMessage("El Paciente se creo exitosamente");
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
        if(Pacientes.get(NumeroDocumento)== null){
            response.setStatus(false);
            response.setMessage("El Paciente no existe");
            return response;
        }else{
            Paciente Paciente = Pacientes.get(NumeroDocumento);
            Paciente.setPrimerNombre(PrimerNombre);
            Paciente.setSegundoNombre(SegundoNombre);
            Paciente.setPrimerApellido(PrimerApellido);
            Paciente.setSegundoApellido(SegundoApellido);
            Paciente.setFechaExpedicion(FechaExpedicion);
            response.setStatus(true);
            response.setMessage("Se ha cambiado la información del Paciente exitosamente");
            return response;
        }   
    }

    @Override
    @GET
    @Path("/{id}/get")
    public Paciente getInfo(@PathParam("id") int NumeroDocumento) {
        return Pacientes.get(NumeroDocumento);
    }

    @Override
    @GET
    @Path("/{id}/Eliminar")
    public Response Eliminar(@PathParam("id") int NumeroDocumento) {
        Response response = new Response();
        if(Pacientes.get(NumeroDocumento)== null){
            response.setStatus(false);
            response.setMessage("El Paciente no existe");
            return response;
        }else{
            Pacientes.remove(NumeroDocumento);
            response.setStatus(true);
            response.setMessage("El Paciente se ha eliminado exitosamente");
            return response;
        }           
    }
    
    @Override
    @GET
    @Path("/getAll")
    public Paciente[] getPacientes(){
        Set<Integer> ids = Pacientes.keySet();
        Paciente [] m = new Paciente[ids.size()];
        int i=0;
        for(Integer id: ids){
            m[i] = Pacientes.get(id);
            i++;
        }
        return m;
    }
}
