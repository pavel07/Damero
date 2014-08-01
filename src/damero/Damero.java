/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damero;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author PavelNote
 */
public class Damero {
    static int turno = 1;
    static int piezasblancas = 12;
    static int piezasnegras = 12;
    
    public static void main(String[] args) {
        Scanner lea= new Scanner(System.in);
        int fila, columna, nueva_fila, nueva_columna;
        
        Tablero tablero = new Tablero();
        do{
            System.out.print("PRESIONE LA TECLA CERO (0) PARA FINALIZAR LA PARTIDA....\n");
            System.out.print("DAMAS BLANCAS: " +piezasblancas+" || DAMAS NEGRAS: " + piezasnegras +"\n"
                    + "==========================================\n");
            tablero.imprimir_tablero();
            System.out.print("TURNO " + (turno==1?"DAMAS BLANCAS":"DAMAS NEGRAS"));
            System.out.println("\nMOVER DAMA==>");
            
            try{
                System.out.print("FILA: ");
                fila=lea.nextInt();
                if(fila==0)
                    break;
                System.out.print("COLUMNA: ");
                columna=lea.nextInt();
                if(columna==0)
                    break;
                System.out.print("A ==>\n");
                System.out.print("NUEVA FILA: ");
                nueva_fila=lea.nextInt();
                if(nueva_fila==0)
                    break;
                System.out.print("NUEVA COLUMNA: ");
                nueva_columna=lea.nextInt();
                if(nueva_columna==0)
                    break;
                
                boolean move_done = tablero.mover_pieza(fila, columna, nueva_fila, nueva_columna);
                cls(0);//IMPRIME 500 LINEAS VACIAS
                
                if(move_done==false){
                    System.out.print("\nMOVIMIENTO INVALIDO\n---------------------------------------\n");
                }else{
                    if(turno==1){
                        turno=2;
                    }else{
                        turno=1;
                    }
                }
            }catch(InputMismatchException e){
                cls(0);//IMPRIME 500 LINEAS VACIAS
                System.out.print("\nTIPO DE DATO INCORRECTO: INGRESE UN NUMERO!\n---------------------------------------\n");
                lea.next();
            }
            
        }while(piezasblancas>0 && piezasnegras>0);// FIN DEL CICLO PRINCIPAL
        
        if(piezasblancas>piezasnegras){
            System.out.print("DAMAS BLANCAS HA GANADO LA PARTIDA\n");
        }else if(piezasblancas<piezasnegras){
            System.out.print("DAMAS NEGRAS HA GANADO LA PARTIDA\n");
        }else{
            if(turno==1){
                System.out.print("DAMAS NEGRAS HA GANADO LA PARTIDA\n");
            }else{
                System.out.print("DAMAS BLANCAS HA GANADO LA PARTIDA\n");
            }
        }
    }
    
    static int NEW_LINES=500;
    private static void cls(int init){
        if(init<NEW_LINES){
            System.out.println("");
            cls(init+1);
        }
    }
}
