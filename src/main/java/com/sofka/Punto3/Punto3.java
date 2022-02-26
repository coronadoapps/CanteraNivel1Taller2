package com.sofka.Punto3;

import java.util.Scanner;

public class Punto3 {

    private int edad;
    private String nombre, apellidos;

    public void Punto3(){
        Enunciado();

        solicitarDato("su nombre");
        nombre = capturarDatoString();
        solicitarDato("sus apellidos");
        apellidos = capturarDatoString();
        solicitarDato("su edad");
        edad = capturarDatoInt();

        mostrarMensaje(edad, nombre, apellidos);
    }

    public void solicitarDato(String dato){
        System.out.println("Por favor ingrese " + dato);
    }

    private int capturarDatoInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private String capturarDatoString(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void mostrarMensaje(int edad, String nombre, String apellidos){
        if(edad >= 18){
            System.out.println(nombre + " " + apellidos + " usted es mayor de edad, por lo tanto puede entrar a la fiesta.");
        }
        else if (edad < 18){
            System.out.println(nombre + " " + apellidos + " usted es menor de edad, por lo tanto, no puede entrar a la fiesta, por favor devuélvase a su casa.");
        }
    }

    public void Enunciado(){
        System.out.println("3. Realizar un programa en el cual se solicite el nombre, apellidos y edad de la persona. Si la persona es mayor o igual a 18 años, entonce se deberá imprimir en pantalla [Nombre completo] usted es mayor de edad, por lo tanto puede entrar a la fiesta. Si la edad de la persona es menor que 18 años, entonces, deberá imprimirse el siguiente mensaje: [Nombre completo] usted es menor de edad, por lo tanto, no puede entrar a la fiesta, por favor devuélvase a su casa.");
    }
    
}
