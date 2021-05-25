
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.licencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tmx.salif.gob.model.contribuyente.BeanContribuyente;
import tmx.salif.gob.model.estado.BeanEstado;
import tmx.salif.gob.otrosdatos.BeanDatos;
import tmx.salim.gob.servicios.Conexion;

/**
 *
 * @author Oscar Rodríguez
 */
public class DaoLicencia {

    /**
     * @param: singletonConexion Genera la instancia para la conexion con la
     * base de datos.
     * @param: conexion Establece conexión entre la base de datos y web.
     * @param: rs Dispone de los datos entre la base y el sistema.
     * @param: pstm Prepara y ejecuta las sentencias entre la base de datos y el
     * sistema web.
     */
    private Conexion singletonConexion = Conexion.getInstance();
    private Connection conexion;
    private ResultSet rs;
    private PreparedStatement pstm;

    final private String CONSULTA_LICENCIA = "call mysql_consultar_licencia(?);";
    final private String REGISTRAR_LICENCIA = "call mysql_registro_licencia(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    final private String MODIFICAR_LICENCIA = "call mysql_modificacion_licencia(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    final private String SUSPENDER_LICENCIA = "call mysql_suspencion_licencia(?);";
    final private String INSPECCION_SOLICITAR = "call mysql_solicitar_inspeccion(?);";
    final private String NUM_LICREGIS = "call mysql_num_lic_regis();";

    /**
     * Metodo encargado de obtener los datos correspondientes a una licencia.
     *
     * @param no_Licencia Recibe el numero de la licencia que se buscara.
     * @return Retorna un objeto licencia especifico.
     */
    public BeanLicencia consultarLicenciaId(int no_Licencia) {
        BeanLicencia beanLicencia = null;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(CONSULTA_LICENCIA);
            pstm.setInt(1, no_Licencia);
            rs = pstm.executeQuery();
            if (rs.next()) {
                beanLicencia = new BeanLicencia();
                beanLicencia.setIdLicencia(rs.getInt("idLicencia"));
                beanLicencia.setNo_Licencia(rs.getInt("no_Licencia"));
                beanLicencia.setFolio(rs.getInt("folio"));
                beanLicencia.setGiro(rs.getString("giro"));
                beanLicencia.setNombre_establecimiento(rs.getString("nombre_establecimiento"));
                beanLicencia.setPropietario(rs.getString("propietario"));
                beanLicencia.setRepresentante_legal(rs.getString("representante_legal"));
                beanLicencia.setActividad_comercial(rs.getString("actividad_comercial"));
                beanLicencia.setAnotaciones(rs.getString("anotaciones"));
                beanLicencia.setDireccion(rs.getString("direccion"));
                beanLicencia.setColonia(rs.getString("colonia"));
                beanLicencia.setCodigo_postal(rs.getInt("codigo_postal"));
                beanLicencia.setCorreo(rs.getString("correo"));
                beanLicencia.setTelefono(rs.getInt("telefono"));
                beanLicencia.setHorario_apertura(rs.getString("horario_apertura"));
                beanLicencia.setHorario_cierre(rs.getString("horario_cierre"));
                beanLicencia.setFecha(rs.getString("fecha"));
                beanLicencia.setFecha_recibo(rs.getString("fecha_recibo"));

                BeanEstado estado = new BeanEstado();
                estado.setIdEstado_licencia(rs.getInt("idEstado_licencia"));
                estado.setEstado(rs.getString("estado"));
                estado.setDescripcion(rs.getString("descripcion"));

                BeanContribuyente contribuyente = new BeanContribuyente();
                contribuyente.setIdDatos_contribuyente(rs.getInt("idDatos_contribuyente"));
                contribuyente.setDireccionCont(rs.getString("direccionCont"));
                contribuyente.setColoniaCont(rs.getString("coloniaCont"));
                contribuyente.setAsociacion(rs.getString("asociacion"));

                BeanDatos otrosDatos = new BeanDatos();
                otrosDatos.setIdDatos(rs.getInt("idDatos"));
                otrosDatos.setFecha_alta_padron(rs.getString("fecha_alta_padron"));
                otrosDatos.setFecha_alta_shcp(rs.getString("fecha_alta_shcp"));
                otrosDatos.setCurp(rs.getString("curp"));
                otrosDatos.setRfc(rs.getString("rfc"));
                otrosDatos.setNo_empleados(rs.getInt("no_empleados"));
                otrosDatos.setSuperficie(rs.getDouble("superficie"));
                otrosDatos.setObservaciones(rs.getString("observaciones"));

                beanLicencia.setFkestado(estado);
                beanLicencia.setFkotrosdatos(otrosDatos);
                beanLicencia.setFkcontribuyente(contribuyente);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultaLicencia() del DaoLicencia -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarLicenciaId() " + e.getMessage());
            }
        }
        return beanLicencia;
    }

