package org.iesalandalus.programacion.reyajedrez;

import org.iesalandalus.programacion.reyajedrez.modelo.Rey;

import javax.naming.OperationNotSupportedException;

public class MainApp {
    public static void main(String[] args) {

        Rey rey1;

        private static void ejecutarOpcion(int opcion){
            switch(opcion){
                case 1:
                     rey1 = new Rey();
                    System.out.println(rey1);
                case 2:
                    // Aqui me daba un error, tuve que ir a consola y modificar el método de la opcion de menu y quitar el parametro que tenia.
                    rey1 = new Rey(Consola.elegirOpcion());
                case 3:
                    try {
                        rey1.mover(Consola.elegirDireccion());
                    }catch (OperationNotSupportedException e){
                        System.out.println(e.getMessage());
                    }
                case 4:
                    Consola.despedirse();
                default:
                    Consola.despedirse();
            }
        }

    }
}
