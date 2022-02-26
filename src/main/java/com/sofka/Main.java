package com.sofka;

import java.io.IOException;
import java.util.Scanner;

import com.sofka.Punto1.Punto1;
import com.sofka.Punto2.Punto2;
import com.sofka.Punto3.Punto3;
import com.sofka.Punto4.Punto4;
import com.sofka.Punto5.Punto5;
import com.sofka.Punto6.Punto6;
import com.sofka.Punto7.Punto7;
import com.sofka.Punto8.Punto8;
import com.sofka.Punto9.Punto9;

public class Main {

    private static boolean bandera = true;
    private static int opcion;

    public static void main(String[] args) throws IOException {
        do {
            limpiarPantalla();
            menu();
            System.out.println("Selecciona el punto del taller: ");
            opcion = capturarOpcion();
            limpiarPantalla();
            bandera = evaluarOpcion(opcion);
            
        } while (bandera == true);
    }

    private static void menu() {
        System.out.println("Escoja un punto del taller #2 de Condicionales");
        System.out.println("1. Punto #1");
        System.out.println("2. Punto #2");
        System.out.println("3. Punto #3");
        System.out.println("4. Punto #4");
        System.out.println("5. Punto #5");
        System.out.println("6. Punto #6");
        System.out.println("7. Punto #7");
        System.out.println("8. Punto #8");
        System.out.println("9. Punto #9");
        System.out.println("10. Punto #10");
        System.out.println("0. Salir del taller");
    }

    private static int capturarOpcion() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static boolean evaluarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                Punto1 p1 = new Punto1();
                p1.Punto1();
                presioneCualquierTeclaParaContinuar();
                return true;
                // break;
            case 2:
                Punto2 p2 = new Punto2();
                p2.Punto2();
                presioneCualquierTeclaParaContinuar();
                return true;
            case 3:
                Punto3 p3 = new Punto3();
                p3.Punto3();
                presioneCualquierTeclaParaContinuar();
                return true;
            case 4:
                Punto4 p4 = new Punto4();
                p4.Punto4();
                presioneCualquierTeclaParaContinuar();
                return true;
            case 5:
                Punto5 p5 = new Punto5();
                p5.Punto5();
                presioneCualquierTeclaParaContinuar();
                return true;
            case 6:
                Punto6 p6 = new Punto6();
                p6.Punto6();
                presioneCualquierTeclaParaContinuar();
                return true;
            case 7:
                Punto7 p7 = new Punto7();
                p7.Punto7();
                presioneCualquierTeclaParaContinuar();
                return true;
            case 8:
                Punto8 p8 = new Punto8();
                p8.Punto8();
                presioneCualquierTeclaParaContinuar();
                return true;
            case 9:
                Punto9 p9 = new Punto9();
                p9.Punto9();
                presioneCualquierTeclaParaContinuar();
                return true;
            case 0:
                return false;
                // break;
            default:
                System.out.println("Opción incorrecta");
                System.in.read();
        }
        return true;
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
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
