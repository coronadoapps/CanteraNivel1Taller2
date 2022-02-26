package com.sofka.Punto1;

import java.util.Scanner;

public class Punto1 {

    private int edad;

    public void Punto1(){
        Enunciado();

        solicitarDato("su edad");
        edad = capturarDatoInt();
        mostrarMensaje(edad);
    }

    public void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private int capturarDatoInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private void mostrarMensaje(int edad){
        if(edad >= 18){
            System.out.println("Usted es mayor de edad.");
        }
    }

    public void Enunciado(){
        System.out.println("1. Realizar un programa en el cual se solicite la edad de una persona. Si la persona es mayor o igual a 18 años, deberá mostrar en pantalla: Usted es mayor de edad.");
    }
    
}
