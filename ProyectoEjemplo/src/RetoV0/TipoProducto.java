/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author laura
 */
public class TipoProducto{
    
    //Atributos:
    private int idTipo = 0;
    private String nombreTipo;

    //Constructor nombreTipo
    public TipoProducto(String nombreTipo) {
        this.idTipo++;
        this.nombreTipo = nombreTipo;
        this.insertarTipo();
    }
    
    //Getters
    public int getIdTipo() {
        return idTipo;
    }
    
    
    public String getNombreTipo() {
        return nombreTipo;
    }
    
    
    //Setters

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }


    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    
    
    /**
     * Metodo que permite insertar los datos de un tipo de producto en la bbdd
     * 
     * @author: Laura Gil
     */
    public void insertarTipo() {
        try{
            //1.Descargar e instalar el driver
            //2.Agregar el driver al proyecto
                //Libraries add jar forlder
                Class.forName("oracle.jdbc.OracleDriver");
            
            //3.Crear una connexión
                String cadenaConexion = "jdbc:oracle:thin:@localhost:1521/XE";
                Connection conexion = DriverManager.getConnection(cadenaConexion, "RETOJAVA", "RETOJAVA");
            
            //4. Generar la query que sentencia INSERT
                String query = "INSERT INTO PRODUCTO (idTipo, nombreTipo)"
                        + "VALUES (?, ?)";
                
            //5. Crear el objeto PreparedStatement a partit de la sentencia
                PreparedStatement stmt = conexion.prepareStatement(query);
                

            //6.Establecer los parámetros
                    stmt.setInt(1, this.idTipo );
                    stmt.setString(2, this.nombreTipo);
                
            //6. Ejecutar la sentencia sql que devuelve un resultset
                ResultSet rs = stmt.executeQuery(query);
            
            //7. Cerrar la conexión y liberar todos los reculrsos
                stmt.close();
                conexion.close();
                //Comprobar en administrador de tareas, sevices si OracleServceXE
                
        }
        catch(ClassNotFoundException cn){ cn.printStackTrace();}
        catch(SQLException e) {e.printStackTrace();}
    }
    
}
