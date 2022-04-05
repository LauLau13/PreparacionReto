/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

/**
 *
 * @author laura
 */
public class Producto {
    
    //Atributos
    private static int idProducto;
    private String nombreProd;
    private String descriptProd;
    private String medidasProd;
    private int stockProd;
    
    //Getters
    public static int getIdProducto() {
        return idProducto;
    }

    public static String getNombreProd() {
        return nombreProd;
    }

    public static String getDescriptProd() {
        return descriptProd;
    }

    public static String getMedidasProd() {
        return medidasProd;
    }

    public static int getStockProd() {
        return stockProd;
    }

    
    

    //Setters
    public static void setIdProducto(int idProducto) {
        Producto.idProducto = idProducto;
    }

    public static void setNombreProd(String nombreProd) {
        Producto.nombreProd = nombreProd;
    }

    public static void setDescriptProd(String descriptProd) {
        Producto.descriptProd = descriptProd;
    }

    public static void setMedidasProd(String medidasProd) {
        Producto.medidasProd = medidasProd;
    }

    public static void setStockProd(int stockProd) {
        Producto.stockProd = stockProd;
    }
    
    
    //Constructore sin tener en cuenta el stock, por defecto hay 1 producto
    public Producto(int idProducto, String nombreProd, String descriptProd, String medidasProd) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.descriptProd = descriptProd;
        this.medidasProd = medidasProd;
        this.stockProd = 1;
    }
    
    //Constructore teniendo en cuenta el stock
    public Producto(int idProducto, String nombreProd, String descriptProd, String medidasProd, int stock) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.descriptProd = descriptProd;
        this.medidasProd = medidasProd;
        this.stockProd = stock;
    }

    @Override
    public String toString() {
        return "Datos producto: \n"+ 
                "ID: "+ idProducto + "\n" + 
                "Nombre: " + nombreProd + "\n" + 
                "Descripción: " + descriptProd + "\n" + 
                "Medidas: " + medidasProd + '}';
    }
    
    
    
    //Método resta producto del stock
    public void restaStock (){
       if(this.stockProd>=1){
           this.stockProd--;
       } else{
           System.out.println("El producto está agotado"); 
       }
    }
       
}
