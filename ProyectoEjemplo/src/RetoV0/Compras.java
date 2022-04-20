/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author laura
 */
public class Compras {
    
    //Atributos
    private int idCompra;
    private LocalDate fechaCompra;
    protected HashMap<String,Productos> cesta;
    
    //Getters
    public int getIdCompra() {
        return idCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public HashMap<String, Productos> getCesta() {
        return cesta;
    }
    
    //Setters
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCesta(HashMap<String, Productos> cesta) {
        this.cesta = cesta;
    }
    
            
    //Constructor
    public Compras(int idCompra, Usuarios usuario, LocalDate fechaCompra, HashMap<String, Productos> cesta) {
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
        this.cesta = cesta;
        
    }
    
    /**
     * Metodo que permite insertar los datos de un tipo de producto en la bbdd
     * 
     * @author: Laura Gil
     */
    public void CompraProducto() {
        
        
    }
    
    
    
    
}
