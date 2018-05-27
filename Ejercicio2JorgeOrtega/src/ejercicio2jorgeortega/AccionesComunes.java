/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2jorgeortega;

/**
 *
 * @author Router1
 */
public class AccionesComunes extends AccionesParticulares{

    public AccionesComunes() {
     
    }
  
    public String afinarInstrumento(){
        String[] notas = {"Do", "RE", "MI","FA","SOL","LA","SI"};
        int n =(int) (Math.random()*7);        
        return notas[n];
    }
    
    public String estiramientos(){
        return "Se ha estrirado correctamente";
    }
    
}
