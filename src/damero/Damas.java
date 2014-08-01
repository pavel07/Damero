/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damero;

/**
 *
 * @author PavelNote
 */
public class Damas extends Ficha {

    public Damas(String color, int filaactual, int columnaactual){
        super(color, filaactual, columnaactual);
    }
    
    @Override
    protected boolean mover(int fila, int columna) {
        if((color.equals("@") && fila-filaactual!=1) || 
                (color.equals("O") && fila-filaactual!=-1))
            return false;
        
        if(fila>filaactual && columna!=columnaactual && color.equals("@")){
            if(Tablero.tablero[fila][columna]!=null)
                return false;         
        }else if(fila<filaactual && columna!=columnaactual && color.equals("O")){
            if(Tablero.tablero[fila][columna]!=null)
                return false;
        }else{
            if(columna==columnaactual)
                return false;
        }
        return true;
    }

    @Override
    protected boolean capturar(int fila, int columna) {
        if((color.equals("@") && fila-filaactual!=2) || 
                (color.equals("O") && fila-filaactual!=-2))
            return false;

        if(fila>filaactual && columna!=columnaactual && color.equals("@")){
            if(Tablero.tablero[fila][columna]!=null)
                return false;         
        }else if(fila<filaactual && columna!=columnaactual && color.equals("O")){
            if(Tablero.tablero[fila][columna]!=null)
                return false;
        }
        
        if(fila>filaactual){
            if(columna-columnaactual==2){
                if(Tablero.tablero[fila-1][columna-1]==null)
                    return false;
                if(Tablero.tablero[fila-1][columna-1].color.equals("@"))
                    return false;
                Tablero.tablero[fila-1][columna-1] = null;
            }else{
                if(Tablero.tablero[fila-1][columna+1]==null)
                    return false;
                if(Tablero.tablero[fila-1][columna+1].color.equals("@"))
                    return false;
                Tablero.tablero[fila-1][columna+1] = null;
            }
        }else{
            if(columna-columnaactual==2){
                if(Tablero.tablero[fila+1][columna-1]==null)
                    return false;
                if(Tablero.tablero[fila+1][columna-1].color.equals("O"))
                    return false;
                Tablero.tablero[fila+1][columna-1] = null;
            }else{
                if(Tablero.tablero[fila+1][columna+1]==null)
                    return false;
                if(Tablero.tablero[fila+1][columna+1].color.equals("O"))
                    return false;
                Tablero.tablero[fila+1][columna+1] = null;
            }
        }
        return true;
    }
 
    @Override
    protected void imprimir(){
        System.out.print(color);
    }
}
