package com.sofka.Punto9;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Punto9 {

    private float base, altura, baseM;
    private boolean continuar = true;
    private int opcion;

    public void Punto9() throws IOException{
        Enunciado();
        presioneCualquierTeclaParaContinuar();
        do{
            limpiarPantalla();
            Menu();
            opcion = capturarOpcion();
            limpiarPantalla();
            continuar = evaluarOpcion(opcion, base, altura, baseM);
            presioneCualquierTeclaParaContinuar();
        } while(continuar == true);
    }

    public static void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private static float capturarDatoFloat(){
        Scanner input = new Scanner(System.in);
        return input.nextFloat();
    }

    public static void Enunciado(){
        System.out.println("9. El profesor de geometría está explicando a sus estudiantes las fórmulas para calcular el área de diferentes figuras geométricas, para ello requiere una aplicación que le facilite el ejercicio solicitándole los valores al estudiante. La aplicación debe permitir que el estudiante seleccione si desea calcular el área de un rectángulo, triángulo o trapecio. No olvide solicitar los datos necesarios para realizar cada cálculo y mostrar su respectivo resultado.");
    }

    public static void Menu(){
        System.out.println("Calcular el área polígonos");
        System.out.println("1. Calcular el área de un rectángulo");
        System.out.println("2. Calcular el área de un triángulo");
        System.out.println("3. Calcular el área de un trapecio");
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

    private static boolean evaluarOpcion(int opcion, float base, float altura, float baseM) throws IOException{
        switch(opcion){
            case 1:
                System.out.println("Rectángulo -> A = base x altura");
                solicitarDato("la base");
                base = capturarDatoFloat();
                solicitarDato("la altura");
                altura = capturarDatoFloat();
                calcularArea(opcion, base, altura, 1);
                return true;
            case 2:
                System.out.println("Triángulo -> A = (base x altura)/2");
                solicitarDato("la base");
                base = capturarDatoFloat();
                solicitarDato("la altura");
                altura = capturarDatoFloat();
                calcularArea(opcion, base, altura, 1);
                return true;
            case 3:
                System.out.println("Trapecio -> A = (base + baseM)x altura/2");
                solicitarDato("la base menor");
                base = capturarDatoFloat();
                solicitarDato("la base mayor");
                baseM = capturarDatoFloat();
                solicitarDato("la altura");
                altura = capturarDatoFloat();
                calcularArea(opcion, base, altura, baseM);
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

    private static void calcularArea(int opcion, float base, float altura, float baseM){
        switch(opcion){
            case 1: 
                System.out.println("El área del rectángulo es " + (base*altura));
                break;
            case 2:
                System.out.println("El área del triángulo es " + (base*altura)/2);
                break;
            case 3:
                System.out.println("El área del trapecio es " + (base+baseM)*altura/2);
                break;
        }
    }
 
}
