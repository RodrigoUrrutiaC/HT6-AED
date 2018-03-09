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
    ArrayList<String> monstruo,trampa,hechizo, monstruoUsuario, trampaUsuario, hechizoUsuario,imprimir;
    ArrayList<Integer> monstruoNum, trampaNum, hechizoNum;
    
    public Deck(int tipoMapa){
        deck = new MapFactory().getMap(tipoMapa);
        deckUsuario = new MapFactory().getMap(tipoMapa);           
        monstruo = new ArrayList<>();
        trampa = new ArrayList<>();
        hechizo = new ArrayList<>();
        monstruoUsuario = new ArrayList<>();
        trampaUsuario = new ArrayList<>();
        hechizoUsuario = new ArrayList<>();    
        imprimir = new ArrayList<>();    
        monstruoNum = new ArrayList<>();    
        trampaNum = new ArrayList<>();    
        hechizoNum = new ArrayList<>();    
        
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

    public String agregarCarta1(String nombre){
        int j;
        
        if(monstruo.contains(nombre)){
            if(monstruoUsuario.contains(nombre)){
                j=monstruoUsuario.indexOf(nombre);
                monstruoNum.set(j, monstruoNum.get(j)+1);       
            } else {
                monstruoUsuario.add(nombre);
                monstruoNum.add(1);
            }
            return "Adición exitosa";
            
        } else if(trampa.contains(nombre)){
            if(trampaUsuario.contains(nombre)){
                j=trampaUsuario.indexOf(nombre);
                trampaNum.set(j, trampaNum.get(j)+1);       
            } else {
                trampaUsuario.add(nombre);
                trampaNum.add(1);
            }
            return "Adición exitosa";
            
        } else if(hechizo.contains(nombre)){
            if(hechizoUsuario.contains(nombre)){
                j=hechizoUsuario.indexOf(nombre);
                hechizoNum.set(j, hechizoNum.get(j)+1);       
            } else {
                hechizoUsuario.add(nombre);
                hechizoNum.add(1);
            }
            return "Adición exitosa";
        }
        else return "No se encontró la carta en la deck";
    }
    
    public String prueba1(){
        return deck.toString();
    }

    public String tipoCarta2(String nombre){

        if(monstruo.contains(nombre)){
            return "Tipo Monstruo";
        } else if(trampa.contains(nombre)){
            return "Tipo Trampa";
        } else if(hechizo.contains(nombre)){
            return "Tipo Hechizo";
        } else return "No se encuentra esa carta en la Deck";
    }

    public String deckUsuario3(){
        imprimir.clear();
        for(int i=0; i<monstruoUsuario.size(); i++){
                imprimir.add("Monstruo - "+monstruoUsuario.get(i)+" - Cantidad: " 
                        + Integer.toString(monstruoNum.get(i)));
	} 
        for(int i=0; i<trampaUsuario.size(); i++){
                imprimir.add("Trampa - "+trampaUsuario.get(i)+" - Cantidad: " 
                        + Integer.toString(trampaNum.get(i)));
	} 
        for(int i=0; i<hechizoUsuario.size(); i++){
                imprimir.add("Hechizo - "+hechizoUsuario.get(i)+" - Cantidad: " 
                        + Integer.toString(hechizoNum.get(i)));
	} 
        
        return imprimir.toString();
    }

    public String deckUsuarioPorTipo4(){
        imprimir.clear();
        imprimir.add("MONSTRUO:");
        for(int i=0; i<monstruoUsuario.size(); i++){
                imprimir.add(" "+monstruoUsuario.get(i)+" - Cantidad: " 
                        + Integer.toString(monstruoNum.get(i)));
	} 
        imprimir.add("TRAMPA:");
        for(int i=0; i<trampaUsuario.size(); i++){
                imprimir.add(" "+trampaUsuario.get(i)+" - Cantidad: " 
                        + Integer.toString(trampaNum.get(i)));
	}
        imprimir.add("HECHIZO:");
        for(int i=0; i<hechizoUsuario.size(); i++){
                imprimir.add(" "+hechizoUsuario.get(i)+" - Cantidad: " 
                        + Integer.toString(hechizoNum.get(i)));
	} 
        
        return imprimir.toString();
    }

    public String deck5(){
        imprimir.clear();
        for(int i=0; i<monstruo.size(); i++){
                imprimir.add("Monstruo - "+monstruo.get(i));
	} 
        for(int i=0; i<trampa.size(); i++){
                imprimir.add("Trampa - "+trampa.get(i));
	} 
        for(int i=0; i<hechizo.size(); i++){
                imprimir.add("Hechizo - "+hechizo.get(i));
	} 
        
        return imprimir.toString();
    }

    public String deckPorTipo6(){
        return deck.toString();
    }

}