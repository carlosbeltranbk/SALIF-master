/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tmx.salim.gob.servicios.Conexion;

/**
 *
 * @author Oscar Rodríguez
 */
public class DaoEstado {
    private Conexion singletonConexion = Conexion.getInstance();
    private Connection conexion;
    private ResultSet rs;
    private PreparedStatement pstm;

    final private String SQL_CONSULTAR_ESTADOS = "call mysql_consultar_estados ();";
    
    /**
     * Metodo encargado de realizar la consulta de los estados existentes
     * @return: Retorna una lista de todos los administradores existentes
     */
    public List<BeanEstado> consultarEstados() {
        List<BeanEstado> estados = new ArrayList();
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_ESTADOS);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanEstado bean = new BeanEstado();
                bean.setIdEstado_licencia(rs.getInt("idEstado_licencia"));
                bean.setEstado(rs.getString("estado"));
                bean.setDescripcion(rs.getString("descripcion"));

                estados.add(bean);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarEstados() del DaoEstado -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return estados;
    }
}
