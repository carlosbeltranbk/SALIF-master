/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.actividadComercial;

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
public class DaoActividad {

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

    final private String CONSULTA_ACTIVIDADES = "call mysql_consultar_actividades();";

    /**
     * Metodo encargado de obtener los datos correspondientes a una licencia.
     *
     * @return Retorna un objeto licencia especifico.
     */
    public List<BeanActividad> consultarActividades() {
        List<BeanActividad> actividad = new ArrayList();
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(CONSULTA_ACTIVIDADES);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanActividad bean = new BeanActividad();
                bean.setIdActividad(rs.getInt("idActividad"));
                bean.setActividad(rs.getString("actividad"));
                bean.setActividad_principal(rs.getString("actividad_principal"));
                bean.setActividad_secundaria(rs.getString("actividad_secundaria"));
                bean.setRiesgo(rs.getString("riesgo"));
                bean.setGiro(rs.getString("giro"));

                actividad.add(bean);
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
        return actividad;
    }
}