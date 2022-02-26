package com.sofka.Punto10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Punto10 {
    public ArrayList<String> titular = new ArrayList<>();
    public ArrayList<Integer> cantidad = new ArrayList<>();
    private boolean continuar = true;
    private int opcion;

    public void Punto10() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do{
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, titular, cantidad);
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
        System.out.println("10. El banco Su banco fiel es un banco que inicia sus actividades financieras y necesita una aplicación para llevar las cuentas de sus usuarios; por lo tanto, se sugiere que la cuenta tenga los atributos titular y cantidad. Para cada cliente las cuentas permitirán realizar ingresos, retiros o consultas de valor. En los ingresos no se pueden insertar valores negativos y para los retiros el valor no puede ser mayor al valor que tiene en la cuenta.");
    }

    public static void Menu(){
        System.out.println("Bienvenido a Su banco fiel ---");
        System.out.println("1. Realizar ingreso a su cuenta");
        System.out.println("2. Realizar retiro de su cuenta");
        System.out.println("3. Consultar saldo disponible");
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

    private static boolean evaluarOpcion(int opcion, ArrayList<String> titular, ArrayList<Integer> cantidad) throws IOException{
        switch(opcion){
            case 1:
                solicitarDato("el titular de la cuenta");
                String aux = capturarDatoString();
                return true;
            case 2:
                return true;
            case 3:
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
 
}
