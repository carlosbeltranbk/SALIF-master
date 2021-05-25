/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.licencia;

import tmx.salif.gob.model.contribuyente.BeanContribuyente;
import tmx.salif.gob.model.estado.BeanEstado;
import tmx.salif.gob.otrosdatos.BeanDatos;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanLicencia {

    private int idLicencia;
    private int folio;
    private int no_Licencia;
    private String giro;
    private String nombre_establecimiento;
    private String propietario;
    private String representante_legal;
    private BeanEstado fkestado;
    private String actividad_comercial;
    private String anotaciones;
    private String direccion;
    private String colonia;
    private int codigo_postal;
    private String correo;
    private int telefono;
    private String horario_apertura;
    private String horario_cierre;
    private String fecha;
    private String fecha_recibo;
    private BeanDatos fkotrosdatos;
    private BeanContribuyente fkcontribuyente;

    public String getFecha_recibo() {
        return fecha_recibo;
    }

    public void setFecha_recibo(String fecha_recibo) {
        this.fecha_recibo = fecha_recibo;
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public BeanDatos getFkotrosdatos() {
        return fkotrosdatos;
    }

    public void setFkotrosdatos(BeanDatos fkotrosdatos) {
        this.fkotrosdatos = fkotrosdatos;
    }

    public BeanContribuyente getFkcontribuyente() {
        return fkcontribuyente;
    }

    public void setFkcontribuyente(BeanContribuyente fkcontribuyente) {
        this.fkcontribuyente = fkcontribuyente;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getNo_Licencia() {
        return no_Licencia;
    }

    public void setNo_Licencia(int no_Licencia) {
        this.no_Licencia = no_Licencia;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getNombre_establecimiento() {
        return nombre_establecimiento;
    }

    public void setNombre_establecimiento(String nombre_establecimiento) {
        this.nombre_establecimiento = nombre_establecimiento;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getRepresentante_legal() {
        return representante_legal;
    }

    public void setRepresentante_legal(String representante_legal) {
        this.representante_legal = representante_legal;
    }

    public String getActividad_comercial() {
        return actividad_comercial;
    }

    public void setActividad_comercial(String actividad_comercial) {
        this.actividad_comercial = actividad_comercial;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getHorario_apertura() {
        return horario_apertura;
    }

    public void setHorario_apertura(String horario_apertura) {
        this.horario_apertura = horario_apertura;
    }

    public String getHorario_cierre() {
        return horario_cierre;
    }

    public void setHorario_cierre(String horario_cierre) {
        this.horario_cierre = horario_cierre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BeanEstado getFkestado() {
        return fkestado;
    }

    public void setFkestado(BeanEstado fkestado) {
        this.fkestado = fkestado;
    }

}
