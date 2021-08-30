/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Mateo
 */
import com.Servicio.PacienteServicio;
        
public class Paciente extends Persona {
    
    private PacienteServicio PacienteServicio;

    public PacienteServicio getPacienteServicio() {
        return this.PacienteServicio;
    }

    public PacienteServicio setPacienteServicio(PacienteServicio PacienteServicio) {
        this.PacienteServicio = PacienteServicio;
        return null;
    }
    
}