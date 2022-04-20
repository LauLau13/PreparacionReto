/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RetoV0;

import com.sun.xml.internal.stream.Entity;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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


            //Borrar registros DE TODAS LAS TABLAS
            String queryTest = "SELECT COUNT(*) FROM USUARIOS";
            
            System.out.println("Usuarios");
            String queryB1 = "DELETE USUARIOS"; 
            String commit = "COMMIT";
            System.out.println("Creada sentencia");
            int affectedRows;
            affectedRows = stmt.executeUpdate(queryB1);
            stmt.executeUpdate(commit);

            System.out.println("Productos");
            String queryB2 = "DELETE PRODUCTOS"; 
            affectedRows = stmt.executeUpdate(queryB2);
            stmt.executeUpdate(commit);

            System.out.println("Tipo");
            String queryB3 = "DELETE TIPO"; 
            affectedRows = stmt.executeUpdate(queryB3);
            stmt.executeUpdate(commit);

            System.out.println("Compras");
            String queryB4 = "DELETE COMPRAS"; 
            affectedRows = stmt.executeUpdate(queryB4);
            stmt.executeUpdate(commit);
                
            System.out.println("Funciona Correcto");


            // String query = "SELECT * FROM USUARIOS WHERE idUsuario = 0";

            // 5. Generar la query que es una consulta (borrado, update, insert...)
            /*
             * String query = "INSERT INTO personas (dni, nombre, apellido, edad)"
             * + "VALUES (766666, 'Laura', 'Perez', 22)";
             */

           
            System.out.println("---------------------------------------------");
            System.out.println("----------- MENU --------------");
            
            //AQUI EL MENU
             //Login
                //Pedir Usuario y Contraseña
                    //Modificar datos usuario
                    //Listado y Vista detalle
                    //Busqueda de producto
                    //Comprar producto
            //Registrarse
                //Eres Admin??
                    //Inserta el código
                        //Nuevo user admin
                //No eres Admin
                    //Crear nuevo usuario
                        //Registro Completo
                        //Registro Simple (sin direccion)
             
            System.out.println("1. Login");
            System.out.println("2. Registrate");
            Scanner sc = new Scanner (System.in);
            //Leer la opcion
            int op=sc.nextInt();
            //Lista usuarios existentes
            ArrayList <Usuarios> listaExistentes = new ArrayList <>();
            //Elegir opcion 1 o 2
            switch(op){
                case 1:
                    //Login
                    System.out.println("Login");
                    //El Usuario lo buscamos por el email
                    System.out.println("Pon tu email");
                    String usuario = sc.nextLine();
                    for (Usuarios usuarioExistente : listaExistentes) {
                        if (usuario.equals(usuarioExistente.getEmailUsuario())) {
                            System.out.println("Pon tu password");
                            String pass = sc.nextLine();
                            if (pass.equals(usuarioExistente.getPassword())) {
                                System.out.println("Correcto, ya puedes acceder");
                            }
                        }
                    }
                    
                case 2:
                    //Registrate
                    System.out.println("Vamos a crera un nuevo usuario");
                    
            }
                    
            
            
            System.out.println("---------------------------------------------");
            System.out.println("----Insertamos un usuario----");
            Usuarios us = new Usuarios("Prueba", "Usuario1", "a@a.com", "1234");
            

            String query = "SELECT * FROM USUARIOS WHERE idUsuario = 0";

            // 6. Ejecutar la sentencia sql que devuelve un resultset
            ResultSet rs = stmt.executeQuery(query);

            // 7. Manejar los resultados: resultset y métodos getX

            while (rs.next()) {
                System.out.println("Objetos de la tabla: ");
                System.out.println("ID Usuario: " + rs.getInt("idUsuario"));
                System.out.println("Nombre: " + rs.getString("nombreUsuario"));
                System.out.println("Apellido: " + rs.getString("apellidoUsuario"));
                System.out.println("Email: " + rs.getString("emailUsuario"));
                System.out.println("Direccion: " + rs.getString("direccion"));
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
