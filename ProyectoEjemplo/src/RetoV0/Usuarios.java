package RetoV0;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Usuarios {
    // Atributos:
    private int idUsuario = 0;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String password;
    private String direccion;
    private boolean esAdmin = false;

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    // Constructor de usuarios normales
    // Con dirección

    public Usuarios(String nombreUsuario, String apellidoUsuario, String emailUsuario, String password,
            String direccion) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.password = password;
        this.direccion = direccion;
        this.consultaNewUser();
        idUsuario++;
    }

    // Sin dirección
    public Usuarios(String nombreUsuario, String apellidoUsuario, String emailUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.password = password;
        this.consultaNewUser();
        idUsuario++;
    }

    // Constructor de admins
    // Con dirección

    public Usuarios(String nombreUsuario, String apellidoUsuario, String emailUsuario, String password,
            String direccion, boolean esAdmin) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.password = password;
        this.direccion = direccion;
        this.esAdmin = esAdmin;
        this.consultaNewUser();
        idUsuario++;
    }

    // Sin dirección
    public Usuarios(String nombreUsuario, String apellidoUsuario, String emailUsuario, String password,
            boolean esAdmin) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.password = password;
        this.esAdmin = esAdmin;
        this.consultaNewUser();
        idUsuario++;
    }

    /**
     * Consulta predeterminada para añadir cada Objeto de tipo Usuario creado a la
     * tabla realacional de la base de datos
     */
    public void consultaNewUser() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");

            String cadenaConexion = "jdbc:oracle:thin:@localhost:1521/XE";

            Connection conexion = DriverManager.getConnection(cadenaConexion, "RETOJAVA", "RETOJAVA");

            String query = "INSERT INTO USUARIOS VALUES(? ,? ,? ,? ,? ,? ,? )";

            PreparedStatement createUser = conexion.prepareStatement(query);

            createUser.setInt(1, this.idUsuario);
            createUser.setString(2, this.nombreUsuario);
            createUser.setString(3, this.apellidoUsuario);
            createUser.setString(4, this.emailUsuario);
            createUser.setString(5, this.password);
            createUser.setString(6, this.direccion);
            createUser.setBoolean(7, this.esAdmin);
            
            createUser.executeQuery();
            createUser.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que permite cambiar los datos que indique el usuario
     * 
     * @author: Alexander Aguirre
     */
    public void cambiarDatos() {

        try {

            Class.forName("oracle.jdbc.OracleDriver");

            String cadenaConexion = "jdbc:oracle:thin:@localhost:1521/XE";

            Connection conexion = DriverManager.getConnection(cadenaConexion, "RETOJAVA", "RETOJAVA");

            String query = "";
            PreparedStatement modifyField = conexion.prepareStatement(query);
            

            Statement commit = conexion.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("¿Qué datos deseas cambiar?");
            System.out
                    .println("1. Nombre \n 2. Apellido \n 3. emailUsuario \n 4. Contraseña \n 5. Dirección \n 6.Salir");
            int opcion = sc.nextInt();

            while (opcion != 6) {
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el nuevo nombre: ");
                        String newName = sc.nextLine();
                        // Modificación del nombre en la ddbb
                        query = "UPDATE USUARIOS SET nombreUsuario = ? where idUsuario = ?";
                        modifyField = conexion.prepareStatement(query);
                        modifyField.setString(1, newName);
                        modifyField.setInt(2, this.idUsuario);
                        modifyField.executeQuery();
                        commit.executeQuery("Commit");
                        break;
                    case 2:
                        // Modificación del apellido en la ddbb
                        break;
                    case 3:
                        // Modificación del emailUsuario en la ddbb
                        break;
                    case 4:
                        System.out.println("Introduce tu contraseña actual: ");
                        String passIntroducida = sc.nextLine();
                        if (passIntroducida.equals(this.password)) {
                            // Modificar la contraseña
                        } else {
                            System.out.println("Has introducido la contraseña equivocada");
                        }
                        break;
                    case 5:
                        // Cambiar dirección
                        break;
                    default:

                        break;
                }
            }

            modifyField.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Bienvenido " + this.nombreUsuario
                + ", estos son tus datos: "
                + "\n"
                + "Nombre Completo: " + this.nombreUsuario + " " + this.apellidoUsuario
                + "\n"
                + "emailUsuario: " + this.emailUsuario
                + "\n"
                + "Dirección: " + this.direccion;
    }

}
