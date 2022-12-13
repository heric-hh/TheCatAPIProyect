package com.mycompany.gatosapi;

import java.io.IOException;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author hheri
 */
public class GatosAPI {
    /*
    public static Stack<Gato> stackGatos = new Stack<>();
    
    public static void mostrarGato() {
        System.out.println("--- Último Gato añadido: ---");
        Gato g = stackGatos.peek();
        System.out.println("ID: " + g.getId() + "\nURL: " + g.getUrl());
    }
    
    public static void isEmpty() {
        if ( !stackGatos.empty() )
            System.out.println("El stack no está vacío.");
        else
            System.out.println("El stack está vacío.");
    } */

    public static void main(String[] args) throws IOException {
        StackGato stackGatos = new StackGato();
        
        int opcionMenu = -1;
        String[] opciones = {
            "1. Ver Gatos",
            "2. Mostrar Gatos",
            "3. Checar si el Stack está lleno",
            "4. Eliminar ultimo gato",
            "5. Salir"
        };
        
        do {
            String opcion = ( String ) JOptionPane.showInputDialog( null, "Gatitos Java", "Menú Principal", 
                    JOptionPane.INFORMATION_MESSAGE,
                    null, 
                    opciones, 
                    opciones[0] );
            
            for ( int i = 0; i < opciones.length; i++ ) {
                if ( opcion.equals( opciones[i] ) ) {
                    opcionMenu = i;
                }
            }
            
            GatoService service = new GatoService();
            
            switch ( opcionMenu ) {
                case 0 -> { 
                    System.out.println("Vas a ver a un gato.");
                    Gato g = service.getGatos();
                    stackGatos.push(g);
                }
                case 1 -> stackGatos.mostrarGato();
                case 2 -> {
                    if (stackGatos.estaLlena()) {
                        System.out.println("El stack está lleno.");
                    } else {
                        System.out.println("El stack no está lleno");
                    }
                }
                case 3 -> stackGatos.pop();
                case 4 -> System.out.println("Vas a salir del sistema.");
            }
        } while ( opcionMenu != 4 );
    }
}
