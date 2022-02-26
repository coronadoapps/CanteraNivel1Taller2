package com.sofka.Punto5;

import java.io.IOException;
import java.util.Scanner;


public class Punto5 {

    private String[] productos = {"Pastillas", "Jarabe", "Dermatología", "Cosmético"};
    private int[] precios = {10, 30, 65, 49};
    private boolean continuar = true;
    private int opcion;

    public void Punto5() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do{
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, productos, precios);
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
        System.out.println("5. La Droguería Mi Salud presta sus servicios en la localidad de Suba y requiere una aplicación para poder facturar los productos que vende a sus clientes y para ello, los productos tienen unas características que deben indicársele al cliente para que pueda escoger el producto a comprar. Para cada cliente, se tienen las opciones de compra de producto, consulta de precios por producto y devoluciones en caso de que se presenten.");
    }

    public static void Menu(){
        System.out.println("Droguería Mi Salud: localidad de Suba");
        System.out.println("1. Comprar producto");
        System.out.println("2. Consultar precio de producto");
        System.out.println("3. Devolver producto");
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

    private static boolean evaluarOpcion(int opcion, String[] productos, int[] precios) throws IOException{
        String aux;
        int indice;
        switch(opcion){
            case 1:
                System.out.println("Por favor ingrese el nombre del producto a comprar");
                aux = capturarDatoString();
                indice = buscarProducto(aux, productos);
                if(!(indice == -1)){
                    System.out.println("Pendiente cancelar: " + "$" + precios[indice]);
                }else{
                    System.out.println("Producto no disponible.");
                }
                return true;
            case 2:
                System.out.println("Por favor ingrese el nombre del producto a consultar");
                aux = capturarDatoString();
                indice = buscarProducto(aux, productos);
                if(!(indice == -1)){
                    System.out.println(productos[indice] + ": $" + precios[indice]);
                }else{
                    System.out.println("Producto no disponible.");
                }
                return true;
            case 3:
                System.out.println("Por favor ingrese el nombre del producto a devolver");
                aux = capturarDatoString();
                indice = buscarProducto(aux, productos);
                if(!(indice == -1)){
                    System.out.println("Devolución pendiente: $" + precios[indice]);
                }else{
                    System.out.println("Producto no disponible.");
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
    
    private static int buscarProducto(String producto, String[] productos){
        int indice = -1;

        for (int i = 0; i < productos.length; i++) {
            if(productos[i].toLowerCase().equals(producto.toLowerCase())){
                indice = i;
            }
        }

        return indice;
    }
}
