/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damero;

/**
 *
 * @author PavelNote
 */
public abstract class Ficha {
    protected String color;
    protected int fila;
    protected int columna;
    protected int filaactual;
    protected int columnaactual;
    
    public Ficha(String color, int filaactual, int columnaactual){
        this.color = color;
        this.filaactual = filaactual;
        this.columnaactual = columnaactual;
    }
    
    public Ficha(int fila, int columna){
        this.fila=fila;
        this.columna=columna;
    }
    
    public Ficha(){}
     
    protected abstract boolean mover(int fila, int columna);
    
    protected abstract boolean capturar(int fila, int columna);
    
    protected void imprimir(){
        System.out.print(color);
    }
}
