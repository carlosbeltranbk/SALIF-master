/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import tmx.salif.gob.tarjeton.BeanTarjeton;
import tmx.salif.gob.tarjeton.DaoTarjeton;

/**
 *
 * @author Julia Sofia
 */
public class ActionTarjeton {
    
    private BeanTarjeton beanTarjeton = new BeanTarjeton();
    private DaoTarjeton daoTarjeton = new DaoTarjeton();
    private String mensaje;
    private boolean alerta;

    public BeanTarjeton getBeanTarjeton() {
        return beanTarjeton;
    }

    public void setBeanTarjeton(BeanTarjeton beanTarjeton) {
        this.beanTarjeton = beanTarjeton;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isAlerta() {
        return alerta;
    }

    public void setAlerta(boolean alerta) {
        this.alerta = alerta;
    }
    
    //Controlador encargado de llamar el metodo para la eliminacion logica de divisiones
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String cancelarTarjeton() {
        int periodo = Integer.parseInt(beanTarjeton.getPeriodo());
        if (daoTarjeton.cancelarTarjeton(beanTarjeton.getIdTarjeton(),periodo)) {
            alerta = true;
            mensaje = "La licencia ha sido suspendida correctamente..";
            return SUCCESS;
        } else {
            alerta = false;
            mensaje = "Hubo un error, la licencia no ha podido ser suspendida.";
            return ERROR;
        }
    }
    

    //Controlador encargado de llamar el metodo para la consulta especifica de licencias
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String consultarTarjetonId() {
        System.out.println("Numero licencia: " + beanTarjeton.getNo_Licencia());
        int periodo = Integer.parseInt(beanTarjeton.getPeriodo());
        beanTarjeton = daoTarjeton.consultarTarjetonId(beanTarjeton.getNo_Licencia(),periodo);
        if (beanTarjeton != null) {
            return SUCCESS;
        } else {
            mensaje = "No se ha encontrado esta licencia, verifique su información";
            return ERROR;
        }
    }
    
    //Controlador encargado de llamar el metodo para la consulta especifica de licencias
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String consultarTarjetonIdRegis(){
        beanTarjeton = daoTarjeton.consultarTarjetonIdRegis();
        if (beanTarjeton != null) {
            return SUCCESS;
        } else {
            mensaje = "No se ha encontrado esta licencia, verifique su información";
            return ERROR;
        }
    }

    //Controlador encargado de llamar el metodo para el registro de divisiones
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String registrarTarjeton() {
        if (daoTarjeton.registrarTarjeton(beanTarjeton.getNo_Licencia())) {
            alerta = true;
            mensaje = "La licencia se ha registrado correctamente.";
            return SUCCESS;
        } else {
            alerta = false;
            mensaje = "Hubo un error, la licencia no pudo ser registrada.";
            return ERROR;
        }
    }
}

