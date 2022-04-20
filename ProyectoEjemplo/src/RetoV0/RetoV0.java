/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RetoV0;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Laura, Alex, Sandra
 */
public class RetoV0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // 1.Descargar e instalar el driver
            // 2.Agregar el driver al proyecto
            // Libraries add jar forlder

            // 3.Crear una connexión
            Conexion conexion = new Conexion();
            conexion.abrirFlujo();
            // 4. Crear una sentencia
            Statement stmt = conexion.conexion.createStatement();

            // 5. Generar la query que es una consulta (borrado, update, insert...)
            /*
             * String query = "INSERT INTO personas (dni, nombre, apellido, edad)"
             * + "VALUES (766666, 'Laura', 'Perez', 22)";
             */
            //String query = "SELECT * FROM USUARIOS WHERE idUsuario = 0";
            String query = "DESCRIBE USUARIOS";
            
            // 6. Ejecutar la sentencia sql que devuelve un resultset
            ResultSet rs = stmt.executeQuery(query);

            // 7. Manejar los resultados: resultset y métodos getX
            int cont = 1;
            while (rs.next()) {
                System.out.println("Objetos de la tabla: ");
                System.out.println("ID Usuario: "+rs.getInt("idUsuario"));
                System.out.println("Nombre: "+rs.getString("nombreUsuario"));
                System.out.println("Apellido: "+rs.getString("apellidoUsuario"));
                cont++;
            }
            // 8. Cerrar la conexión y liberar todos los reculrsos
            stmt.close();
            conexion.cerrarFlujo();
            // Comprobar en administrador de tareas, sevices si OracleServceXE

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
