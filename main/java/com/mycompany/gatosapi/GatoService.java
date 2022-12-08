package com.mycompany.gatosapi;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hheri
 */
public class GatoService {
    // Renderizar imagen
    public void desplegarImagen( Gato unGato, ImageIcon img ) throws IOException {
        String menu = "Opciones: \n"
                + "1. Ver Otro Gato\n"
                + "2. Regresar\n";
        String[] opciones = {"Ver Otro Gato", "Regresar"};
        String idGato = unGato.getId();
        String opcion = (String) JOptionPane.showInputDialog( null, menu, idGato, JOptionPane.INFORMATION_MESSAGE, img, opciones, opciones[0] );
        
        int seleccion = -1;
        
        for (int i = 0; i < opciones.length; i++) {
            if ( opcion.equals( opciones[i] ) ) {
                seleccion = -1;
            }
        }
        
        switch (seleccion) {
            case 0 -> getGatos();
            default -> {}
        }
        
    }
    
    // Conexion con la API
    public Gato getGatos() throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();
        
        //Toda la información de API
        Response response = client.newCall(request).execute();
        
        //Crear un objeto con formmato  Jso
        String gatoJson = response.body().string();
        //Quitar llave inicial y final
        gatoJson = gatoJson.substring(1,gatoJson.length());
        gatoJson = gatoJson.substring(0, gatoJson.length()-1);
        
        System.out.println("gatoJson: " + gatoJson);
        //Crear un objeto de la clase json
        Gson gson = new Gson();
        Gato gato = gson.fromJson(gatoJson, Gato.class);
        //return gato;
       
        //Probando que la información esté en el objeto Gato
        System.out.println("Gato id: " + gato.getId());
        System.out.println("Gato url: " + gato.getUrl());
        
        Image image = null;
        try{
            URL url = new URL(gato.getUrl());
            image = ImageIO.read(url);
            
            //Redimensionar la imagen obtenida
            ImageIcon imgGato = new ImageIcon(image);
            if(imgGato.getIconWidth()>800){
                Image img = imgGato.getImage();
                Image imgModificada = img.getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH);
                imgGato = new ImageIcon(imgModificada);
            }
            
            desplegarImagen(gato, imgGato);
            
        } catch ( Exception e ) {
            System.out.println("No se pudo crear el objeto Image");
        }
        return gato;
    }
}
