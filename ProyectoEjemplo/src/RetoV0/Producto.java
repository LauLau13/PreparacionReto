/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

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

    @Override
    public String toString() {
        return "Datos producto: \n"+ 
                "Tipo de producto: "+ super.getNombreTipo() + "\n" +
                "ID: "+ idProd + "\n" + 
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
