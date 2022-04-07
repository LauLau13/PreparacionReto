package RetoV0;

import java.util.Scanner;

public class Usuarios {
    // Atributos:
    private static int idUsuario = 0;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String direccion;
    private boolean esAdmin = false;

    // Constructor de usuarios normales
    // Con dirección

    public Usuarios(String nombre, String apellido, String email, String password, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        idUsuario++;
    }

    // Sin dirección
    public Usuarios(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        idUsuario++;
    }

    // Constructor de admins
    // Con dirección

    public Usuarios(String nombre, String apellido, String email, String password, String direccion, boolean esAdmin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.esAdmin = esAdmin;
        idUsuario++;
    }

    // Sin dirección
    public Usuarios(String nombre, String apellido, String email, String password, boolean esAdmin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.esAdmin = esAdmin;
        idUsuario++;
    }

    /**
     * Metodo que permite cambiar los datos que indique el usuario
     * 
     * @author: Alexander Aguirre
     */
    public void cambiarDatos() {

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué datos deseas cambiar?");
        System.out.println("1. Nombre \n 2. Apellido \n 3. Email \n 4. Contraseña \n 5. Dirección \n 6.Salir");
        int opcion = sc.nextInt();

        while (opcion != 6) {
            switch (opcion) {
                case 1:
                    // Modificación del nombre en la ddbb
                    break;
                case 2:
                    // Modificación del apellido en la ddbb
                    break;
                case 3:
                    // Modificación del Email en la ddbb
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

    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Bienvenido " + this.nombre + ", estos son tus datos: " + "\n" + "Nombre Completo: " + this.nombre + " "
                + this.apellido + "\n" + "Email: " + this.email + "\n" + "Dirección: " + this.direccion;
    }

}
