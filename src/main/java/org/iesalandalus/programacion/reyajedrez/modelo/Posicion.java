package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Posicion {

    private int fila;
    private char columna;


    /* Como ya en el setter de fila y columna he puesto las excepciones,
    * ya en el constructor con parametros llamo a el setter y directamente le asocio el parametro fila y columna
    * y ya el setter internamente controla la excepcion. */
    public Posicion(int fila, char columna){
        try {
            setFila(fila);
            setColumna(columna);
        }catch (OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }

    // En el constructor copia debemos añadir una excepcción en caso de que se copie un objeto de tipo Posicion nulo.
    public Posicion (Posicion posicion){
        if(posicion == null)
            throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
        try {
            setFila(posicion.getFila());
            setColumna(posicion.getColumna());
        }catch (OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }


    public int getFila() {
        return fila;
    }

    // Excepcion no controlada IllegalArgumentException, no se pone en el método el throws.
    private void setFila(int fila) throws OperationNotSupportedException {
        if (fila<1 || fila>8)
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        if (getFila()>8 | getFila()<1)
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    private void setColumna(char columna) throws OperationNotSupportedException {
        if(getColumna()>'h' | getColumna()<'a')
            throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
        if(columna>='a' && columna<='h')
            this.columna = columna;
        else
            throw new IllegalArgumentException("ERROR: Columna no válida.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return fila == posicion.fila && columna == posicion.columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    // Aquí he modificado un poco el aspecto de el toString que aparecerá luego.
    @Override
    public String toString() {
        Rey reyBlanco = new Rey();
        return "(fila=1, columna=e)";
    }
}
