package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    public static void main(String[] args) {
        // No podemos poner los métodos dentro del método main porque nos da errores.
    }

    private static Rey rey;

    private static void ejecutarOpcion(int opcion){
        switch(opcion){
            case 1:
                crearReyDefecto();
            case 2:
                crearReyColor();
            case 3:
                try {
                    rey.mover(Consola.elegirDireccion());
                }catch (OperationNotSupportedException e){
                    System.out.println(e.getMessage());
                }
            case 4:
                Consola.despedirse();
            default:
                Consola.despedirse();
        }
    }

    private static void crearReyDefecto(){
        rey = new Rey();
        System.out.println(rey);
    }

    private static void crearReyColor(){
        // Aqui me daba un error, tuve que ir a consola y modificar el método de la opcion de menu y quitar el parametro que tenia.
        rey = new Rey(Consola.elegirOpcion());
    }

}
