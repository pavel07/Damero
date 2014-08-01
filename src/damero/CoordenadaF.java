/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damero;

/**
 *
 * @author PavelNote
 */
public class CoordenadaF extends Ficha{
    char coordenada;
    
    public CoordenadaF(int fila, int columna){
        super(fila,columna);
    }
    
    public CoordenadaF(char coordenada){
        this.coordenada = coordenada;
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
        if(this.coordenada == ' '){
            System.out.print(this.coordenada);
        }else{
            System.out.print(fila);
        }
    }
}
