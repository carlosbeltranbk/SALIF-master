/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.ordenDePago;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tmx.salif.gob.model.contribuyente.BeanContribuyente;
import tmx.salif.gob.model.estado.BeanEstado;
import tmx.salif.gob.model.licencia.BeanLicencia;
import tmx.salif.gob.otrosdatos.BeanDatos;
import tmx.salim.gob.servicios.Conexion;

/**
 *
 * @author BELTRAN PC
 */
public class DaoOrdenDePago {
    
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
    public boolean registrarOrdenDePago(int ultimo,int idLicencia) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("INSERT INTO ordenDePago_licencia VALUES(?,0.0,0.0,?,NOW());");
            System.out.println("INSERT INTO ordenDePago_licencia VALUES("+ultimo+",0.0,0.0,"+idLicencia+",NOW());");
            pstm.setInt(1, ultimo);
            pstm.setInt(2, idLicencia);
            
            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo registrarOrdenDePago() del DaoOrdenDePago: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }
    public boolean registrarOrdenDePagoConceptos(int ultimaOC,int ordenDePago, int cuentaContable) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("INSERT INTO conceptosApagar_OrdenDePago VALUES(?,?,?)");
            pstm.setInt(1, ultimaOC);
            pstm.setInt(2, ordenDePago);
            pstm.setInt(3, cuentaContable);
            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo registrarOrdenDePagoConceptos() del DaoOrdenDePago: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }
      public int ultimaOrdenDePago() {
        int ultimo = 0;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("SELECT idOrdenDePago FROM ordenDePago_licencia ORDER BY idOrdenDePago DESC limit 1;");

            rs = pstm.executeQuery();
            if (rs.next()) {
                ultimo = rs.getInt("idOrdenDePago");
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
        return ultimo;
    }
      public int ultimaOrdenDePagoConcepto() {
        int ultimo = 0;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("SELECT idConceptosApagar FROM conceptosApagar_OrdenDePago ORDER BY idConceptosApagar DESC limit 1;");

            rs = pstm.executeQuery();
            if (rs.next()) {
                ultimo = rs.getInt("idConceptosApagar");
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
        return ultimo;
    }
      
    public boolean eliminarUltimaOrdenDePago(int ultima) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("DELETE FROM  OrdenDePago_licencia WHERE idOrdenDePago= ?;");
            pstm.setInt(1, ultima);
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo eliminarHabitacion() del DaoHabitacion: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron las conexiones en eliminarHabitacion()" + e.getMessage());
            }
        }
        return resultado;
    }
    
}