    /**
     * Metodo encargo del registro de nuevas licencias.
     *
     * @param beanLicencia Recibe un objeto de tipo licencia
     * @param beanContribuyente Recibe un objeto de tipo contribuyente
     * @param beanOtrosDatos Recibe un objeto de tipo Otros Datos
     * @return: Un dato logico que confirma si fue correcto o incorrecto el
     * registro.
     */
    public boolean registrarLicencia(BeanLicencia beanLicencia) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(REGISTRAR_LICENCIA);
            pstm.setString(1, beanLicencia.getGiro());
            pstm.setString(2, beanLicencia.getNombre_establecimiento());
            pstm.setString(3, beanLicencia.getPropietario());
            pstm.setString(4, beanLicencia.getRepresentante_legal());
            pstm.setInt(5, beanLicencia.getFkestado().getIdEstado_licencia());
            pstm.setString(6, beanLicencia.getActividad_comercial());
            pstm.setString(7, beanLicencia.getAnotaciones());
            pstm.setString(8, beanLicencia.getDireccion());
            pstm.setString(9, beanLicencia.getColonia());
            pstm.setInt(10, beanLicencia.getCodigo_postal());
            pstm.setString(11, beanLicencia.getCorreo());
            pstm.setInt(12, beanLicencia.getTelefono());
            pstm.setString(13, beanLicencia.getHorario_apertura());
            pstm.setString(14, beanLicencia.getHorario_cierre());
            pstm.setString(15, beanLicencia.getFkcontribuyente().getDireccionCont());
            pstm.setString(16, beanLicencia.getFkcontribuyente().getColoniaCont());
            pstm.setString(17, beanLicencia.getFkcontribuyente().getAsociacion());
            pstm.setString(18, beanLicencia.getFkotrosdatos().getFecha_alta_shcp());
            pstm.setString(19, beanLicencia.getFkotrosdatos().getCurp());
            pstm.setString(20, beanLicencia.getFkotrosdatos().getRfc());
            pstm.setInt(21, beanLicencia.getFkotrosdatos().getNo_empleados());
            pstm.setDouble(22, beanLicencia.getFkotrosdatos().getSuperficie());
            pstm.setString(23, beanLicencia.getFkotrosdatos().getObservaciones());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método registrarLicencia() del DaoLicencia -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    /**
     * Metodo encargado de modificar los datos de un objeto Licencia
     *
     * @param beanLicencia Almacena un objeto de tipo Licencia
     * @param beanContribuyente Almacena un objeto de tipo Contribuyente
     * @param beanOtrosDatos Almecena un objeto de tipo Otros Datos
     * @param beanUsoSuelo Almacena un objeto de tipo Uso de Suelo
     * @return: Un dato logico que confirma si fue correcto o incorrecto la
     * modificación.
     */
    public boolean modificarLicencia(BeanLicencia beanLicencia) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(MODIFICAR_LICENCIA);
            pstm.setInt(1, beanLicencia.getNo_Licencia());
            pstm.setString(2, beanLicencia.getGiro());
            pstm.setString(3, beanLicencia.getNombre_establecimiento());
            pstm.setString(4, beanLicencia.getPropietario());
            pstm.setString(5, beanLicencia.getRepresentante_legal());
            pstm.setInt(6, beanLicencia.getFkestado().getIdEstado_licencia());
            pstm.setString(7, beanLicencia.getActividad_comercial());
            pstm.setString(8, beanLicencia.getAnotaciones());
            pstm.setString(9, beanLicencia.getDireccion());
            pstm.setString(10, beanLicencia.getColonia());
            pstm.setInt(11, beanLicencia.getCodigo_postal());
            pstm.setString(12, beanLicencia.getCorreo());
            pstm.setInt(13, beanLicencia.getTelefono());
            pstm.setString(14, beanLicencia.getHorario_apertura());
            pstm.setString(15, beanLicencia.getHorario_cierre());
            pstm.setString(16, beanLicencia.getFkcontribuyente().getDireccionCont());
            pstm.setString(17, beanLicencia.getFkcontribuyente().getColoniaCont());
            pstm.setString(18, beanLicencia.getFkcontribuyente().getAsociacion());
            pstm.setString(19, beanLicencia.getFkotrosdatos().getFecha_alta_shcp());
            pstm.setString(20, beanLicencia.getFkotrosdatos().getCurp());
            pstm.setString(21, beanLicencia.getFkotrosdatos().getRfc());
            pstm.setInt(22, beanLicencia.getFkotrosdatos().getNo_empleados());
            pstm.setDouble(23, beanLicencia.getFkotrosdatos().getSuperficie());
            pstm.setString(24, beanLicencia.getFkotrosdatos().getObservaciones());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método modificarLicencia() del DaoLicencia -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    /**
     * Metodo encargo de la eliminacion logica de un docente
     *
     * @param idDocente Almacena la clave que identifica al objeto como unico.
     * @return: Un dato logico que confirma si fue correcto o incorrecto el
     * registro.
     */
    public boolean eliminarLicencia(int no_Licencia) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(SUSPENDER_LICENCIA);
            pstm.setInt(1, no_Licencia);
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método eliminarLicencia() del DaoLicencia -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron conexiones en eliminarLicencia() del DaoLicencia --> " + e.getMessage());
            }
        }
        return resultado;
    }
    
    public boolean solicitarInspeccion(int no_Licencia) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(INSPECCION_SOLICITAR);
            pstm.setInt(1, no_Licencia);
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método solicitarInspeccion() del DaoLicencia -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }
    
    public BeanLicencia numLicenciaRegis(){
        BeanLicencia beanLicencia = null;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(NUM_LICREGIS);
            rs = pstm.executeQuery();
            if (rs.next()) {
                beanLicencia = new BeanLicencia();
                beanLicencia.setNo_Licencia(rs.getInt("no_Licencia"));
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método numLicenciaRegis() del DaoLicencia -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones numLicenciaRegis() " + e.getMessage());
            }
        }
        return beanLicencia;
    }
}
