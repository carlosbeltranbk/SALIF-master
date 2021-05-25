/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.otrosdatos;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanOtrosDatos {
    
    private int idDatos;
    private String fecha_alta_padron;
    private String fecha_alta_shcp;
    private String curp;
    private String rfc;
    private int no_empleados;
    private double superficie;
    private String observaciones;

    public int getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
    }

    public String getFecha_alta_padron() {
        return fecha_alta_padron;
    }

    public void setFecha_alta_padron(String fecha_alta_padron) {
        this.fecha_alta_padron = fecha_alta_padron;
    }

    public String getFecha_alta_shcp() {
        return fecha_alta_shcp;
    }

    public void setFecha_alta_shcp(String fecha_alta_shcp) {
        this.fecha_alta_shcp = fecha_alta_shcp;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getNo_empleados() {
        return no_empleados;
    }

    public void setNo_empleados(int no_empleados) {
        this.no_empleados = no_empleados;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
