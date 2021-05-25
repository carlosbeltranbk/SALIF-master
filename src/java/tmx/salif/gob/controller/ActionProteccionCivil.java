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
import tmx.salif.gob.proteccionCivil.BeanProteccionCivil;
import tmx.salif.gob.proteccionCivil.DaoProteccionCivil;

/**
 *
 * @author Rebecca Lanuss
 */
public class ActionProteccionCivil {
    
    private BeanProteccionCivil bean = new BeanProteccionCivil();
    private DaoProteccionCivil dao = new DaoProteccionCivil();
    private List<BeanProteccionCivil> lista1 = new ArrayList<>();
    private List<BeanProteccionCivil> lista2 = new ArrayList<>();
    private String mensaje;

    public BeanProteccionCivil getBean() {
        return bean;
    }

    public void setBean(BeanProteccionCivil bean) {
        this.bean = bean;
    }

    public List<BeanProteccionCivil> getLista1() {
        return lista1;
    }

    public void setLista1(List<BeanProteccionCivil> lista) {
        this.lista1 = lista;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<BeanProteccionCivil> getLista2() {
        return lista2;
    }
    public void setLista2(List<BeanProteccionCivil> lista2) {
        this.lista2 = lista2;
    }
    
    
    
     public String consultarInspeccionesNorealizadas() {
        lista1 = dao.consultarInspeccionesNorealizadas();
        lista2 = dao.consultarInspeccionesRealizadas();
        if (mensaje == null) {
            mensaje = "Datos cargados correctamencte";
        }
        return SUCCESS;
    }
     
      public String cambiarInspeccion() {
        if (dao.cambiarInspeccion(bean.getIdPc())) {
            mensaje = "Anaquel eliminado";
            return SUCCESS;
        } else {
            mensaje = "Anaquel no eliminado";
            return ERROR;
        }
      }
}
