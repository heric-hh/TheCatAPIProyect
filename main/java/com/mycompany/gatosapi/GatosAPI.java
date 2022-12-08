package com.mycompany.gatosapi;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author hheri
 */
public class GatosAPI {

    public static void main(String[] args) throws IOException {
        GatoService catService = new GatoService();
        catService.getGatos();
        
        int opcionMenu = -1;
        String[] opciones = {
            "1. Ver Gatos",
            "2. Salir"
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
                case 0: 
                    System.out.println("Vas a ver a un gato.");
                    service.getGatos();
                    break;
                case 1:
                    System.out.println("Vas a salir del sistema.");
            }
        } while ( opcionMenu != 2 );
    }
}
