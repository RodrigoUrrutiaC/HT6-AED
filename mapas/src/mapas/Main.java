package mapas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rodrigo Urrutia 16139
 * @author Kevin Macario 17369
 * @version 5.03.2018
 */

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("¡Bienvenido al programa de colección de cartas!");
        setMenu();

        int tipoMapa = scan.nextInt();

        Deck d = new Deck(tipoMapa); //llama al metodo para asignar el tipo de dato que elija el usuario

        d.llenarBaraja(); //llena la baraja con la informacion en el archivo.txt

        boolean mostrarMenu = true;
        while (mostrarMenu){
            menuPrincipal();
            int pregunta = scan.nextInt();
            switch (pregunta){
                case 1:
                    System.out.println();
                    System.out.println("Ingrese el nombre de la carta a agregar en su deck:");
                    String metodo1= scan.next();
                    d.agregarCarta1(metodo1);
                    break;
                case 2:
                    d.tipoCarta2();
                    break;
                case 3:
                    d.deckUsuario3();
                    break;
                case 4:
                    d.deckUsuarioPorTipo4();
                    break;
                case 5:
                    d.deck5();
                    break;
                case 6:
                    d.deckPorTipo6();
                    break;
                case 7:
                    mostrarMenu = false;
                    break;
            }
        }
    }

    public static void menuPrincipal(){
        System.out.println();
        System.out.println("--------MENU PRINCIPAL--------");
        System.out.println();
        System.out.println("1) Agregar una carta a la colección del usuario.");
        System.out.println("2) Indicar el tipo de una carta específica. El usuario ingresará el nombre de la carta.");
        System.out.println("3) Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.");
        System.out.println("4) Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo.");
        System.out.println("5) Mostrar el nombre y tipo de todas las cartas existentes.");
        System.out.println("6) Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
        System.out.println("7) Salir del Programa");
    }
    
        public static void setMenu(){
        System.out.println();
        System.out.println("Seleccione el tipo de Mapa a utilizar (1/2/3):");
        System.out.println();
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");
    }
}