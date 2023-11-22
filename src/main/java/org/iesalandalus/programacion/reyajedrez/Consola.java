package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    // Constructor de la consola.
    private Consola() {

    }

    public static void mostrarMenu() {
        System.out.println("---------Selecciona una opción--------");
        System.out.println("       1- Crear un Rey (Rey por Defecto");
        System.out.println("       2- Crear un Rey (Elegir el Color");
        System.out.println("              3- Moverse");
        System.out.println("                4- Salir");
    }

    public static int elegirOpcionMenu(int opcion) {
        do {
            mostrarMenu();
            opcion = Entrada.entero();
            if (opcion < 1 || opcion > 4)
                System.out.println("No ha seleccionado una opción válida");
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    public static Color elegirOpcion(Color color) {
        int opcionColor;
        do {
            System.out.println("Elige el color: ");
            System.out.println("1. Color Negro");
            System.out.println("2. Color Blanco");
            opcionColor = Entrada.entero();
        } while (opcionColor < 1 || opcionColor > 2);
        if (opcionColor == 1)
            return Color.NEGRO;
        else return Color.BLANCO;
    }

    public static void mostrarMenuDirecciones() {
        System.out.println("---------Selecciona una opción--------");
        System.out.println("              1- NORTE");
        System.out.println("               2- SUR");
        System.out.println("              3- ESTE");
        System.out.println("              4- OESTE");
        System.out.println("              5- NORESTE");
        System.out.println("              6- NOROESTE");
        System.out.println("              7- SURESTE");
        System.out.println("              8- SUROESTE");
        System.out.println("              9- ENROQUE CORTO");
        System.out.println("              10- ENROQUE LARGO");

    }

    public static Direccion elegirDireccion() {
        int opcionDireccion;
        do {
            mostrarMenuDirecciones();
            opcionDireccion = Entrada.entero();
        } while (opcionDireccion < 1 || opcionDireccion > 10);

        switch (opcionDireccion) {
            case 1:
                return Direccion.NORTE;

            case 2:
                return Direccion.SUR;

            case 3:
                return Direccion.ESTE;

            case 4:
                return Direccion.OESTE;

            case 5:
                return Direccion.NORESTE;

            case 6:
                return Direccion.NOROESTE;

            case 7:
                return Direccion.SURESTE;

            case 8:
                return Direccion.SUROESTE;

            case 9:
                return Direccion.ENROQUE_CORTO;

            case 10:
                return Direccion.ENROQUE_LARGO;
            default:
                return Direccion.NORTE;
        }
    }
}

