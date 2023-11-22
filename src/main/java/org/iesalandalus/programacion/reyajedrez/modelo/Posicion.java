package org.iesalandalus.programacion.reyajedrez.modelo;

public class Posicion {

    private int fila;
    private char columna;


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



}
