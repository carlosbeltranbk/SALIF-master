/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.tarjeton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tmx.salim.gob.servicios.Conexion;

/**
 *
 * @author Julia Sofía
 */
public class DaoTarjeton {

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

    final private String CONSULTA_TARJETON = "call mysql_visualizar_tarjeton (?,?);";
    final private String CONSULTA_TARJETON_REGIS = "call mysql_visualizar_tarjeton_regis ();";
    final private String REGISTRAR_TARJETON = "call mysql_registrar_tarjeton(?);";
    final private String ELIMINAR_TARJETON = "call mysql_cancelar_tarjeton(?,?);";

    /**
     * Metodo encargado de obtener los datos correspondientes a una licencia.
     *
     * @param no_Licencia Recibe el numero de la licencia que se buscara.
     * @param periodo Periodo del tarjeton
     * @return Retorna un objeto licencia especifico.
     */
    public BeanTarjeton consultarTarjetonId(int no_Licencia, int periodo) {
        BeanTarjeton beanTarjeton = null;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(CONSULTA_TARJETON);
            pstm.setInt(1, no_Licencia);
            pstm.setInt(2, periodo);
            rs = pstm.executeQuery();
            if (rs.next()) {
                beanTarjeton = new BeanTarjeton();
                beanTarjeton.setIdTarjeton(rs.getInt("idTarjeton"));
                beanTarjeton.setFklicencia(rs.getInt("fklicencia"));
                beanTarjeton.setNo_Licencia(rs.getInt("no_Licencia"));
                beanTarjeton.setNombre_establecimiento(rs.getString("nombre_establecimiento"));
                beanTarjeton.setPropietario(rs.getString("propietario"));
                beanTarjeton.setPeriodo(rs.getString("periodo"));
                beanTarjeton.setDireccion(rs.getString("direccion"));
                beanTarjeton.setColonia(rs.getString("colonia"));
                beanTarjeton.setCodigo_postal(rs.getInt("codigo_postal"));
                beanTarjeton.setCorreo(rs.getString("correo"));
                beanTarjeton.setRfc(rs.getString("rfc"));
                beanTarjeton.setTelefono(rs.getInt("telefono"));
                beanTarjeton.setFecha(rs.getString("fecha"));
                beanTarjeton.setGiro(rs.getString("giro"));
                beanTarjeton.setActividad_comercial(rs.getString("actividad_comercial"));
                beanTarjeton.setHorario_apertura(rs.getString("horario_apertura"));
                beanTarjeton.setHorario_cierre(rs.getString("horario_cierre"));
                beanTarjeton.setFecha_recibo(rs.getString("fecha_recibo"));
                beanTarjeton.setRecibo(rs.getString("recibo"));
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarTarjeton() del DaoTarjeton -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarTarjeton() " + e.getMessage());
            }
        }
        return beanTarjeton;
    }
    
    public BeanTarjeton consultarTarjetonIdRegis() {
        BeanTarjeton beanTarjeton = null;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(CONSULTA_TARJETON_REGIS);
            rs = pstm.executeQuery();
            if (rs.next()) {
                beanTarjeton = new BeanTarjeton();
                beanTarjeton.setIdTarjeton(rs.getInt("idTarjeton"));
                beanTarjeton.setFklicencia(rs.getInt("fklicencia"));
                beanTarjeton.setNo_Licencia(rs.getInt("no_Licencia"));
                beanTarjeton.setNombre_establecimiento(rs.getString("nombre_establecimiento"));
                beanTarjeton.setPropietario(rs.getString("propietario"));
                beanTarjeton.setPeriodo(rs.getString("periodo"));
                beanTarjeton.setDireccion(rs.getString("direccion"));
                beanTarjeton.setColonia(rs.getString("colonia"));
                beanTarjeton.setCodigo_postal(rs.getInt("codigo_postal"));
                beanTarjeton.setCorreo(rs.getString("correo"));
                beanTarjeton.setRfc(rs.getString("rfc"));
                beanTarjeton.setTelefono(rs.getInt("telefono"));
                beanTarjeton.setFecha(rs.getString("fecha"));
                beanTarjeton.setGiro(rs.getString("giro"));
                beanTarjeton.setActividad_comercial(rs.getString("actividad_comercial"));
                beanTarjeton.setHorario_apertura(rs.getString("horario_apertura"));
                beanTarjeton.setHorario_cierre(rs.getString("horario_cierre"));
                beanTarjeton.setFecha_recibo(rs.getString("fecha_recibo"));
                beanTarjeton.setRecibo(rs.getString("recibo"));
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarTarjeton() del DaoTarjeton -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarTarjeton() " + e.getMessage());
            }
        }
        return beanTarjeton;
    }

    /**
     * Metodo encargo del registro de nuevas licencias.
     *
     * @param beanTarjeton Recibe un objeto de tipo tarjeton
     * @return: Un dato logico que confirma si fue correcto o incorrecto el
     * registro.
     */
    public boolean registrarTarjeton(int no_Licencia) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(REGISTRAR_TARJETON);
            pstm.setInt(1, no_Licencia);
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método registrarTarjeton() del DaoTarjeton -> " + e.getMessage());
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
     * @param no_Licencia
     * @param periodo
     * @return: Un dato logico que confirma si fue correcto o incorrecto el
     * registro.
     */
    public boolean cancelarTarjeton(int no_Licencia,int periodo) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(ELIMINAR_TARJETON);
            pstm.setInt(1, no_Licencia);
            pstm.setInt(2, periodo);
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método eliminarTarjeton() del DaoTarjeton -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron conexiones en eliminarTarjeton() del DaoTarjeton --> " + e.getMessage());
            }
        }
        return resultado;
    }
}
