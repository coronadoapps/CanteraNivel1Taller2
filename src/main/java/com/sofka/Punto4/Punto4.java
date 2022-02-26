package com.sofka.Punto4;

import java.io.IOException;
import java.util.Scanner;


public class Punto4 {

    private String [] peliculas = {"Titanic", "The Matrix", "Back to the future", "Interestelar"};
    private boolean continuar = true;
    private int opcion;

    public void Punto4() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do{
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, peliculas);
            presioneCualquierTeclaParaContinuar();
        } while(continuar == true);
    }

    public void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private static int capturarDatoInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static String capturarDatoString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void Enunciado(){
        System.out.println("4. La video tienda que presta sus servicios de alquiler de películas a los usuarios del barrio el Porvenir, requiere de una aplicación que permita registrar el alquiler de las películas que adquieren sus usuarios. Para cada usuario se debe permitir la opción de alquilar película, consultar películas disponibles y recibir película en la video tienda con la opción de realizar anotaciones sobre estas si se llegan a presentar daños u otra novedad sobre la película.");
    }

    public static void Menu(){
        System.out.println("Películas Porvenir: Video Tienda");
        System.out.println("1. Alquilar película");
        System.out.println("2. Películas disponibles");
        System.out.println("3. Recibir película");
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

    private static boolean evaluarOpcion(int opcion, String[] peliculas) throws IOException{
        String aux;
        int indice;
        switch(opcion){
            case 1:
                System.out.println("Por favor ingrese la película que desea alquilar");
                aux = capturarDatoString();
                indice = buscarPelicula(aux, peliculas);
                if(!(indice == -1)){
                    System.out.println(peliculas[indice] + " disponible para alquilar!");
                }
                return true;
            case 2:
                System.out.println("Películas disponibles: ");
                for (int i = 0; i < peliculas.length; i++) {
                    System.out.println(i+1 + "- " + peliculas[i]);
                }
                return true;
            case 3:
                System.out.println("Por favor ingrese la película que desea entregar");
                aux = capturarDatoString();
                System.out.println("Observaciones: ");
                aux = "Película: " + aux + " Observaciones: " + capturarDatoString();
                System.out.println(aux);
                return true;
            case 0:
                return false;
            default:
                System.out.println("Opción incorrecta");
                System.in.read();
        }
        return true;
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
    
    private static int buscarPelicula(String pelicula, String[] peliculas){
        int indice = -1;

        for (int i = 0; i < peliculas.length; i++) {
            if(peliculas[i].toLowerCase().equals(pelicula.toLowerCase())){
                indice = i;
            }
        }

        return indice;
    }
}
