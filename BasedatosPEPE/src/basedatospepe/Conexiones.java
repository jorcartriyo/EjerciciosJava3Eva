/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatospepe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Router1
 */
public class Conexiones {
    private Connection con;
    private int nr;
    private ResultSet rs;
    private Statement st;
    private String inssql;

    
    public Connection Conectar(){       
        try{            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TEMA9","TEMA9");           
            if(con!=null){
                System.out.println("Conectado");
            }
        }
        catch(SQLException e){
            System.out.println("Se ha producido un error al"
                    + " establecer la conexión con la base de datos");            
        } 
        return con;
    }
    
    public Connection desconectar(){                
        try{                
            if(con!=null){
                con.close();
                System.out.println("Desconectado");       
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    //El sout es para comprobar si la sentencia squl es correcta comentar antes el st y
    //el nr y después comentar el sout.
    public int insertarCliente(String cCodFam, String CDesFam){
        if (con== null) System.out.println("ERROR CONEXION"); 
        try{ 
            inssql = "INSERT INTO FAMILIAS VALUES(name,capacity) VALUES(?,?)";
            inssql = "INSERT INTO FAMILIAS VALUES(" + "'" + cCodFam + "'" + "," + "'"  + CDesFam + "'" + ")";        
            System.out.println(inssql);
            st = con.createStatement(); 
            nr = st.executeUpdate(inssql);
        }
        catch(SQLException e){
            System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");            
        }  
        return nr;
    }
    
    public int borrarCliente(String cCodFam, String CDesFam){
        if (con== null) System.out.println("ERROR CONEXION");
        try{  
//        System.out.println(inssql);
        inssql = "DELETE FROM FAMILIAS WHERE cCodFam = " + "'" + cCodFam + "'";        

        st = con.createStatement(); 
        nr = st.executeUpdate(inssql);
        }
        catch(SQLException e){
            System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");            
        }  
        return nr;
    }
        
        //En este metodo se le pasa directamente el cliente para elegir el campo que
        //queramos.
    public int Cliente(){
        if (con== null) System.out.println("ERROR CONEXION");  
        try{
            inssql = "DELETE CLIENTES WHERE cCodCli= c.cod";        
//          System.out.println(inssql);
            st = con.createStatement(); 
            nr = st.executeUpdate(inssql);
        }
        catch(SQLException e){
            System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");            
        }  
        
        return nr;
    }
    public void listarClientes(){
        if (con== null) System.out.println("ERROR CONEXION");
        try{    
            inssql = "SELECT * FROM CLIENTES";           
            st = con.createStatement(); 
            rs = st.executeQuery(inssql);
            while (rs.next()){            
            System.out.println(rs.getString(nr));  
            }
        }    
            catch(SQLException e){
                System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");            
            } 
        }
        
        //Metodo para devolver un resultset
        public ResultSet listarClientesProv(String provincia){
            if (con== null) System.out.println("ERROR CONEXION");  
            try{
                inssql = "SELEC * FROM CLIENTES where provincia = ";                       
                st = con.createStatement(); 
                rs = st.executeQuery(inssql);
                while (rs.next()){            
                System.out.println(rs.getString(nr));  
                }
            }
            catch(SQLException e){
                System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");            
        } 
            return rs;
        }
        
                //Metodo para ahora
        public void listarClientesProv2(String provincia){            
            if (con== null) System.out.println("ERROR CONEXION");  
            try{   
                inssql = "SELEC * FROM CLIENTES where provincia = ";           
                st = con.createStatement(); 
                rs = st.executeQuery(inssql);
                while (rs.next()){            
                System.out.println(rs.getString(nr));  
                }
            }
            catch(SQLException e){
                System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");            
            }      
        }
    
            
}
