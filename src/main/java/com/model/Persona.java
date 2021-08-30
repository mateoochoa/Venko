package com.model;

public class Persona {
    

    private String PrimerNombre;
    private String SegundoNombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private String TipoDocumento;
    private String FechaExpedicion;
    private Integer NumeroDocumento;


    public String getPrimerNombre() {
        return this.PrimerNombre;
    }
    
    public void constructor(String PrimerNombre,String SegundoNombre,String PrimerApellido,String SegundoApellido,String TipoDocumento,String FechaExpedicion,Integer NumeroDocumento){        
            this.PrimerNombre=PrimerNombre;
            this.SegundoNombre=SegundoNombre;
            this.PrimerApellido=PrimerApellido;
            this.SegundoApellido=SegundoApellido;
            this.TipoDocumento=TipoDocumento;
            this.FechaExpedicion=FechaExpedicion;
            this.NumeroDocumento=NumeroDocumento;        

    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }
    

    public String getSegundoNombre() {
        return this.SegundoNombre;
    }
    

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }
    

    public String getPrimerApellido() {
        return this.PrimerApellido;
    }
    

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }
    

    public String getSegundoApellido() {
        return this.SegundoApellido;
    }
    

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }
    

    public String getTipoDocumento() {
        return this.TipoDocumento;
    }
    

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }
    

    public String getFechaExpedicion() {
        return this.FechaExpedicion;
    }
    

    public void setFechaExpedicion(String FechaExpedicion) {
        this.FechaExpedicion = FechaExpedicion;
    }
    

    public Integer getNumeroDocumento() {
        return this.NumeroDocumento;
    } 
    
}
