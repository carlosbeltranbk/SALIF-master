/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.proteccionCivil;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tmx.salim.gob.servicios.Conexion;
/**
 *
 * @author Rebecca Lanuss
 */
public class DaoProteccionCivil {
    
    private Conexion conexion = Conexion.getInstance();
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;
    
    public List<BeanProteccionCivil> consultarInspeccionesNorealizadas() {
        List<BeanProteccionCivil> lista = new ArrayList<>();

        try {
            con = conexion.getConexion();
            String Query = "SELECT * FROM proteccion_civil WHERE estado = 0;";
            pstm = con.prepareStatement(Query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                BeanProteccionCivil bean = new BeanProteccionCivil();
                bean.setIdPc(rs.getInt("idPc"));
                bean.setNumeroLicencia(rs.getInt("no_licencia"));
                bean.setPersonaEncargada(rs.getString("persona_encargada"));
                bean.setDireccion(rs.getString("direccion"));
                bean.setEstado(rs.getBoolean("estado"));
                
             
                lista.add(bean);
            }
            
            rs.close();
            pstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método consultarInspeccionesNorealizadas() del DaoProteccionCivil " + e.getMessage());

        } finally {
            try {
                rs.close();
                pstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en consultarInspeccionesNorealizadas() del DaoProteccionCivil " + e.getMessage());
            }
        }
        return lista;
    }
    
        public List<BeanProteccionCivil> consultarInspeccionesRealizadas() {
        List<BeanProteccionCivil> lista = new ArrayList<>();

        try {
            con = conexion.getConexion();
            String Query = "SELECT * FROM proteccion_civil WHERE estado = 1;";
            pstm = con.prepareStatement(Query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                BeanProteccionCivil bean = new BeanProteccionCivil();
                bean.setIdPc(rs.getInt("idPc"));
                bean.setNumeroLicencia(rs.getInt("no_licencia"));
                bean.setPersonaEncargada(rs.getString("persona_encargada"));
                bean.setDireccion(rs.getString("direccion"));
                bean.setEstado(rs.getBoolean("estado"));
             
                lista.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método consultarInspeccionesRealizadas() del DaoProteccionCivil " + e.getMessage());

        } finally {
            try {
                rs.close();
                pstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en consultarInspeccionesRealizadas() del DaoProteccionCivil " + e.getMessage());
            }
        }
        return lista;
    }
        
        public boolean cambiarInspeccion(int id) {
        boolean resultado = false;

        try {
            con = conexion.getConexion();
            String Query = "UPDATE proteccion_civil SET estado = 1 WHERE idPc = ?";
            pstm = con.prepareStatement(Query);
            pstm.setInt(1, id);
            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método cambiarInspeccion() del DaoProteccionCivil " + e.getMessage());
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en cambiarInspeccion() del DaoProteccionCivil " + e.getMessage());
            }
        }

        return resultado;
    }
}
