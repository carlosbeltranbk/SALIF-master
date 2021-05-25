/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.cuentasContables;

/**
 *
 * @author BELTRAN PC
 */
public class BeanCuentasContables {
    private int idCuenta;
    private String concepto;
    private int UMAS;

    public int getUMAS() {
        return UMAS;
    }

    public void setUMAS(int UMAS) {
        this.UMAS = UMAS;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    private String cuenta ;
}
