package tmx.salim.gob.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Oscar Rodríguez
 */
public class Conexion {

    private String ipAddress;
    private String puerto;
    private String usuario;
    private String password;
    private String nombreBase;
    private ResourceBundle propiedades;
    private static Conexion conexion;

    private Conexion() {

    }

    public static Conexion getInstance() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection getConexion() {
        Connection con = null;
        propiedades = null;
        if (propiedades == null) {
            propiedades = ResourceBundle.getBundle("properties");
            ipAddress = propiedades.getString("ipAddress");
            puerto = propiedades.getString("puerto");
            usuario = propiedades.getString("usuario");
            password = propiedades.getString("password");
            nombreBase = propiedades.getString("nombreBase");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + puerto + "/" + nombreBase + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        Conexion sin = Conexion.getInstance();
        Connection con = sin.getConexion();
        System.out.println(con);
        if (con != null) {
            System.out.println("¡Conexión exitosa!");
        } else {
            System.out.println("¡No se estableció conexión!");
        }
    }
}
