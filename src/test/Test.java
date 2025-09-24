/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import javax.swing.JOptionPane;

public class Test {

    int[][] mesa = new int[3][7];
    String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    String[] mesas = {"Mesa 1", "Mesa 2", "Mesa 3"};
    public Nodo inicio;
    public Test(){this.inicio=null;}
    public void insertar(Cliente cliente) {
        //lista simple
        Nodo nuevo = new Nodo(cliente);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getEnlace() != null) {
                //toma el valor del nodo al que referencia
                aux = aux.getEnlace();
            }
            //referencia al nodo nuevo
            aux.setEnlace(nuevo);
        }
        switch(cliente.getMesa()) {
            case "Mesa 1":
                for(int i = 0; i < 7; i++) {
                    if (cliente.getDia().equals(dias[i])) {
                        mesa[0][i] ++;
                    }
                }
                break;
            case "Mesa 2":
                for(int i = 0; i < 7; i++) {
                    if (cliente.getDia().equals(dias[i])) {
                        mesa[1][i] ++;
                    }
                }
                break;
            case "Mesa 3":
                for(int i = 0; i < 7; i++) {
                    if (cliente.getDia().equals(dias[i])) {
                        mesa[2][i] ++;
                    }
                }
                break;
            default:
                
        }
    }
    //Total clientes en la semana
    public void contarClientes() {
        int total = 0;
        Nodo aux = inicio;
        while (aux != null) {
            //suma 1 a 1 los clientes
            total++;
            aux = aux.getEnlace();
        }
        JOptionPane.showMessageDialog(null,"Total: "+total);
    }
    //Clientes por mesa
    public void clientesMesa(String mesa){
        int total=0;
        Nodo aux = inicio;
        while(aux!=null){
            //Busca el parecido a el valor de las mesas
            if(aux.getCliente().getMesa().equals(mesa)){
                total++;
            }
            aux = aux.getEnlace();
        }
        JOptionPane.showMessageDialog(null,"Total en : "+mesa+": "+total);

    }
    public void mostrar() {
        //De prueba nada más
        Nodo aux = inicio;
        while (aux != null) {
            System.out.println("Doc: " + aux.getCliente().getDocumento() +
                               " | Mesa: " + aux.getCliente().getMesa()+
                               " | Día: " + aux.getCliente().getDia());
            aux=aux.getEnlace();
        }
    }
    
    public void mesaMaxDia() {
        //for 1 para ir pasando los dias
        for(int i = 0; i < 7; i++) {
            //variable que indica cual es la mesa mas usada en cada dia
            int max = mesa[0][i];
            String mesaMax = mesas[0];
            //for 2 para ir pasando las mesas
            for (int j = 0; j < 3; j++){
                if (max < mesa[j][i]) {
                max = mesa[j][i];
                mesaMax = mesas[j];
                }
            }
            JOptionPane.showMessageDialog(null, "mesa mas usada el " + dias[i] + ": " + mesaMax);
        }
    }
    //lo mismo que en la funcion anterior, pero en vez de buscar la mesa mas usada en cada dia es la menos usada.
    public void mesaMinDia() {
        for(int i = 0; i < 7; i++) {
            int min = mesa[0][i];
            String mesaMin = mesas[0];
            for (int j = 0; j < 3; j++){
                if (min > mesa[j][i]) {
                min = mesa[j][i];
                mesaMin = mesas[j];
                }
            }
            JOptionPane.showMessageDialog(null, "mesa menos usada el " + dias[i] + ": " + mesaMin);
        }
    }
    
    public void clientesDia() {
        for(int i = 0; i < 7; i++) {
            //variable para indicar el total de clientes por dia
            int total = 0;
            //for 2 para ir pasando las mesas
            for (int j = 0; j < 3; j++){
                total += mesa[j][i];
                }
            JOptionPane.showMessageDialog(null, "Total de clientes del dia " + dias[i] + ": " + total);
            }

    }
}
