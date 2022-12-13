package com.mycompany.gatosapi;

/**
 *
 * @author hheri
 */
public class StackGato {
    private final Gato stack[];
    private int top = 0;
    public Gato g;

    public StackGato() {
        this.stack = new Gato[5];
    }
    
    
    // Verificar si se puede llenar el stack
    public boolean estaLlena() {
        return top == 5;
    }
    
    // Almacenar un gato en el stack
    
    public void push( Gato g ) {
        if ( !estaLlena() ) {
            stack[top] = g;
            top++;
        } else {
            System.out.println("La pila está llena.");
        }
    }
    
    // Mostrar Gatos del stack
    
    public void mostrarGato() {
        System.out.println("MOSTRANDO GATOS: ");
        
        for(Gato g: stack) {
            System.out.println("Gato ID: " + g.getId() + "\nGato URL: " + g.getUrl());
        }
    }
    
    // Quitar gato del stack
    public void pop() {
        System.out.println("Se eliminará el siguiente Gato: ");
        Gato gatoActual = stack[top - 1];
        System.out.println("Gato ID: " + gatoActual.getId() + "Gato URL: " + gatoActual.getUrl());
        stack[top - 1] = null; 
        System.out.println("Gato eliminado");
    }
    
    // Verificar si el stack está vacio
   
}
