/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.usodesuelo;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanUsoSuelo {
    
   private int idSuelo;
   private int folio;
   private int no_recibo_pago;
   private String fecha_oficio;
   private String fecha_recibo_pago;
   private String veredicto;

    public int getIdSuelo() {
        return idSuelo;
    }

    public void setIdSuelo(int idSuelo) {
        this.idSuelo = idSuelo;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getNo_recibo_pago() {
        return no_recibo_pago;
    }

    public void setNo_recibo_pago(int no_recibo_pago) {
        this.no_recibo_pago = no_recibo_pago;
    }

    public String getFecha_oficio() {
        return fecha_oficio;
    }

    public void setFecha_oficio(String fecha_oficio) {
        this.fecha_oficio = fecha_oficio;
    }

    public String getFecha_recibo_pago() {
        return fecha_recibo_pago;
    }

    public void setFecha_recibo_pago(String fecha_recibo_pago) {
        this.fecha_recibo_pago = fecha_recibo_pago;
    }

    public String getVeredicto() {
        return veredicto;
    }

    public void setVeredicto(String veredicto) {
        this.veredicto = veredicto;
    }
   
}