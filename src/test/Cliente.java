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
public class Cliente {
    
    private int documento;
    private String mesa;
    private String dia;
    private LocalTime fecha;
    
    public Cliente(int documento, String mesa, String dia) {
        this.documento = documento;
        this.mesa = mesa;
        this.dia = dia;
        this.fecha = LocalTime.now();

    }

    /**
     * @return the documento
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * @return the mesa
     */
    public String getMesa() {
        return mesa;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @return the fecha
     */
    public LocalTime getFecha() {
        return fecha;
    }
}
