/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tmx.salif.gob.model.actividadComercial.BeanActividad;
import tmx.salif.gob.model.actividadComercial.DaoActividad;
import tmx.salif.gob.model.estado.BeanEstado;
import tmx.salif.gob.model.estado.DaoEstado;
import tmx.salif.gob.model.licencia.BeanLicencia;
import tmx.salif.gob.model.licencia.DaoLicencia;

/**
 *
 * @author Oscar Rodríguez
 */
public class ActionLicencia {

    private BeanLicencia beanLicencia = new BeanLicencia();
    private DaoLicencia daoLicencia = new DaoLicencia();
    private List<BeanEstado> listaEstado = new ArrayList<BeanEstado>();
    private List<BeanActividad> listaActividad = new ArrayList<BeanActividad>();
    private String mensaje;
    private boolean alerta;

    /**
     * @param: Get Metodos cada uno a su respectiva variable sirve para obtener
     * su información.
     * @param: Set Metodos cada uno a su respectiva variable sirve para asignar
     * un valor a la variable.
     * @return: Los metodos get retornan la informacion contenida en la variable
     * del objeto.
     */
    public BeanLicencia getBeanLicencia() {
        return beanLicencia;
    }

    public void setBeanLicencia(BeanLicencia beanLicencia) {
        this.beanLicencia = beanLicencia;
    }

    public List<BeanEstado> getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(List<BeanEstado> listaEstado) {
        this.listaEstado = listaEstado;
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

    public List<BeanActividad> getListaActividad() {
        return listaActividad;
    }

    public void setListaActividad(List<BeanActividad> listaActividad) {
        this.listaActividad = listaActividad;
    }
    
    //Controlador encargado de llamar el metodo para la eliminacion logica de divisiones
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String eliminarLicencia() {
        if (daoLicencia.eliminarLicencia(beanLicencia.getNo_Licencia())) {
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
    public String consultarLicenciaId() {
        DaoEstado daoEstado = new DaoEstado();
        System.out.println("Numero licencia: " + beanLicencia.getNo_Licencia());
        beanLicencia = daoLicencia.consultarLicenciaId(beanLicencia.getNo_Licencia());
        
        
        listaEstado = daoEstado.consultarEstados();
        if (beanLicencia != null) {
            return SUCCESS;
        } else {
            mensaje = "No se ha encontrado esta licencia, verifique su información";
            return ERROR;
        }
    }

    //Controlador encargado de llamar el metodo para la consulta especifica de licencias
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String eliminarLicenciaId() {
        DaoEstado daoEstado = new DaoEstado();
        System.out.println("Numero licencia: " + beanLicencia.getNo_Licencia());
        beanLicencia = daoLicencia.consultarLicenciaId(beanLicencia.getNo_Licencia());
        listaEstado = daoEstado.consultarEstados();
        if (beanLicencia != null) {
            return SUCCESS;
        } else {
            mensaje = "No se ha encontrado esta licencia, verifique su información";
            return ERROR;
        }
    }

    //Controlador encargado de llamar al metodo de consulta de licencias
    //Para mostrar una lista de administradores disponibles en el registro de licencias
    public String registroLicencia() {
        DaoEstado daoEstado = new DaoEstado();
        DaoActividad daoActividad = new DaoActividad();
        listaEstado = daoEstado.consultarEstados();
        listaActividad = daoActividad.consultarActividades();
        beanLicencia = daoLicencia.numLicenciaRegis();
        if (listaActividad != null) {
            return SUCCESS;
        } else {
            mensaje = "No se ha encontrado esta licencia, verifique su información";
            return ERROR;
        }
    }

    //Controlador encargado de llamar el metodo para el registro de licencias
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String registrarLicencia() {
        if (daoLicencia.registrarLicencia(beanLicencia)) {
            alerta = true;
            mensaje = "La licencia se ha registrado correctamente.";
            return SUCCESS;
        } else {
            alerta = false;
            mensaje = "Hubo un error, la licencia no pudo ser registrada.";
            return ERROR;
        }
    }

    //Controlador encargado de llamar el metodo para el registro de licencias
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String solicitarInspeccion() {
        if (daoLicencia.solicitarInspeccion(beanLicencia.getNo_Licencia())) {
            alerta = true;
            mensaje = "La inspección se ha solicitado correctamente.";
            return SUCCESS;
        } else {
            alerta = false;
            mensaje = "Hubo un error al solicitar la inspección.";
            return ERROR;
        }
    }

    //Controlador encargado de llamar el metodo para la modificacion de informacion de licencias
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String modificarLicencia() {
        if (daoLicencia.modificarLicencia(beanLicencia)) {
            alerta = true;
            mensaje = "La licencia se ha modificado correctamente..";
            return SUCCESS;
        } else {
            alerta = false;
            mensaje = "Hubo un error, la licencia no pudo ser modificada.";
            return ERROR;
        }
    }
}
