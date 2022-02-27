package com.sofka.Punto10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Punto10 {
    public ArrayList<String> titulares = new ArrayList<>();
    public ArrayList<Integer> cantidades = new ArrayList<>();
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
            continuar = evaluarOpcion(opcion, titulares, cantidades);
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
        System.out.println("1. Registrar una nueva cuenta");
        System.out.println("2. Ingresar con el nombre del titular");
        System.out.println("3. Listar titulares");
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

    private static boolean evaluarOpcion(int opcion, ArrayList<String> titulares, ArrayList<Integer> cantidades) throws IOException{
        switch(opcion){
            case 1:
                registrarCuenta(titulares, cantidades);
                return true;
            case 2:
                login(titulares, cantidades);
                return true;
            case 3:
                listarTitulares(titulares);
                return true;
            case 0:
                return false;
            default:
                System.out.println("Opción incorrecta");
                System.in.read();
        }
        return true;
    }

    private static void listarTitulares(ArrayList<String> titulares){
        System.out.println("Se presenta un listado de los actuales titulares de cuentas---");
        if (titulares.size() != 0) {
            for (int i = 0; i < titulares.size(); i++) {
                System.out.println("- " + titulares.get(i));
            }    
        } else {
            System.out.println("Actualmente no se encuentra registrado ningun titular.");
        }
        
    }

    private static void registrarCuenta(ArrayList<String> titulares, ArrayList<Integer> cantidades){
        solicitarDato("el nombre del titular de la nueva cuenta");
        String aux = capturarDatoString();
        boolean registrado = false;
        for (int i = 0; i < titulares.size(); i++) {
            if(aux.toLowerCase().equals(titulares.get(i).toLowerCase())){
                registrado = true;
                break;
            }
        }
        if (registrado) {
            System.out.println("El nombre del titular ya se encuentra registrado.");
        } else {
            titulares.add(aux);
            solicitarDato("la cantidad de la nueva cuenta");
            int cantidad = capturarOpcion();
            if (cantidad > 0) {
                cantidades.add(cantidad);
                System.out.println("Nueva cuenta registrada correctamente!");;
            } else {
                System.out.println("La cantidad no puede ser negativa o cero.");
            }
        }

    }

    private static void login(ArrayList<String> titulares, ArrayList<Integer> cantidades) throws IOException{
        solicitarDato("el nombre del titular de la cuenta");
        String aux = capturarDatoString();
        boolean registrado = false;
        int indice = -1;
        for (int i = 0; i < titulares.size(); i++) {
            if(aux.toLowerCase().equals(titulares.get(i).toLowerCase())){
                registrado = true;
                indice = i;
                break;
            }
        }
        if (registrado) {
            menuCuenta(titulares, cantidades, indice);
        } else {
            System.out.println("El nombre del titular no se encuentra registrado.");
        }

    }

    private static void menuCuenta(ArrayList<String> titulares, ArrayList<Integer> cantidades, int indice) throws IOException{
        int opcion;
        boolean flag = true;
        do {
            limpiarPantalla();
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Realizar ingreso a su cuenta");
            System.out.println("2. Realizar retiro de su cuenta");
            System.out.println("3. Consultar saldo disponible");
            System.out.println("0. Salir de la aplicacion");
            opcion = capturarOpcion();
            switch(opcion){
                case 1:
                    limpiarPantalla();
                    ingresoCuenta(titulares, cantidades, indice);
                    presioneCualquierTeclaParaContinuar();
                    break;
                case 2:
                    limpiarPantalla();
                    retiroCuenta(titulares, cantidades, indice);
                    presioneCualquierTeclaParaContinuar();
                    break;
                case 3:
                    limpiarPantalla();
                    System.out.println("Saldo disponible: " + cantidades.get(indice));
                    presioneCualquierTeclaParaContinuar();
                    break;
                case 0:
                    limpiarPantalla();
                    flag = false;
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Opción incorrecta");
                    System.in.read();
            }
        } while (flag);
    }

    private static void ingresoCuenta(ArrayList<String> titulares, ArrayList<Integer> cantidades, int indice){
        System.out.println("Ingreso a cuenta---");
        solicitarDato("la cantidad que desea ingresar");
        int cantidad = capturarOpcion();
        if (cantidad <= 0) {
            System.out.println("La cantidad no puede ser negativa o cero.");
        } else {
            cantidades.set(indice, cantidades.get(indice) + cantidad);
            System.out.println("Cantidad ingresada correctamente!");
        }
    }

    private static void retiroCuenta(ArrayList<String> titulares, ArrayList<Integer> cantidades, int indice){
        System.out.println("Retiro cantidad de cuenta---");
        solicitarDato("la cantidad que desea retirar");
        int cantidad = capturarOpcion();
        if (cantidad <= 0) {
            System.out.println("La cantidad no puede ser negativa o cero.");
        } else if((cantidades.get(indice) - cantidad) < 0){
            System.out.println("No cuentas con saldo suficiente para realizar este movimiento!");
        } else {
            cantidades.set(indice, cantidades.get(indice) - cantidad);
            System.out.println("Cantidad retirada correctamente!");
        }
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
