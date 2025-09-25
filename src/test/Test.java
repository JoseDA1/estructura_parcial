/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import javax.swing.JOptionPane;

public class Test {

    int[][] mesa = new int[3][7];
    String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
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
                for(int i = 0; i < 6; i++) {
                    if (cliente.getDia().equals(dias[i])) {
                        mesa[0][i] ++;
                    }
                }
                break;
            case "Mesa 2":
                for(int i = 0; i < 6; i++) {
                    if (cliente.getDia().equals(dias[i])) {
                        mesa[1][i] ++;
                    }
                }
                break;
            case "Mesa 3":
                for(int i = 0; i < 6; i++) {
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
        JOptionPane.showMessageDialog(null,"Total en "+mesa+": "+total);

    }
    public void mostrar() {
        //De prueba nada más
        Nodo aux = inicio;
        while (aux != null) {
            JOptionPane.showMessageDialog(null,"Doc: " + aux.getCliente().getDocumento() +
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
            JOptionPane.showMessageDialog(null, "Mesa mas usada el " + dias[i] + ": " + mesaMax);
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
            JOptionPane.showMessageDialog(null, "Mesa menos usada el " + dias[i] + ": " + mesaMin);
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
        public void diaConMasClientes(){
        int maxClientes = -1;
        String diaMax = "";
        
        for (int i = 0; i < dias.length; i++) {
            int clientesDelDia = 0;
            for (int j = 0; j < mesas.length; j++) {
                clientesDelDia += mesa[j][i];
            }
            
            if (clientesDelDia > maxClientes) {
                maxClientes = clientesDelDia;
                diaMax = dias[i];
            } 
        }
         if (maxClientes > 0) {
                JOptionPane.showMessageDialog(null, "El dia de la semana con mas clientes es el " + diaMax + " con un total de " + maxClientes + " clientes.");
            }else{
                JOptionPane.showMessageDialog(null, "No hay datos de clientes registrados.");
            } 
    }
        
        public void clientesRecurrentes(){
            if (inicio ==null) {
                JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
                return;
            }
            
            Nodo aux1 = inicio;
            String clientesRepetidos = "";
            
            while (aux1 != null){
                // si el aux es diferente de null, se recolecta la informacion del cliente
                String documentoActual = aux1.getCliente().getDocumento();
                int contador = 0;
                Nodo aux2 = inicio;
                
                while(aux2 != null){
                    if (aux2.getCliente().getDocumento().equals(documentoActual)){
                        contador++;
                    }
                    aux2 = aux2.getEnlace();
                }
                if (contador > 1 && !clientesRepetidos.contains(documentoActual)){
                    clientesRepetidos += "El cliente con documento " + documentoActual + " asistio " + contador + " veces.\n";
                }
                
                aux1 = aux1.getEnlace();
            }
            
            if (clientesRepetidos.isEmpty()){
                JOptionPane.showMessageDialog(null, "No se encotraron clientes que hayan asistido mas de una vez");
            }else {
                JOptionPane.showMessageDialog(null, "Clientes recurrentes:\n " + clientesRepetidos);
            }
        }

    }