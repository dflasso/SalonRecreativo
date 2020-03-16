/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.src;

/**
 *
 * @author Familia Lasso Ayala
 */
public class CategoriaPremio {
    private String nombre;
    private int numTickets;

    public CategoriaPremio() {
    }

    public CategoriaPremio(String nombre, int numTickets) {
        this.nombre = nombre;
        this.numTickets = numTickets;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumTickets() {
        return numTickets;
    }
    
    
    
}
