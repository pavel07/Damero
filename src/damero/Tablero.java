/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damero;
import java.util.Scanner;

/**
 *
 * @author PavelNote
 */
public class Tablero {
    
    public static Ficha tablero[][];
    Scanner lea = new Scanner(System.in);
    
    public Tablero(){
        tablero = new Ficha[9][9];
        llenar_coordenadas();
        llenar_tablero();
    }
    
    private void llenar_coordenadas(){
        //COORDENADAS DE LAS FILAS
        for(int f=1;f<=8;f++){
            tablero[f-1][0]=new CoordenadaF(tablero.length-(f),0);
        }
        tablero[8][0]=new CoordenadaF(' ');
        
        //COORDENADAS DE LAS COLUMNAS
        for(int c=1;c<=8;c++){
            tablero[8][c]=new CoordenadaC(8,c);
        }
    }
    
    private void llenar_tablero(){
        //FICHAS DEL DAMERO: DAMAS NEGRAS Y DAMAS BLANCAS
        for(int fila=1;fila<=8;fila++){
            String color = "@";
            if(fila>=6)
                color = "O";
            for(int columna=1;columna<=8;columna++){
                if(fila != 4 & fila !=5 ){
                    if(fila%2==0){
                        if(columna%2!=0)
                            tablero[fila-1][columna]= new Damas(color,fila-1,columna);
                    }else{
                        if(columna%2==0)
                            tablero[fila-1][columna] = new Damas(color, fila-1,columna);
                    }
                }
            }
        }
    }
    
    public void imprimir_tablero(){
        for(int fila=0;fila<tablero.length;fila++){
            for(Ficha ficha:tablero[fila]){
                if(ficha==null){
                    System.out.print("--- ");
                }else{
                    ficha.imprimir();
                    System.out.print("  ");
                    if(ficha instanceof CoordenadaC || ficha instanceof Damas){
                        System.out.print(" ");
                    }
                }
            }
            System.out.print("\n");
        }
    }

    public boolean mover_pieza(int fila_actual, int columna_actual, int nueva_fila, int nueva_columna){
        if(!(fila_actual>0 && fila_actual <= 8 
                && columna_actual > 0 && columna_actual <=8
                && nueva_fila > 0 && nueva_columna <=8
                && nueva_columna > 0 && nueva_columna <=8))
            return false;
        
        int fila_actual_arreglo = getFila(fila_actual);
        
        if((tablero[fila_actual_arreglo][columna_actual].color.equals("O") && Damero.turno!=1) ||
                (tablero[fila_actual_arreglo][columna_actual].color.equals("@") && Damero.turno!=2))
            return false;
        
        if(tablero[fila_actual_arreglo][columna_actual] instanceof Damas){
            int nueva_fila_arreglo = getFila(nueva_fila);
            if(tablero[nueva_fila_arreglo][nueva_columna]==null){//MOVER UNA FICHA
                boolean move = tablero[fila_actual_arreglo][columna_actual].mover(nueva_fila_arreglo, nueva_columna);
                if(move){
                    tablero[nueva_fila_arreglo][nueva_columna] = new Damas(tablero[fila_actual_arreglo][columna_actual].color, 
                            nueva_fila_arreglo, nueva_columna);
                    tablero[fila_actual_arreglo][columna_actual] = null;
                    return true;
                }else{//EN CASO DE CAPTURA DE UNA FICHA CONTRARIA
                    boolean captura = tablero[fila_actual_arreglo][columna_actual].capturar(nueva_fila_arreglo, nueva_columna);
                    if(captura){
                       tablero[nueva_fila_arreglo][nueva_columna] = new Damas(tablero[fila_actual_arreglo][columna_actual].color, 
                               nueva_fila_arreglo, nueva_columna);
                       tablero[fila_actual_arreglo][columna_actual] = null;
                       if(Damero.turno == 1){
                           Damero.piezasnegras-=1;
                       }else{
                           Damero.piezasblancas-=1;
                       }
                       return true; 
                    }
                }
            }   
        }
        return false;
    }
    
    private int getFila(int fila_actual){//OBTENER LA POSICION REAL DE UNA FILA EN EL ARREGLO
        switch(fila_actual){
            case 1:
                return 7;
            case 2:
                return 6;
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
                return 3;
            case 6:
                return 2;
            case 7:
                return 1;
            case 8:
                return 0;
            default:
                return 8;
        }
    }
}
