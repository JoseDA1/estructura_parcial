/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.time.LocalTime;

/**
 *
 * @author USUARIO
 */
public class Nodo {
    
    private Cliente cliente;
    private Nodo enlace;

    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.enlace = null;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
    
}