/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author laura
 */

public class Productos extends TipoProducto {
    
    //Atributos
    private int idProd;
    private String nombreProd;
    private String descriptProd;
    private String medidasProd;
    private int stockProd;

    // Getters
    public int getIdProd() {
        return idProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public String getDescriptProd() {
        return descriptProd;
    }

    public String getMedidasProd() {
        return medidasProd;
    }

    public int getStockProd() {
        return stockProd;
    }

    // Setters
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public void setDescriptProd(String descriptProd) {
        this.descriptProd = descriptProd;
    }

    public void setMedidasProd(String medidasProd) {
        this.medidasProd = medidasProd;
    }

    public void setStockProd(int stockProd) {
        this.stockProd = stockProd;
    }

    // Constructor sin tener en cuenta el stock, por defecto hay 1 producto

    public Productos(String nombreTipo, int idProducto, String nombreProd, String descriptProd, String medidasProd) {
        super(nombreTipo);
        this.idProd = idProducto;
        this.nombreProd = nombreProd;
        this.descriptProd = descriptProd;
        this.medidasProd = medidasProd;
        this.stockProd = 1;
        this.insertarProd();

    }
    
    //Constructor teniendo en cuenta el stock
    public Productos(String nombreTipo,int idProducto, String nombreProd, String descriptProd, String medidasProd, int stock) {
        super(nombreTipo);
        this.idProd = idProducto;
        this.nombreProd = nombreProd;
        this.descriptProd = descriptProd;
        this.medidasProd = medidasProd;
        this.stockProd = stock;
        this.insertarProd();
    }

    /**
     * Método que lista toda la información de un producto
     * 
     * @author: Laura Gil
     */
    @Override
    public String toString() {
        return "Datos producto: \n" +
                "Tipo de producto: " + super.getNombreTipo() + "\n" +
                "ID: " + idProd + "\n" +
                "Nombre: " + nombreProd + "\n" +
                "Descripción: " + descriptProd + "\n" +
                "Medidas: " + medidasProd + "\n" +
                "Stock: " + stockProd + '}';
    }

    /**
     * Método que resta 1 producto del stock
     * 
     * @author: Laura Gil
     */
    public void restaStock() {
        if (this.stockProd >= 1) {
            this.stockProd--;
        } else {
            System.out.println("El producto ya no está disponible");
        }
    }

    /**
     * Metodo que permite que el administrador cambie los datos de un producto
     * 
     * @author: Laura Gil
     */
    public void cambiarDatosProd() {

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué datos del producto deseas cambiar?");
        System.out.println("1. Nombre \n 2. Descripción \n 3. Medidas \n 4. Stock \n 5.Salir");
        int opcion = sc.nextInt();

        while (opcion != 5) {
            switch (opcion) {
                case 1:
                    // Modificación del nombre en la ddbb
                    break;
                case 2:
                    // Modificación de la descripción en la ddbb
                    break;
                case 3:
                    // Modificación de las medidas en la ddbb
                    break;
                case 4:
                    // Modificación del stock medidas en la ddbb
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }

    /**
     * Metodo que permite insertar los datos de un producto en la bbdd
     * 
     * @author: Laura Gil
     */
    public void insertarProd() {
        try {
            // 1.Descargar e instalar el driver
            // 2.Agregar el driver al proyecto
            // Libraries add jar forlder
            Class.forName("oracle.jdbc.OracleDriver");

            // 3.Crear una connexión
            String cadenaConexion = "jdbc:oracle:thin:@localhost:1521/XE";
            Connection conexion = DriverManager.getConnection(cadenaConexion, "RETOJAVA", "RETOJAVA");

            // 4. Generar la query que sentencia INSERT
            String query = "INSERT INTO PRODUCTO (idProd, nombreProd, descriptProd, medidasProd, stockProd, idTipo)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            // 5. Crear el objeto PreparedStatement a partit de la sentencia
            PreparedStatement stmt = conexion.prepareStatement(query);

            // 6.Establecer los parámetros
            stmt.setInt(1, this.idProd);
            stmt.setString(2, this.nombreProd);
            stmt.setString(3, this.descriptProd);
            stmt.setString(4, this.medidasProd);
            stmt.setInt(5, this.stockProd);
            stmt.setInt(6, super.getIdTipo());

            // 6. Ejecutar la sentencia sql que devuelve un resultset
            stmt.executeQuery(query);

            // 7. Cerrar la conexión y liberar todos los reculrsos
            stmt.close();
            conexion.close();
            // Comprobar en administrador de tareas, sevices si OracleServceXE

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
