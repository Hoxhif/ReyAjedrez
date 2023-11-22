package org.iesalandalus.programacion.reyajedrez.modelo;

public enum Color {
    BLANCO="Blanco",

    NEGRO="Negro";

    // Declaramos el atributo de tipo String para que se muestren los valores, debe ser privado por que es un atributo.
    // en el enum, los atributos son final porque tenemos constantes.
    private final String cadenaAMostrar;

    // El constructor en el enum es privado tambien.
    private Color(String cadenaAMostrar){
        this.cadenaAMostrar=cadenaAMostrar;
    }




}
