package org.iesalandalus.programacion.reyajedrez.modelo;

public class Rey {

    private int totalMovimientos;
    private  Color color;
    private Posicion posicion;

    public Color getColor() {
        return color;
    }

    // Aqui he declarado que si el color es diferente de blanco o de negro saltara una excepcion.
    // Aunque creo que no hace falta porque en el enumerado solo hay esas dos opciones
    private void setColor(Color color) {
        if(color == null)
            throw new NullPointerException("El color no puede ser nulo");
        if (color != Color.BLANCO || color != Color.NEGRO)
            throw new IllegalArgumentException("El color no puede ser diferente de Blanco o Negro");
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    // Aqui creo que no hay que poner la excepccion de si se pone una posicion invalidad
    // Porque eso ya lo estamos controlando en la clase Posicion.
    // Solo controlamos si es una posicion Nula.
    private void setPosicion(Posicion posicion) {
        if (posicion == null)
            throw new NullPointerException("La posicion no puede ser Nula");
        this.posicion = posicion;
    }



}
