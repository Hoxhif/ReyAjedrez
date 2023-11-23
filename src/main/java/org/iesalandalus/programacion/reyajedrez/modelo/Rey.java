package org.iesalandalus.programacion.reyajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Rey {

    private int totalMovimientos;
    private  Color color;
    private Posicion posicion;


    // En el constructor por defecto, como nos dice el enunciado, debera ser un
    /* Rey blanco que se encuentra en la posicion fila 1 columna e
    * entonces, para el color no hay problema, pero para la posicion
    * deberemos crear dentro del constructor un objeto de tipo Posicion que
    * nos permita establecer esos valores por defecto. */
    public Rey() throws OperationNotSupportedException{
        try {
            setColor(Color.BLANCO);
            setPosicion(new Posicion(1, 'e'));
        }catch (OperationNotSupportedException e){
            throw new OperationNotSupportedException(e.getMessage());
        }
    }

    /* Constructor con parametros que dependiendo de el color, tendrá una posicion u otra.
    * Aqui básicamente lo que hemos hecho es decirle que se ponga como color el que le digamos
    * y entonces, dependiendo del color elegido, tomara una posicion u otra.*/

    public Rey(Color color) throws OperationNotSupportedException{
        try {
            setColor(color);
            if (color == Color.BLANCO)
                setPosicion(new Posicion(1, 'e'));
            else setPosicion(new Posicion(8, 'e'));
        }catch(OperationNotSupportedException e){
            throw new OperationNotSupportedException(e.getMessage());
        }
    }

    public Color getColor() {
        return color;
    }

    // Aqui he declarado que si el color es diferente de blanco o de negro saltara una excepcion.
    // Aunque creo que no hace falta porque en el enumerado solo hay esas dos opciones
    private void setColor(Color color) {
        if(color == null)
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        /*
        if (color != Color.BLANCO || color != Color.NEGRO)
            throw new IllegalArgumentException("El color no puede ser diferente de Blanco o Negro"); */
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    // Aqui creo que no hay que poner la excepccion de si se pone una posicion invalidad
    // Porque eso ya lo estamos controlando en la clase Posicion.
    // Solo controlamos si es una posicion Nula.
    private void setPosicion(Posicion posicion) throws OperationNotSupportedException {
        if (posicion == null)
            throw new NullPointerException("La posicion no puede ser Nula");
        try {
            this.posicion = posicion;
        }catch(IllegalArgumentException e){
            throw new OperationNotSupportedException(e.getMessage());
        }
    }

    public void mover(Direccion direccion) throws OperationNotSupportedException{
        if (direccion == null)
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        switch (direccion){
            case NORTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() + 1, posicion.getColumna()));
                    totalMovimientos++;
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case SUR:
                try {
                    setPosicion(new Posicion(posicion.getFila() - 1, posicion.getColumna()));
                    totalMovimientos++;
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case ESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + 1)));
                    totalMovimientos++;
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case OESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - 1)));
                    totalMovimientos++;
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case NORESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 1)));
                    totalMovimientos++;
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case NOROESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() - 1)));
                    totalMovimientos++;
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case SURESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() + 1)));
                    totalMovimientos++;
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case SUROESTE:
                try {
                    setPosicion(new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() - 1)));
                    totalMovimientos++;
                }catch(IllegalArgumentException e){
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                }
                break;
            case ENROQUE_CORTO:
                try {
                    /* Esto es porque en el enroque corto, lo que hace es irse hacia el este 2 pasos. */
                    // Llamada al comprobar enroque si se puede o no.
                        comprobarEnroque();
                        setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + 2)));
                }catch(OperationNotSupportedException | IllegalArgumentException e){
                    /* Aquí el test me esta todo el rato dando el mismo error de mensaje en la excepción, no entiendo muy bien porqué */
                    throw new OperationNotSupportedException(e.getMessage());
                }
                break;
            case ENROQUE_LARGO:
                try {
                    // Llamada al comprobar enroque si se puede o no.
                        comprobarEnroque();
                        setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - 2)));
                }catch(OperationNotSupportedException | IllegalArgumentException e){
                    throw new OperationNotSupportedException(e.getMessage());
                }
                break;
        }

    }

    // Comprobación de que se puede hacer el enroque corto o largo:
    private void comprobarEnroque() throws OperationNotSupportedException{
        Rey reytest1 = new Rey(Color.BLANCO);
        Rey reytest2 = new Rey(Color.NEGRO);
        if(reytest1.totalMovimientos!=0 || reytest2.totalMovimientos!=0)
            throw new OperationNotSupportedException("ERROR: El rey ya se ha movido antes.");
        else if(reytest1.totalMovimientos>0 || reytest2.totalMovimientos>0)
            throw new OperationNotSupportedException("ERROR: El rey no está en su posición inicial.");
    }

    @Override
    public String toString() {
        return "color="+color+", posicion=(fila="+(posicion.getFila())+", columna="+posicion.getColumna()+")";
    }
}
