package mapas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Rodrigo Urrutia 16139
 * @author Kevin Macario 17369
 * @version 5.03.2018
 */

public class Deck {
    Map<String, ArrayList> deck, deckUsuario;
    ArrayList<String> monstruo,trampa,hechizo, monstruoUsuario, trampaUsuario, hechizoUsuario;
    
    public Deck(int tipoMapa){
        deck = new MapFactory().getMap(tipoMapa);
        deckUsuario = new MapFactory().getMap(tipoMapa);           
        monstruo = new ArrayList<>();
        trampa = new ArrayList<>();
        hechizo = new ArrayList<>();
        monstruoUsuario = new ArrayList<>();
        trampaUsuario = new ArrayList<>();
        hechizoUsuario = new ArrayList<>();                 
    }
    
    public void llenarBaraja() throws IOException{
        
        FileReader fr = new FileReader("cards_desc.txt");
        BufferedReader br = new BufferedReader(fr);

        String linea,carta,tipo;
        int i;

        while((linea = br.readLine())!=null){
            i = linea.indexOf('|');
            carta = linea.substring(0,i);
            tipo = linea.substring(i+1,linea.length());
              // Key: Tipo de carta y Value: Nombre de carta  

            switch (tipo) {
                case "Monstruo":
                    monstruo.add(carta);
                    break;
                case "Trampa":
                    trampa.add(carta);
                    break;
                case "Hechizo":
                    hechizo.add(carta);
                    break;
            }
        }
        
        deck.put("Monstruo", monstruo);
        deck.put("Trampa", trampa);
        deck.put("Hechizo", hechizo);
        deckUsuario.put("Monstruo", monstruoUsuario);
        deckUsuario.put("Trampa", trampaUsuario);
        deckUsuario.put("Hechizo", hechizoUsuario);
    }

    public void agregarCarta1(String nombre){
        
        if(monstruo.contains(nombre)){
            monstruoUsuario.add(nombre);
        } else if(trampa.contains(nombre)){
            trampaUsuario.add(nombre);
        } else if(hechizo.contains(nombre)){
            hechizoUsuario.add(nombre);
        }
        
    }
    
    public String prueba1(){
        return deckUsuario.toString();
    }

    public void tipoCarta2(){
        
    }

    public void deckUsuario3(){
        
    }

    public void deckUsuarioPorTipo4(){
        
    }

    public void deck5(){
        
    }

    public void deckPorTipo6(){
        
    }

}