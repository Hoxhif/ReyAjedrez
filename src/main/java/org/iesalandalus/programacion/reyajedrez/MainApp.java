package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Color;
import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;
import java.sql.SQLOutput;

public class MainApp {

        public static void main (String[]args){
        // No podemos poner los métodos dentro del método main porque nos da errores.
        int opcion;

        do {
            //aqui me daba error por lo que tuve que cambiar los parametros del metodo elegirOpcionMenu en la consola.
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 4);
    }
        private static Rey reyBlanco;
        private static Rey reyNegro;

        // No tengo ni idea de porque tengo que poner static aqui, pero he estado investigando y poniendolo no me da errores...
        static {
        try {
            reyBlanco = new Rey(Color.BLANCO);
            reyNegro = new Rey(Color.NEGRO);
        } catch (OperationNotSupportedException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

        private static void ejecutarOpcion ( int opcion){
        switch (opcion) {
            case 1:
                crearReyDefecto();
            case 2:
                crearReyColor();
            case 3:
                mover();
            case 4:
                Consola.despedirse();
            default:
                Consola.despedirse();
        }
    }

        private static void crearReyDefecto () {
        boolean creadoCorrectamente = false;
        do {
            try {
                reyBlanco = new Rey();
                mostrarRey();
                creadoCorrectamente = true;
            } catch (OperationNotSupportedException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (creadoCorrectamente = false);

    }

        private static void crearReyColor () {
        boolean creadoCorrectamente = false;
        // Aqui me daba un error, tuve que ir a consola y modificar el método de la opcion de menu y quitar el parametro que tenia.
        do {
            try {
                Rey rey = new Rey(Consola.elegirOpcion());
                creadoCorrectamente = true;
            } catch (OperationNotSupportedException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (creadoCorrectamente = false);

    }

        private static void mover () {
        boolean movimientoCorrecto = false;
        // Aquí he creado un atributo de tipo Color para obtener el valor de Consola.elegirOpcion(); (No se ni si funciona)
        do {
            try {
                Color opcion = Consola.elegirOpcion();
                if (opcion == Color.BLANCO) {
                    reyBlanco.mover(Consola.elegirDireccion());
                    // Hacemos un sout de rey para que se muestre de nuevo la posicion y demás.
                    mostrarRey();
                    movimientoCorrecto = true;
                } else if (opcion == Color.NEGRO) {
                    reyNegro.mover(Consola.elegirDireccion());
                    // Hacemos un sout de rey para que se muestre de nuevo la posicion y demás.
                    mostrarRey();
                    movimientoCorrecto = true;
                }
            } catch (OperationNotSupportedException e) {
                System.out.println(e.getMessage());
            }
        } while (movimientoCorrecto = false);
    }

        private static void mostrarRey () {
        // Como quiere que indiquemos que si no esta creado aun nos avise, lanzamos excepcion.
        if (reyBlanco == null)
            throw new NullPointerException("El rey no esta creado");
        else if (reyNegro == null)
            throw new NullPointerException("El rey no esta creado");
        System.out.println(reyBlanco);
        System.out.println(reyNegro);

    }


    }

