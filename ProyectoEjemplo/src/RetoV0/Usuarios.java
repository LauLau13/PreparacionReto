package RetoV0;

import java.sql.Connection;
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
            
            Conexion C1 = new Conexion();
            C1.abrirFlujo();
            /*Class.forName("oracle.jdbc.OracleDriver");

            String cadenaConexion = "jdbc:oracle:thin:@localhost:1521/XE";

            Connection conexion = DriverManager.getConnection(cadenaConexion, "RETOJAVA", "RETOJAVA");
            */
            
            //Downcasting
            Connection conexion = C1.getConexion();
            
            String query = "INSERT INTO USUARIOS VALUES(? ,? ,? ,? ,? ,? ,? )";

            PreparedStatement createUser = conexion.prepareStatement(query);

            createUser.setInt(1, this.idUsuario);
            createUser.setString(2, this.nombreUsuario);
            createUser.setString(3, this.apellidoUsuario);
            createUser.setString(4, this.emailUsuario);
            createUser.setString(5, this.password);
            createUser.setString(6, this.direccion);
            createUser.setBoolean(7, this.esAdmin);

            ResultSet rs = createUser.executeQuery();
            createUser.close();
            C1.cerrarFlujo();
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

            Conexion C1 = new Conexion();
            C1.abrirFlujo();
            /*Class.forName("oracle.jdbc.OracleDriver");

            String cadenaConexion = "jdbc:oracle:thin:@localhost:1521/XE";

            Connection conexion = DriverManager.getConnection(cadenaConexion, "RETOJAVA", "RETOJAVA");
            */
            
            //Downcasting
            Connection conexion = C1.getConexion();

            

            Statement commit = conexion.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("¿Qué datos deseas cambiar?");
            System.out.println("1. Nombre \n 2. Apellido \n 3. emailUsuario \n 4. Contraseña \n 5. Dirección \n 6.Salir");
            int opcion = sc.nextInt();
            String query = "";
            PreparedStatement modifyField = conexion.prepareStatement(query);
            
            while (opcion != 6) {
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el nuevo nombre: ");
                        String newName = sc.nextLine();
                        this.nombreUsuario = newName;
                        // Modificación del nombre en la ddbb
                        query = "UPDATE USUARIOS SET nombreUsuario = '?' where idUsuario = ?";
                        modifyField = conexion.prepareStatement(query);
                        modifyField.setString(1, newName);
                        modifyField.setInt(2, this.idUsuario);
                        modifyField.executeQuery();
                        commit.executeQuery("Commit");
                        break;
                    case 2:
                        System.out.println("Introduzca el nuevo Apellido: ");
                        String newApellido = sc.nextLine();
                        this.apellidoUsuario = newApellido;
                        // Modificación del apellido en la ddbb
                        query = "UPDATE USUARIOS SET apellidoUsuario = '?' where idUsuario = ?";
                        modifyField = conexion.prepareStatement(query);
                        modifyField.setString(1, newApellido);
                        modifyField.setInt(2, this.idUsuario);
                        modifyField.executeQuery();
                        commit.executeQuery("Commit");
                        break;
                    case 3:
                        System.out.println("Introduzca el nuevo Email: ");
                        String newEmail = sc.nextLine();
                        this.apellidoUsuario = newEmail;
                        // Modificación del apellido en la ddbb
                        query = "UPDATE USUARIOS SET emailUsuario = '?' where idUsuario = ?";
                        modifyField = conexion.prepareStatement(query);
                        modifyField.setString(1, newEmail);
                        modifyField.setInt(2, this.idUsuario);
                        modifyField.executeQuery();
                        commit.executeQuery("Commit");
                        break;
                    case 4:
                        System.out.println("Introduce tu contraseña actual: ");
                        String passIntroducida = sc.nextLine();
                        if (passIntroducida.equals(this.password)) {
                            System.out.println("Introduce la nueva contraseña: ");
                            this.password = sc.nextLine();
                            // Modificar la contraseña
                            query = "UPDATE USUARIOS SET password = '?' where idUsuario = ?";
                            modifyField = conexion.prepareStatement(query);
                            modifyField.setString(1, this.password);
                            modifyField.setInt(2, this.idUsuario);
                            modifyField.executeQuery();
                            commit.executeQuery("Commit");
                        } else {
                            System.out.println("Has introducido la contraseña equivocada");
                        }
                        break;
                    case 5:
                        // Cambiar dirección
                        System.out.println("Introduzca la nueva direccion: ");
                        this.direccion = sc.nextLine();
                        // Modificación del apellido en la ddbb
                        query = "UPDATE USUARIOS SET direccion = '?' where idUsuario = ?";
                        modifyField = conexion.prepareStatement(query);
                        modifyField.setString(1, this.direccion);
                        modifyField.setInt(2, this.idUsuario);
                        modifyField.executeQuery();
                        commit.executeQuery("Commit");
                        break;
                    default:
                        System.out.println("La opción introducida no existe");
                        break;
                }
            }
            sc.close();
            modifyField.close();
            C1.cerrarFlujo();
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
