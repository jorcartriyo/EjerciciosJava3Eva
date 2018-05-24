/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatospepe;
/**
 *
 * @author Router1
 */
import java.sql.*;

public class BasedatosPEPE {
     
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Conexiones conect = new Conexiones();
      
      conect.Conectar();
      
      System.out.println("Se han insertado " + conect.insertarCliente("af", "fff") + " filas");
      System.out.println("Se han borrado " + conect.borrarCliente("af", "fff") + " filas");
      conect.listarClientes();
      conect.desconectar();
      
        
        
    }
    
}
