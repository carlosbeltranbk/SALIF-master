/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.cuentasContables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tmx.salim.gob.servicios.Conexion;

/**
 *
 * @author BELTRAN PC
 */
public class DaoCuentasContables {

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

    final private String CONSULTA_CUENTACONTABLE_CONCEPTO = "SELECT*FROM CuentasContables WHERE concepto LIKE '%?%';";
    final private String CONSULTA_CUENTACONTABLE_CUENTA = "SELECT*FROM CuentasContables WHERE cuenta LIKE %'?'%;";

    /**
     * Metodo encargado de obtener los datos correspondientes a una licencia.
     *
     * @param no_Licencia Recibe el numero de la licencia que se buscara.
     * @return Retorna un objeto licencia especifico.
     */
    public List<BeanCuentasContables> consultarCuentaContableConcepto(String concepto) {
        List<BeanCuentasContables> listaCuentasContables = new ArrayList();

        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(CONSULTA_CUENTACONTABLE_CONCEPTO);
            pstm.setString(1, concepto);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanCuentasContables beanCuentasContable = new BeanCuentasContables();

                beanCuentasContable.setIdCuenta(rs.getInt("idCuentasContables"));
                beanCuentasContable.setCuenta(rs.getString("cuenta"));
                beanCuentasContable.setConcepto(rs.getString("concepto"));
                listaCuentasContables.add(beanCuentasContable);
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
        return listaCuentasContables;
    }

    public List<BeanCuentasContables> consultarCuentasContables() {
        List<BeanCuentasContables> listaCuentasContables = new ArrayList();

        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("SELECT*FROM CuentasContables");

            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanCuentasContables beanCuentasContable = new BeanCuentasContables();

                beanCuentasContable.setIdCuenta(rs.getInt("idCuentasContables"));
                beanCuentasContable.setCuenta(rs.getString("cuenta"));
                beanCuentasContable.setConcepto(rs.getString("concepto"));
                beanCuentasContable.setConcepto(rs.getString("concepto"));
                beanCuentasContable.setUMAS(rs.getInt("UMAS"));
                listaCuentasContables.add(beanCuentasContable);
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
        return listaCuentasContables;
    }

    public List<BeanCuentasContables> consultarCuentaContableCuenta(String cuenta) {
        List<BeanCuentasContables> listaCuentasContables = new ArrayList();

        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(CONSULTA_CUENTACONTABLE_CONCEPTO);
            pstm.setString(1, cuenta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanCuentasContables beanCuentasContable = new BeanCuentasContables();

                beanCuentasContable.setIdCuenta(rs.getInt("idLicencia"));
                beanCuentasContable.setCuenta(rs.getString("cuenta"));
                beanCuentasContable.setConcepto(rs.getString("concepto"));
                listaCuentasContables.add(beanCuentasContable);
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
        return listaCuentasContables;
    }
    public BeanCuentasContables consultarCuentaContableId(int idCuenta) {
        BeanCuentasContables beanCuentasContable = null;
        try {
            conexion = singletonConexion.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement("SELECT*FROM cuentasContables WHERE idCuentasContables = ?");
            pstm.setInt(1, idCuenta);
            rs = pstm.executeQuery();
            if (rs.next()) {

                beanCuentasContable = new BeanCuentasContables();
                

                   beanCuentasContable.setIdCuenta(rs.getInt("idCuentasContables"));
                beanCuentasContable.setCuenta(rs.getString("cuenta"));
                beanCuentasContable.setConcepto(rs.getString("concepto"));
                beanCuentasContable.setConcepto(rs.getString("concepto"));
                beanCuentasContable.setUMAS(rs.getInt("UMAS"));
                

                

            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo consultarHabitacionesId() del DaoHabitacion: " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return beanCuentasContable;
    }
}
