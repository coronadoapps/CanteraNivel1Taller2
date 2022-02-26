package com.sofka.Punto2;

import java.util.Scanner;

public class Punto2 {

    private int edad;

    public void Punto2(){
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
        if(edad < 18){
            System.out.println("Usted aún es un niño(a).");
        }
    }

    public void Enunciado(){
        System.out.println("2. Realizar un programa en el cual se solicite la edad de una persona. Si la persona es menor a 18 años, deberá mostrar en pantalla: Usted aún es un niño(a).");
    }
    
}
