/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

import java.util.Scanner;

/**
 *
 * @author laura
 */
public class Producto extends TipoProducto {
    
    //Atributos
    private static int idProd;
    private String nombreProd;
    private String descriptProd;
    private String medidasProd;
    private int stockProd;
    
    //Getters
    public static int getIdProducto() {
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
    
    
    //Setters
    public static void setIdProducto(int idProducto) {
        Producto.idProd = idProducto;
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

    
    //Constructor sin tener en cuenta el stock, por defecto hay 1 producto

    public Producto(String nombreTipo, int idProducto, String nombreProd, String descriptProd, String medidasProd) {
        super(nombreTipo);
        Producto.idProd = idProducto;
        this.nombreProd = nombreProd;
        this.descriptProd = descriptProd;
        this.medidasProd = medidasProd;
        this.stockProd = 1;
        
    }
    
    //Constructor teniendo en cuenta el stock
    public Producto(String nombreTipo,int idProducto, String nombreProd, String descriptProd, String medidasProd, int stock) {
        super(nombreTipo);
        Producto.idProd = idProducto;
        this.nombreProd = nombreProd;
        this.descriptProd = descriptProd;
        this.medidasProd = medidasProd;
        this.stockProd = stock;
    }

    
    /**
     * Método que lista toda la información de un producto
     * 
     * @author: Laura Gil
     */ 
    @Override
    public String toString() {
        return "Datos producto: \n"+ 
                "Tipo de producto: "+ super.getNombreTipo() + "\n" +
                "ID: "+ idProd + "\n" + 
                "Nombre: " + nombreProd + "\n" + 
                "Descripción: " + descriptProd + "\n" +
                "Medidas: " + medidasProd + "\n" +
                "Stock: " + stockProd + '}';
    }
    
    
    
    /**
     * Método resta producto del stock
     * 
     * @author: Laura Gil
     */    
    public void restaStock (){
       if(this.stockProd>=1){
           this.stockProd--;
       } else{
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
    }
       
}
