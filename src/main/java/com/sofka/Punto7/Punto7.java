package com.sofka.Punto7;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Punto7 {

    private float peso, estatura;
    private boolean continuar = true;
    private int opcion;

    public void Punto7() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do{
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, peso, estatura);
            presioneCualquierTeclaParaContinuar();
        } while(continuar == true);
    }

    public static void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private static String capturarDatoString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static float capturarDatoFloat(){
        Scanner input = new Scanner(System.in);
        return input.nextFloat();
    }

    public static void Enunciado(){
        System.out.println("7. La Secretaría de Salud Municipal requiere de una aplicación que le permita calcular el IMC Índice de masa corporal y requiere los datos peso en kilogramos y estatura en metros Para cada persona encuestada adicional a los datos suministrados, debe mostrar el resultado para cada uno y establecer en qué rango se encuentra (bajo peso, normal, sobrepeso y obeso).");
    }

    public static void Menu(){
        System.out.println("Secretaría de Salud Municipal: IMC");
        System.out.println("1. Calcular mi IMC");
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

    private static boolean evaluarOpcion(int opcion, float peso, float estatura) throws IOException{
        switch(opcion){
            case 1:
                solicitarDato("su peso en kg");
                peso = capturarDatoFloat();
                solicitarDato("su estatura en m");
                estatura = capturarDatoFloat();
                calcularIMC(peso, estatura);
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

    private static void calcularIMC(float peso, float estatura){
        float imc = peso / (estatura * estatura);
        if(imc <= 18.5){
            System.out.println("Su IMC=" + imc + " Pertence a la categoría de: Bajo peso");
        } else if(imc > 18.5 && imc <= 24.9){
            System.out.println("Su IMC=" + imc + " Pertence a la categoría de: Peso normal");
        } else if(imc > 24.9 && imc <= 29.9){
            System.out.println("Su IMC=" + imc + " Pertence a la categoría de: Sobrepeso");
        } else if(imc > 29.9){
            System.out.println("Su IMC=" + imc + " Pertence a la categoría de: Obesidad");
        }
    }
 
}
