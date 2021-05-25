/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.contribuyente;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanContribuyente {
    
    private int idDatos_contribuyente;
    private String direccionCont;
    private String coloniaCont;
    private String asociacion;

    public int getIdDatos_contribuyente() {
        return idDatos_contribuyente;
    }

    public void setIdDatos_contribuyente(int idDatos_contribuyente) {
        this.idDatos_contribuyente = idDatos_contribuyente;
    }

    public String getDireccionCont() {
        return direccionCont;
    }

    public void setDireccionCont(String direccionCont) {
        this.direccionCont = direccionCont;
    }

    public String getColoniaCont() {
        return coloniaCont;
    }

    public void setColoniaCont(String coloniaCont) {
        this.coloniaCont = coloniaCont;
    }

    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }
    
}