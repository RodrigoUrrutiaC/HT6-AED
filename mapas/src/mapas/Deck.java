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
    ArrayList<String> monstruo,trampa,hechizo, monstruoUsuario, monstruoNum, trampaNum, hechizoNum, trampaUsuario, hechizoUsuario;
    public Deck(int tipoMapa){
        deck = new MapFactory().getMap(tipoMapa);
        deckUsuario = new MapFactory().getMap(tipoMapa);  
        monstruo = new ArrayList<>();
        trampa = new ArrayList<>();
        hechizo = new ArrayList<>();
        monstruoUsuario = new ArrayList<>();
        monstruoNum = new ArrayList<>(); 
        trampaUsuario = new ArrayList<>();
        trampaNum = new ArrayList<>(); 
        hechizoUsuario = new ArrayList<>();
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
                    if (deckUsuario.containsValue(carta)){
                        for(int j=0;monstruo.size()>=j;j++){
                            if (carta.equals(monstruo.get(j))){
                                int numero = Integer.parseInt(monstruoNum.get(j));
                                numero = numero + 1;
                                monstruoNum.add(j,Integer.toString(numero)); 
                            }
                            else{
                                monstruo.add(carta);
                                System.out.println("Carta agregada exitosamente");
                            }  
                        }       
                    }
                    break;
                case "Hechizo":
                    if (deckUsuario.containsValue(carta)){
                        for(int j=0;hechizo.size()>=j;j++){
                            if (carta.equals(hechizo.get(j))){
                                int numero = Integer.parseInt(hechizoNum.get(j));
                                numero = numero + 1;
                                hechizoNum.add(j,Integer.toString(numero)); 
                            }
                            else{
                                hechizo.add(carta);
                                System.out.println("Carta agregada exitosamente");
                            }  
                        }       
                    }
                    break;
                case "Trampa":
                    if (deckUsuario.containsValue(carta)){
                        for(int j=0;trampa.size()>=j;j++){
                            if (carta.equals(trampa.get(j))){
                                int numero = Integer.parseInt(trampaNum.get(j));
                                numero = numero + 1;
                                trampaNum.add(j,Integer.toString(numero)); 
                            }
                            else{
                                trampa.add(carta);
                                System.out.println("Carta agregada exitosamente");
                            }  
                        }       
                    }
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
        return deckUsuario.toString(); 
        
    }

    public String deckUsuarioPorTipo4(){
        String monstruoA = monstruoUsuario.toString();
        String monstruoN = monstruoNum.toString();
        String trampaA = trampaUsuario.toString();
        String trampaN = trampaNum.toString();
        String hechizoA = hechizoUsuario.toString();
        String hechizoN = hechizoNum.toString();
        return "Hechizo: " + hechizoA + hechizoN + " Monstruo: " + monstruoA + monstruoN + " Trampa: " + trampaN + trampaA ; 
        
    }

    public String deck5(){
        return deckUsuario.toString();
    }

    public String deckPorTipo6(){
        String monstruoA = monstruoUsuario.toString();
        String trampaA = trampaUsuario.toString();
        String hechizoA = hechizoUsuario.toString();
        return "Hechizo: " + hechizoA + " Monstruo: " + monstruoA + " Trampa: " + trampaA ; 
    }

}