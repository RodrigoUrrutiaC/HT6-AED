package mapas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


/**
 * @author Rodrigo Urrutia 16139
 * @author Kevin Macario 17369
 * @version 5.03.2018
 */

public class Deck {
    Map deck, deckUsuario, deckBusqueda;

    public Deck(int tipoMapa){
        deck = new MapFactory().getMap(tipoMapa);
        deckBusqueda = new MapFactory().getMap(tipoMapa);
        deckUsuario = new MapFactory().getMap(tipoMapa);
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
            deck.put(tipo, carta);  // Key: Tipo de carta y Value: Nombre de carta  
            deckBusqueda.put(carta, tipo);
        }
    }

    public void agregarCarta1(String nombre){

        if(deck.containsValue(nombre)){
            deckUsuario.put(deckBusqueda.get(nombre), nombre);
        }
                
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