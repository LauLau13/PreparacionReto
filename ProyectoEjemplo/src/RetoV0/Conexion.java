/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author laura
 */
public class Conexion {
    
    Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
    public void abrirFlujo() throws ClassNotFoundException, SQLException{
        //Descargar e instalar el driver
        //Agregar el driver al proyecto
            //Libraries add jar forlder
            Class.forName("oracle.jdbc.OracleDriver");
            
        //Crear una connexión
        String cadenaConexion = "jdbc:oracle:thin:@localhost:1521/XE";
        Connection conexion = DriverManager.getConnection(cadenaConexion, "RETOJAVA", "RETOJAVA");
    }
    
    public void cerrarFlujo() throws SQLException{
        conexion.close();
    }
    
}
