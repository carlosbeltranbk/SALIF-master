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
import tmx.salif.gob.model.cuentasContables.BeanCuentasContables;
import tmx.salif.gob.model.cuentasContables.DaoCuentasContables;
import tmx.salif.gob.model.estado.BeanEstado;
import tmx.salif.gob.model.estado.DaoEstado;
import tmx.salif.gob.model.historialMovimientos.DaoHistorailMovimientos;
import tmx.salif.gob.model.licencia.BeanLicencia;
import tmx.salif.gob.model.licencia.DaoLicencia;
import tmx.salif.gob.model.ordenDePago.DaoOrdenDePago;
import tmx.salif.gob.model.usuario.Usuario;

/**
 *
 * @author BELTRAN PC
 */
public class ActionOrdenDePago {

    private List<BeanCuentasContables> listaCuentasContables = new ArrayList<BeanCuentasContables>();

    public List<BeanCuentasContables> getListaCuentasContables() {
        return listaCuentasContables;
    }

    public void setListaCuentasContables(List<BeanCuentasContables> listaCuentasContables) {
        this.listaCuentasContables = listaCuentasContables;
    }
    private BeanLicencia beanLicencia = new BeanLicencia();
    private DaoLicencia daoLicencia = new DaoLicencia();
    private DaoOrdenDePago daoOrden = new DaoOrdenDePago();
    private DaoCuentasContables daoCuentas = new DaoCuentasContables();
    private DaoHistorailMovimientos daoHistorial = new DaoHistorailMovimientos();
            
    private List<BeanEstado> listaEstado = new ArrayList<BeanEstado>();
    private List<BeanActividad> listaActividad = new ArrayList<BeanActividad>();
    private List<BeanCuentasContables> listaCuentasContablesPreview = new ArrayList();
    private double totalPago = 0.0;

    public List<BeanCuentasContables> getListaCuentasContablesPreview() {
        return listaCuentasContablesPreview;
    }

    public void setListaCuentasContablesPreview(List<BeanCuentasContables> listaCuentasContablesPreview) {
        this.listaCuentasContablesPreview = listaCuentasContablesPreview;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }
    private String mensaje;
    private boolean alerta;
    private String idsCuentasContables;

    public String getIdsCuentasContables() {
        return idsCuentasContables;
    }

    public void setIdsCuentasContables(String idsCuentasContables) {
        this.idsCuentasContables = idsCuentasContables;
    }

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

    public String previewConceptos() {
        String[] ids = idsCuentasContables.split(",");

        System.out.println("entroo al preview idscuentascontables" + ids.length);
        for (int i = 1; i < ids.length; i++) {
            listaCuentasContablesPreview.add(daoCuentas.consultarCuentaContableId(Integer.parseInt(ids[i])));
            totalPago += listaCuentasContablesPreview.get(i - 1).getUMAS() * 84.99;
        }
        return SUCCESS;
    }

    public String crearOrdenDePagoId() {
        Map sesion = ActionContext.getContext().getSession();
        
        int idLicencia = 0;
        int ultima = 0;       
        idLicencia = (int) sesion.get("idLicencia");       
        ultima = daoOrden.ultimaOrdenDePago() + 1;   
        listaCuentasContables = daoCuentas.consultarCuentasContables();

        Usuario usuariologeado = (Usuario) sesion.get("usuarioLogeado");
        int ultimoHistorial = daoHistorial.ultimoMovimientoHistorial() + 1;
        String movimiento="El Usuario :"+usuariologeado.getNombreUsuario()+" Creo la orden de pago : "+ultima+" para el numero de licencia: "+idLicencia;
        boolean result=(daoHistorial.registrarMovimientoHistorial(ultimoHistorial,usuariologeado.getIdUsuario(),movimiento));
        if (daoOrden.registrarOrdenDePago(ultima, idLicencia)) {
            return SUCCESS;
        } else {
            return ERROR;
        }

    }

    public String registrarOrdenDePagoConceptos() {
     
        totalPago = 0.0;
        String[] ids = idsCuentasContables.split(",");
        
        int idRed = daoOrden.ultimaOrdenDePago();
        for (int i = 1; i < ids.length; i++) {
            boolean resultado;
            int idConceptos;
            idConceptos = Integer.parseInt(ids[i])  ;            
            int idultimaOrdenConcepto = daoOrden.ultimaOrdenDePagoConcepto() + 1;
            resultado = daoOrden.registrarOrdenDePagoConceptos(idultimaOrdenConcepto, idRed, idConceptos);
            
            Map sesion = ActionContext.getContext().getSession();
        Usuario usuariologeado = (Usuario) sesion.get("usuarioLogeado");
        int ultimoHistorial = daoHistorial.ultimoMovimientoHistorial() + 1;
        String movimiento="El Usuario :"+usuariologeado.getNombreUsuario()+" Registro la cuenta contable con id : "+idConceptos+" para la Orden de pago: "+idRed ;
        boolean result=(daoHistorial.registrarMovimientoHistorial(ultimoHistorial,usuariologeado.getIdUsuario(),movimiento));
        }
        return SUCCESS;
    
        
    }

    public String eliminarOrdenDePago() {
        if (daoOrden.eliminarUltimaOrdenDePago(daoOrden.ultimaOrdenDePago())) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    //Controlador encargado de llamar el metodo para la consulta especifica de licencias
    //A su vez lanza un mensaje y tipo de alarte que se mostrara al usuario.
    public String consultarLicenciaOrdenPagoId() {
        DaoEstado daoEstado = new DaoEstado();
        System.out.println("Numero licencia: " + beanLicencia.getNo_Licencia());
        beanLicencia = daoLicencia.consultarLicenciaId(beanLicencia.getNo_Licencia());
        listaEstado = daoEstado.consultarEstados();
        Map sesion = ActionContext.getContext().getSession();
        sesion.put("idLicencia", beanLicencia.getIdLicencia());
        if (beanLicencia != null) {
            return SUCCESS;
        } else {
            mensaje = "No se ha encontrado esta licencia, verifique su información";
            return ERROR;
        }
    }
    public String OrdenDePago(){
        return SUCCESS;
    }

}
