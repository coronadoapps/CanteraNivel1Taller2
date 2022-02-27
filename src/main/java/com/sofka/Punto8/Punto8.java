package com.sofka.Punto8;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Punto8 {

    public String[] sabores = {"Chocolate", "Vainilla", "Fresa", "Frutas", "Merengue"};
    public ArrayList<String> ventas = new ArrayList<>();
    public int porciones;
    public String decoraciones;
    private boolean continuar = true;
    private int opcion;

    public void Punto8() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do{
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, sabores, porciones, decoraciones, ventas);
            presioneCualquierTeclaParaContinuar();
        } while(continuar);
    }

    private static void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private static String capturarDatoString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void Enunciado(){
        System.out.println("8. El pastelero Don Carlos es el mejor pastelero de la ciudad y requiere una aplicación que le permita registrar los pedidos de los clientes en cuanto a las tortas que realiza. Cada torta tiene unas características propias como sabor, cantidad (porciones) y decoraciones). Se requiere que la aplicación permita registrar los pedidos, las tortas disponibles y las ventas que se registren diariamente.");
    }

    public static void Menu(){
        System.out.println("Pastelería Don Carlos, la mejor de la ciudad");
        System.out.println("1. Registrar un pedido");
        System.out.println("2. Mostrar pasteles disponibles");
        System.out.println("3. Ventas registradas en el dia");
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

    private static boolean evaluarOpcion(int opcion, String[] sabores, int porciones, String decoraciones, ArrayList<String> ventas) throws IOException{
        String aux;
        int indice;
        switch(opcion){
            case 1:
                indice = registrarPedido(sabores, porciones, decoraciones, ventas);
                
                if(indice == -1){
                    System.out.println("Sabor de pastel no disponible, intente de nuevo");
                } else{
                    System.out.println("Pedido registrado exitosamente!! vuelva pronto.");
                }
                return true;
            case 2:
                System.out.println("Se muestran los pasteles disponibles: ");
                for (int i = 0; i < sabores.length; i++) {
                    System.out.println(i+1 + ". Pastel de " + sabores[i]);
                }
                
                return true;
            case 3:
                System.out.println("--Ventas realizadas del dia---");
                for (int i = 0; i < ventas.size(); i++) {
                    System.out.println(i+1 + ". " + ventas.get(i));
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

    private static void presioneCualquierTeclaParaContinuar() { 
        System.out.println("Presione cualquier tecla para continuar...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }

    private static int registrarPedido(String[] sabores, int porciones, String decoraciones, ArrayList<String> ventas){
        System.out.println("--Realizar pedido--");
        solicitarDato("el sabor de pastel de su pedido");
        String aux = capturarDatoString();
        int indice = -1;
        for (int i = 0; i < sabores.length; i++) {
            if (aux.toLowerCase().equals(sabores[i].toLowerCase())) {
                indice = i;
                solicitarDato("la cantidad de porciones para su pastel de " + sabores[i]);
                porciones = capturarOpcion();
                solicitarDato("las decoraciones para su pastel de " + sabores[i]);
                decoraciones = capturarDatoString();
                ventas.add("Pastel de " + sabores[i] + ", " + porciones + " porciones y decoraciones: " + decoraciones);
                break;
            }
        }
        return indice;
    }
 
}
