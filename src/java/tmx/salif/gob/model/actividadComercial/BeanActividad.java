/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.actividadComercial;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanActividad {
    
    private int idActividad;
    private String actividad;
    private String actividad_principal;
    private String actividad_secundaria;
    private String riesgo;
    private String giro;

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getActividad_principal() {
        return actividad_principal;
    }

    public void setActividad_principal(String actividad_principal) {
        this.actividad_principal = actividad_principal;
    }

    public String getActividad_secundaria() {
        return actividad_secundaria;
    }

    public void setActividad_secundaria(String actividad_secundaria) {
        this.actividad_secundaria = actividad_secundaria;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }
    
}
