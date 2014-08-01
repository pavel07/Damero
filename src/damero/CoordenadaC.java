/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damero;

/**
 *
 * @author PavelNote
 */
public class CoordenadaC extends Ficha{
    
    public CoordenadaC(int fila, int columna){
        super(fila,columna);
    }
    
    @Override
    protected boolean mover(int fila, int columna) {
        return false;
    }

    @Override
    protected boolean capturar(int fila, int columna) {
        return false;
    }
    
    @Override
    protected void imprimir(){
        System.out.print(columna);
    }
}
