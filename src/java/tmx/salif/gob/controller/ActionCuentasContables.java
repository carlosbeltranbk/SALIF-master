/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import tmx.salif.gob.model.cuentasContables.BeanCuentasContables;
import tmx.salif.gob.model.cuentasContables.DaoCuentasContables;

/**
 *
 * @author BELTRAN PC
 */
public class ActionCuentasContables {
     private BeanCuentasContables beanCuentasContables = new BeanCuentasContables();
    private DaoCuentasContables daoCuentas = new DaoCuentasContables();
        private String mensaje;
    private List<BeanCuentasContables> listaCuentasContables = new ArrayList<BeanCuentasContables>();
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public BeanCuentasContables getBeanCuentasContables() {
        return beanCuentasContables;
    }

    public void setBeanCuentasContables(BeanCuentasContables beanCuentasContables) {
        this.beanCuentasContables = beanCuentasContables;
    }

    public List<BeanCuentasContables> getListaEstado() {
        return listaCuentasContables;
    }

    public void setListaEstado(List<BeanCuentasContables> listaCuentasContables) {
        this.listaCuentasContables = listaCuentasContables;
    }
    
    
    public String consultarCuentasContables() {  
        
        listaCuentasContables = daoCuentas.consultarCuentasContables();
       
       return SUCCESS;
    }
    
    
    public String consultarCuentaContableCuenta() {
        
        listaCuentasContables = daoCuentas.consultarCuentaContableConcepto(beanCuentasContables.getCuenta());
       
        if (beanCuentasContables != null) {
            return SUCCESS;
        } else {
            mensaje = "No se ha encontrado esta licencia, verifique su información";
            return ERROR;
        }
    }
    
}
