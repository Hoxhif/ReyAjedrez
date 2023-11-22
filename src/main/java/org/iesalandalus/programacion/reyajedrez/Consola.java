package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    // Constructor de la consola.
    private Consola(){

    }

    public static void mostrarMenu(){
        System.out.println("---------Selecciona una opción--------");
        System.out.println("       1- Crear un Rey (Rey por Defecto");
        System.out.println("       2- Crear un Rey (Elegir el Color");
        System.out.println("              3- Moverse");
        System.out.println("                4- Salir");
    }

    public static int elegirOpcionMenu(int opcion){
        do{
            mostrarMenu();
            opcion = Entrada.entero();
            if(opcion<1 || opcion>4)
                System.out.println("No ha seleccionado una opción válida");
        }while (opcion<1 || opcion>4);
        return opcion;
    }

    public static Color elegirOpcion(Color color){
        int opcionColor;
        do{
            System.out.println("Elige el color: ");
            System.out.println("1. Color Negro");
            System.out.println("2. Color Blanco");
            opcionColor = Entrada.entero();
        }while (opcionColor <1 || opcionColor>2);
        if (opcionColor==1)
            return Color.NEGRO;
        else return Color.BLANCO;
    }



}
