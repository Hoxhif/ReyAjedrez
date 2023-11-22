package org.iesalandalus.programacion.reyajedrez.modelo;

import java.util.Objects;

public class Posicion {

    private int fila;
    private char columna;


    /* Como ya en el setter de fila y columna he puesto las excepciones,
    * ya en el constructor con parametros llamo a el setter y directamente le asocio el parametro fila y columna
    * y ya el setter internamente controla la excepcion. */
    public Posicion(int fila, char columna){
        setFila(fila);
        setColumna(columna);
    }

    // En el constructor copia debemos añadir una excepcción en caso de que se copie un objeto de tipo Posicion nulo.
    public Posicion (Posicion posicion){
        if(posicion == null)
            throw new NullPointerException("Error: La copia del objeto posición no puede ser Nula");
        setFila(posicion.getFila());
        setColumna(posicion.getColumna());
    }


    public int getFila() {
        return fila;
    }

    // Excepcion no controlada IllegalArgumentException, no se pone en el método el throws.
    private void setFila(int fila) {
        if (fila<1 || fila>8)
            throw new IllegalArgumentException("Error: No se puede poner una fila menor que 0 o mayor que 8");
        this.fila = fila;
    }

    public char getColumna() {
        return columna;
    }

    private void setColumna(char columna) {
        if(columna>='a' && columna<='h')
            this.columna = columna;
        else
            throw new IllegalArgumentException("Error: las columnas solo van desde la a a la h");
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


}
