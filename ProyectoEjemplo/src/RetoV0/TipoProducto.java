/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoV0;

/**
 *
 * @author laura
 */
public class TipoProducto extends Producto{
    
    //Atributos:
    private static int idTipo;
    private String nombreTipo;

    public TipoProducto(String nombreTipo, int idProducto, String nombreProd, String descriptProd, String medidasProd) {
        super(idProducto, nombreProd, descriptProd, medidasProd);
        this.nombreTipo = nombreTipo;
    }

    //Constructor todos los parámetros
    public TipoProducto(String nombreTipo, int idProducto, String nombreProd, String descriptProd, String medidasProd, int stock) {
        super(idProducto, nombreProd, descriptProd, medidasProd, stock);
        this.nombreTipo = nombreTipo;
    }

    //Constructor nombreTipo
    public TipoProducto(String nombreTipo) {
        this.idTipo = 1;
        this.nombreTipo = nombreTipo;
    }
    
    
    
}
