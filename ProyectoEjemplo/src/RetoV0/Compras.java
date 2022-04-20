/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author laura
 */
public class Compras {
    
    //Atributos
    private int idCompra;
    private LocalDate fechaCompra;
    ArrayList<Productos> cesta = new ArrayList<Productos>();
    
    //Getters
    public int getIdCompra() {
        return idCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public ArrayList<Productos> getCesta() {
        return cesta;
    }

    
    //Setters
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCesta(ArrayList<Productos> cesta) {
        this.cesta = cesta;
    }

    
            
    //Constructor
    public Compras(int idCompra, Usuarios usuario, LocalDate fechaCompra, ArrayList<Productos> cesta) {
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
        this.cesta = cesta;
        
    }
    
    
    //ToString
    
    
 
    /**
     * Metodo que añade un producto a la cesta de productos de la compra
     * El producto es añadido siempre y cuando esté en stock
     * 
     * @author: Laura Gil
     */
    public void addProdCesta(Productos producto){
    /** 
    * Método con parámetro de entrada el objeto Emperador emperador
    * y Caballero caballero.
    * Añade el Caballero a la lista de Caballeros del Emperador que corresponda,
    * teniendo en cuenta si ya existe el Emperador en el HashMap
    * y la lista de caballeros como valor.
    * @author LAURA GIL FERNÁNDEZ 
    * @param VARIABLE: Emperador emperador, Caballero caballero
    * @return void 
    */
        
        if(producto.getStockProd()>=1){
            cesta.add(producto);
            producto.restaStock();
            System.out.println("Se ha añadido el producto " + producto.getNombreProd() + 
                " con código " + producto.getIdProd() + " a la cesta.");
        }
        else{
            System.out.println("El producto ya no se encuentra disponible.");
        }
    }
    
    
    /**
     * Método que imprime todos los productos de la cesta
     * 
     * @author: Laura Gil
     */
    public String ImprimirProductos(){
        for (Productos prod : cesta) {
            System.out.println(prod.toString());
        }
        return "OK";
    }
    
    
    /**
     * Método que realiza la compra
     * 
     * @author: Laura Gil
     */
    public void ComprarCesta() {
        System.out.println("¿Desea comprar los siguientes productos?");
        this.ImprimirProductos();
        
        String confirmacion;
        System.out.println("S/N");
        Scanner sc = new Scanner(System.in);
        confirmacion = sc.nextLine();
        
        if(confirmacion.equals("S")){
            System.out.println("Compra realizada");
        }
        else{
            System.out.println("La compra no se ha realizado correctamente");
        }
    }
    
    
    
    
}
