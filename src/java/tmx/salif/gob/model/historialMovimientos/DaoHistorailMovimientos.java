/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.historialMovimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tmx.salif.gob.model.usuario.Usuario;
import tmx.salim.gob.servicios.Conexion;

/**
 *
 * @author Hp
 */
public class DaoHistorailMovimientos {
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

    public boolean registrarMovimientoHistorial(int ultimo,int idUsuario,String movimiento) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("INSERT INTO historialMovimientos VALUES(?,NOW(),?,?);");
            
            pstm.setInt(1, ultimo);
            pstm.setInt(2, idUsuario);
            pstm.setString(3,movimiento);
            
            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo registrarMovimientoHistorial() del DaoHistorialMovmiento: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }
    public int ultimoMovimientoHistorial() {
        int ultimo = 0;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("SELECT idHistorialMovimientos FROM historialMovimientos ORDER BY idHistorialMovimientos DESC limit 1;");

            rs = pstm.executeQuery();
            if (rs.next()) {
                ultimo = rs.getInt("idHistorialMovimientos");
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
    
    public List<BeanHistorailMovimientos> consultarHistorialMovimientos() {
        List<BeanHistorailMovimientos> listaHistorialMovimientos = new ArrayList();

        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement("SELECT* FROM historialMovimientos INNER JOIN usuario ON usuario_idUsuario=idUsuario;");
 
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanHistorailMovimientos beanCuentasContable = new BeanHistorailMovimientos();

                beanCuentasContable.setIdHistorial(rs.getInt("idHistorialMovimientos"));
                beanCuentasContable.setFechaMovimiento(rs.getString("fechaAccion"));
                beanCuentasContable.setMovimiento(rs.getString("movimientoUsuario"));
                
                Usuario user = new Usuario();
                user.setIdUsuario(rs.getInt("usuario_idUsuario"));
                user.setNombreUsuario(rs.getString("nombreUsuario"));
                
                beanCuentasContable.setUser(user);
                listaHistorialMovimientos.add(beanCuentasContable);
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
        return listaHistorialMovimientos;
    }
    
}
