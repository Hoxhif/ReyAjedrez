package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    public static void main(String[] args) {
        // No podemos poner los métodos dentro del método main porque nos da errores.
        int opcion;

        do{
            //aqui me daba error por lo que tuve que cambiar los parametros del metodo elegirOpcionMenu en la consola.
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        }while(opcion != 4);
    }

    private static Rey rey;

    private static void ejecutarOpcion(int opcion){
        switch(opcion){
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

    private static void crearReyDefecto(){
        rey = new Rey();
        mostrarRey();
    }

    private static void crearReyColor(){
        // Aqui me daba un error, tuve que ir a consola y modificar el método de la opcion de menu y quitar el parametro que tenia.
        rey = new Rey(Consola.elegirOpcion());
    }

    private static void mover(){
        try {
            rey.mover(Consola.elegirDireccion());
            // Hacemos un sout de rey para que se muestre de nuevo la posicion y demás.
            mostrarRey();
        }catch (OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarRey(){

        // Como quiere que indiquemos que si no esta creado aun nos avise, lanzamos excepcion.
        if (rey == null)
            throw new NullPointerException("El rey no esta creado");
        System.out.println(rey);

    }



}
