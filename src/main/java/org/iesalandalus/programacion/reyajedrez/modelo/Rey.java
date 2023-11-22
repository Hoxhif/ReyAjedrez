package org.iesalandalus.programacion.reyajedrez.modelo;

public class Rey {

    private int totalMovimientos;
    private  Color color;
    private Posicion posicion;

    // En el constructor por defecto, como nos dice el enunciado, debera ser un
    /* Rey blanco que se encuentra en la posicion fila 1 columna e
    * entonces, para el color no hay problema, pero para la posicion
    * deberemos crear dentro del constructor un objeto de tipo Posicion que
    * nos permita establecer esos valores por defecto. */
    public Rey(){
        setColor(Color.BLANCO);
        setPosicion(new Posicion(1, 'e'));
    }

    /* Constructor con parametros que dependiendo de el color, tendrá una posicion u otra.
    * Aqui básicamente lo que hemos hecho es decirle que se ponga como color el que le digamos
    * y entonces, dependiendo del color elegido, tomara una posicion u otra.*/

    public Rey(Color color){
        setColor(color);
        if (color == Color.BLANCO)
            setPosicion(new Posicion(1,'e'));
        else setPosicion(new Posicion(8,'e'));
    }

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
