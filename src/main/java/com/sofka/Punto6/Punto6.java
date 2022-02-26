package com.sofka.Punto6;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Punto6 {

    public String[] placas = {"", "", "", "", ""};
    public String[] observaciones = {"", "", "", "", ""};
    public String[] novedades = {"", "", "", "", ""};
    private boolean continuar = true;
    private int opcion;

    public void Punto6() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do{
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, placas, observaciones, novedades);
            presioneCualquierTeclaParaContinuar();
        } while(continuar == true);
    }

    private static void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private static String capturarDatoString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void Enunciado(){
        System.out.println("6. El taller de motos El Maquinista recibe motocicletas de alto cilindraje para realizar las respectivas revisiones y requiere una aplicación que le permita registrar los servicios generados a sus clientes. Para cada motocicleta se debe tener registro del ingreso al taller y las observaciones por parte del cliente. También debe existir registro de salida del taller con las novedades y otra de arreglos hechos por el mecánico en caso de que se requiera inventariar cambios repuestos en la motocicleta al entregarla.");
    }

    public static void Menu(){
        System.out.println("El Maquinista: taller de motos");
        System.out.println("1. Registrar ingreso al taller");
        System.out.println("2. Registrar salida del taller");
        System.out.println("3. Registrar arreglos por mecánico");
        System.out.println("0. Salir de la aplicación");
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    private static int capturarOpcion() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static boolean evaluarOpcion(int opcion, String[] placas, String[] observaciones, String[] novedades) throws IOException{
        String aux;
        int indice=-1;
        switch(opcion){
            case 1:
                solicitarDato("la placa de la moto a registrar");
                aux = capturarDatoString();
                placas = agregarArreglo(placas, aux);
                solicitarDato("las observaciones del arreglo");
                aux = capturarDatoString();
                observaciones = agregarArreglo(observaciones, aux);
                return true;
            case 2:
                solicitarDato("la placa de la moto que desea retirar del taller");
                aux = capturarDatoString();
                indice = verificarPlaca(placas, aux);
                if(indice==-1){
                    System.out.println("No se encuentra ninguna moto registrada con la placa: " + aux);
                }else{
                    registrarSalida(placas, observaciones, novedades, indice);
                }
                return true;
            case 3:
                solicitarDato("la placa de la moto que desea registrar un arreglo");
                aux = capturarDatoString();
                indice = verificarPlaca(placas, aux);
                if(indice==-1){
                    System.out.println("No se encuentra ninguna moto registrada con la placa: " + aux);
                }else{
                    registrarArreglo(placas, observaciones, novedades, indice);
                }
                return true;
            case 0:
                return false;
            default:
                System.out.println("Opción incorrecta");
                System.in.read();
        }
        return true;
    }

    private static void registrarArreglo(String[] placas, String[] observaciones, String[] novedades, int indice) {
        solicitarDato("las novedades respecto a esta reparación");
        novedades[indice] = capturarDatoString();
        System.out.println("Se registra la reparación a la moto de placa: " + placas[indice] + " con las siguientes novedades: " + novedades[indice]);
        
    }

    private static void registrarSalida(String[] placas, String[] observaciones, String[] novedades, int indice) {
        System.out.println("Se termina la atencion al vehiculo de placa: " + placas[indice] + " con las siguientes novedades: " + novedades[indice]);
        placas[indice]="";observaciones[indice]="";novedades[indice]="";
    }

    private static void presioneCualquierTeclaParaContinuar() { 
        System.out.println("Presione cualquier tecla para continuar...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }

    private static String[] agregarArreglo(String[] array, String element){
        //array = Arrays.copyOf(array, array.length+1);
        //array[array.length-1] = element;
        boolean guardado=false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].isEmpty()) {
                array[i] = element;
                guardado=true;
                break;
            }
        }

        if (guardado) {
            System.out.println("Guardado exitosamente.");
        } else{
            System.out.println("Espacio insuficiente.");
        }
        return array;
    }

    private static int verificarPlaca(String[] array, String element){
        int indice=-1;
        for (int i = 0; i < array.length; i++) {
            if(array[i].toLowerCase().equals(element.toLowerCase())){
                indice = i;
            }
        }
        return indice;
    }
 
}
