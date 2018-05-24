/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torreshanoi;

/**
 *
 * @author Router1
 */
import java.util.*; 
public class TorresHanoi {

    /**
     * @param args the command line arguments
     */

    public static void Torres(int torres, int origen,  int aux, int destino){
        if(torres==1){
            System.out.println("muevo el disco de la torre " + origen + " a la torre " + destino);
        }
        else{
            Torres(torres-1, origen, destino, aux);
            System.out.println("muevo el disco de la torre "+ origen + " a la torre " + destino);
            Torres(torres-1, aux, origen, destino);
        }
    }

    public static void main(String[] args) {          
        Scanner entrada = new Scanner(System.in);
        int torres;
        System.out.println("¿Cuantos discos vas a utilizar?: ");
        torres = entrada.nextInt();
        Torres(torres,1,2,3);  
    }
    
}
