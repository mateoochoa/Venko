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
import com.Servicio.MedicoServicio;
        
public class Medico extends Persona {
    
    private MedicoServicio medicoServicio;

    public MedicoServicio getMedicoServicio() {
        return this.medicoServicio;
    }

    public MedicoServicio setMedicoServicio(MedicoServicio medicoServicio) {
        this.medicoServicio = medicoServicio;
        return null;
    }
    
}