/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

public class Test {

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
        System.out.println("Total: "+total);
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
        System.out.println("Total en : "+mesa+": "+total);

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
    public static void main(String[] args) {
        
    }
    
}
