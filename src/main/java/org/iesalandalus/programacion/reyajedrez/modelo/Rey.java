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


    /* He tenido un error muy pesado en el test durante mucho tiempo que no sabia solucionar
    * al final usando chatGPT y haciendo miles de preguntas y haciendo miles de modificaciones
    * (para luego terminar muy cerca de lo que ya estaba haciendo yo) el problema era que
    * yo en los metodos de setColor y setPosicion estaba lanzando una excepcion OperationNonSuportedException
    * y luego en los constructores en el bloque de try catch estaba intentado captar un IllegalArgumentException
    * y entonces cambie eso, tambien otro problema que tenia es que la manera que tenia de tratar la excepcion era
    * volviendo a lanzar hacia arriba la excepcion en vez de simplmente añadir un e.getMessage.  */

    public Rey() {
        try {
            setColor(Color.BLANCO);
            setPosicion(new Posicion(1, 'e'));
            this.totalMovimientos= 0;
        }catch (OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }

    /* Constructor con parametros que dependiendo de el color, tendrá una posicion u otra.
    * Aqui básicamente lo que hemos hecho es decirle que se ponga como color el que le digamos
    * y entonces, dependiendo del color elegido, tomara una posicion u otra.*/

    public Rey(Color color) {

        try {

            setColor(color);
            if (color == Color.BLANCO) {
                setPosicion(new Posicion(1, 'e'));
            }
            else if(color == Color.NEGRO){
                setPosicion(new Posicion(8, 'e'));
            }
            this.totalMovimientos=0;
        }catch(OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }

    public Color getColor() {
        return color;
    }

    // Aqui he declarado que si el color es diferente de blanco o de negro saltara una excepcion.
    // Aunque creo que no hace falta porque en el enumerado solo hay esas dos opciones
    private void setColor(Color color) throws OperationNotSupportedException {
        if(color == null)
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        /*
        if (color != Color.BLANCO || color != Color.NEGRO)
            throw new IllegalArgumentException("El color no puede ser diferente de Blanco o Negro"); */
        try {
            this.color = color;
        }catch(IllegalArgumentException e){
            throw new OperationNotSupportedException(e.getMessage());
        }
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
        try {
            switch (direccion) {
                case NORTE:
                    try {
                        setPosicion(new Posicion(posicion.getFila() + 1, posicion.getColumna()));
                        totalMovimientos++;
                    } catch (IllegalArgumentException e) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                    }
                    break;
                case SUR:
                    try {
                        setPosicion(new Posicion(posicion.getFila() - 1, posicion.getColumna()));
                        totalMovimientos++;
                    } catch (IllegalArgumentException e) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                    }
                    break;
                case ESTE:
                    try {
                        setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + 1)));
                        totalMovimientos++;
                    } catch (IllegalArgumentException e) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                    }
                    break;
                case OESTE:
                    try {
                        setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - 1)));
                        totalMovimientos++;
                    } catch (IllegalArgumentException e) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                    }
                    break;
                case NORESTE:
                    try {
                        setPosicion(new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 1)));
                        totalMovimientos++;
                    } catch (IllegalArgumentException e) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                    }
                    break;
                case NOROESTE:
                    try {
                        setPosicion(new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() - 1)));
                        totalMovimientos++;
                    } catch (IllegalArgumentException e) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                    }
                    break;
                case SURESTE:
                    try {
                        setPosicion(new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() + 1)));
                        totalMovimientos++;
                    } catch (IllegalArgumentException e) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                    }
                    break;
                case SUROESTE:
                    try {
                        setPosicion(new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() - 1)));
                        totalMovimientos++;
                    } catch (IllegalArgumentException e) {
                        throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                    }
                    break;
                case ENROQUE_CORTO:
                    try {
                        /* Esto es porque en el enroque corto, lo que hace es irse hacia el este 2 pasos. */
                        // Llamada al comprobar enroque si se puede o no.
                        comprobarEnroque();
                        setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + 2)));
                    } catch (OperationNotSupportedException | IllegalArgumentException e) {
                        /* Aquí el test me esta todo el rato dando el mismo error de mensaje en la excepción, no entiendo muy bien porqué */
                        System.out.println(e.getMessage());
                    }
                    break;
                case ENROQUE_LARGO:
                    try {
                        // Llamada al comprobar enroque si se puede o no.
                        comprobarEnroque();
                        setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - 2)));
                    } catch (OperationNotSupportedException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }catch(IllegalArgumentException | OperationNotSupportedException e){
            System.out.println(e.getMessage());
            throw new OperationNotSupportedException();
        }

    }

    // Comprobación de que se puede hacer el enroque corto o largo:
    private void comprobarEnroque() throws OperationNotSupportedException{
        if(this.totalMovimientos!=0)
            throw new OperationNotSupportedException("ERROR: El rey ya se ha movido antes.");
        else if (this.totalMovimientos>0)
            throw new OperationNotSupportedException("ERROR: El rey no está en su posición inicial.");
    }

    @Override
    public String toString() {

        return "color="+color+", posicion=(fila="+(posicion.getFila())+", columna="+posicion.getColumna()+")";
    }
}
