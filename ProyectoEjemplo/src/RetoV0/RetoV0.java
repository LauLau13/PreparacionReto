/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RetoV0;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author laura
 */
public class RetoV0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
         * try{
         * //1.Descargar e instalar el driver
         * //2.Agregar el driver al proyecto
         * //Libraries add jar forlder
         * Class.forName("oracle.jdbc.OracleDriver");
         * 
         * //3.Crear una connexión
         * String cadenaConexion = "jdbc:oracle:thin:@localhost:1521/XE";
         * Connection conexion = DriverManager.getConnection(cadenaConexion, "ejemplo",
         * "ejemplo");
         * 
         * //4. Crear una sentencia
         * Statement stmt = conexion.createStatement();
         * 
         * //5. Generar la query que es una consulta (borrado, update, insert...)
         * String query = "INSERT INTO personas (dni, nombre, apellido, edad)"
         * + "VALUES (766666, 'Laura', 'Perez', 22)";
         * 
         * //6. Ejecutar la sentencia sql que devuelve un resultset
         * ResultSet rs = stmt.executeQuery(query);
         * 
         * //7. Manejar los resultados: resultset y métodos getX
         * 
         * //8. Cerrar la conexión y liberar todos los reculrsos
         * stmt.close();
         * conexion.close();
         * //Comprobar en administrador de tareas, sevices si OracleServceXE
         * 
         * }catch(Exception e){
         * System.out.println(e.getMessage());
         * }
         */

        // Prueba de Detalle de usuario
        Usuarios u1 = new Usuarios("Alexander", "Aguirre", "keevinaguirre@gmail.com", "1234");
        u1.setDireccion("Av. Cesareo Alierta 78");
        System.out.println(u1.toString());
    }

}
