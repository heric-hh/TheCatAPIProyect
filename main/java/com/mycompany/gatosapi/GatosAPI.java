package com.mycompany.gatosapi;

import java.io.IOException;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author hheri
 */
public class GatosAPI {
    
    public static Stack<Gato> stackGatos = new Stack<>();
    
    public static void mostrarGato() {
        Gato g = stackGatos.peek();
        System.out.println("ID: " + g.getId() + "\nURL: " + g.getUrl());
    }

    public static void main(String[] args) throws IOException {
        GatoService catService = new GatoService();
        //catService.getGatos();
        
        
        
        int opcionMenu = -1;
        String[] opciones = {
            "1. Ver Gatos",
            "2. Ver Último Gato",
            "3. Checar si el Stack está vacío",
            "4. Salir"
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
                case 1 -> mostrarGato();
                case 2 -> System.out.println(stackGatos.empty());
                case 3 -> System.out.println("Vas a salir del sistema.");
            }
        } while ( opcionMenu != 3 );
    }
}
