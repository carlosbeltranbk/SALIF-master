/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import tmx.salif.gob.model.historialMovimientos.BeanHistorailMovimientos;
import tmx.salif.gob.model.historialMovimientos.DaoHistorailMovimientos;

/**
 *
 * @author Hp
 */
public class ActionHistorialMovimientos {
     private BeanHistorailMovimientos beanLicencia = new BeanHistorailMovimientos();
    private DaoHistorailMovimientos daoHistorial = new DaoHistorailMovimientos();
    private List<BeanHistorailMovimientos> listaHistorial = new ArrayList<BeanHistorailMovimientos>();
    
    
    public String consultarHistorialMovimientos(){
        listaHistorial = daoHistorial.consultarHistorialMovimientos();
        return SUCCESS;
    }

    public BeanHistorailMovimientos getBeanLicencia() {
        return beanLicencia;
    }

    public void setBeanLicencia(BeanHistorailMovimientos beanLicencia) {
        this.beanLicencia = beanLicencia;
    }

    public List<BeanHistorailMovimientos> getListaHistorial() {
        return listaHistorial;
    }

    public void setListaHistorial(List<BeanHistorailMovimientos> listaHistorial) {
        this.listaHistorial = listaHistorial;
    }
    
}
