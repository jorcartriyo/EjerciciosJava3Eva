/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2jorgeortega;

import java.util.*;

/**
 *
 * @author Router1
 */
public class Ejercicio2JorgeOrtega {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccionesComunes ac = new AccionesComunes();        
	List grupo = new ArrayList(); 
	grupo.add("Cantante");
	grupo.add("Bajista");
	grupo.add("Guitarrista");
        grupo.add("Bateria");
        System.out.println(grupo.get(0)+ " " + ac.afinarInstrumento() + " " + ac.estiramientos());
        System.out.println(grupo.get(1)+ " " + ac.afinarInstrumento() + " " + ac.estiramientos());
        System.out.println(grupo.get(2)+ " " + ac.afinarInstrumento() + " " + ac.estiramientos());
        System.out.println(grupo.get(3)+ " " + ac.afinarInstrumento() + " " + ac.estiramientos());          
	System.out.println(grupo.get(0)+ " " + ac.beberAgua()+ " ");
        System.out.println(grupo.get(1)+ " " + ac.CambiarCuerda());
        System.out.println(grupo.get(2)+ " " + ac.Escogerpua());
        System.out.println(grupo.get(3)+ " " + ac.aporrear()); 	
		
    }
    
}
