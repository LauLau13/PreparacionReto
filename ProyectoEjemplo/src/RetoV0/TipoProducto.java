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
public class TipoProducto{
    
    //Atributos:
    private static int idTipo = 0;
    private String nombreTipo;

    //Constructor nombreTipo
    public TipoProducto(String nombreTipo) {
        TipoProducto.idTipo++;
        this.nombreTipo = nombreTipo;
    }
    
    //Getters
    public static int getIdTipo() {
        return idTipo;
    }
    
    public String getNombreTipo() {
        return nombreTipo;
    }
    
    
    //Setters

    public static void setIdTipo(int idTipo) {
        TipoProducto.idTipo = idTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    
    
}
