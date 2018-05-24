
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 *
 * @author Router1
 */
public class DBControlador implements Initializable {
    private Connection con;
    private int nr;
    private ResultSet rs;
    private Statement st;
    private String inssql;
    @FXML
    private Label label;
    @FXML
    private TextField camp1;
    @FXML
    private TextField camp2; 
    @FXML
    private TextField camp3; 
    @FXML
    private TextField camp4; 
    @FXML
    private TextField estado;
    @FXML  
    private TextArea lista;    
    private String cCodFam;  
    private String cDesFam;
    private String cCodFamNuevo;  
    private String cDesFamNuevo;   
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    Alert alertE = new Alert(Alert.AlertType.ERROR);

    public DBControlador() {
        cCodFam = "";
        cDesFam = ""; 
        cCodFamNuevo = "";
        cDesFamNuevo = ""; 
    }
    
    @FXML
    private Connection Conectar(){       
        try{            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TEMA9","TEMA9");           
            if(con!=null){
                System.out.println("Conectado");
                        alert.setTitle("");
			alert.setHeaderText("");
			alert.setContentText("CONECTADO A LA BASE DE DATOS TEMA9");	
			alert.showAndWait();
                        estado.setText("CONECTADO");               
            }
        }
        catch(SQLException e){
            System.out.println("Se ha producido un error al"
                    + " establecer la conexión con la base de datos");            
        }  
        return con;
    }
    @FXML
    private Connection desconectar(){                
        try{                
            if(con!=null){
                con.close();
                System.out.println("Desconectado"); 
                alert.setTitle("");
                alert.setHeaderText("");
		alert.setContentText("DESCONECTADO DE LA BASE DE DATOS TEMA9");	
                alert.showAndWait();
                estado.setText("DESCONECTADO");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    public void asignaVariables() {
        String camp1 = this.camp1.getText();
        String camp2 = this.camp2.getText();
//	if (camp1.isEmpty())
//            cCodFam = "";
//	else           
             camp1 = cCodFam;			
//	if (camp2.isEmpty())
//            cDesFam = "";
//	else
            camp2 = cDesFam;
	}    
    @FXML
    private void insertarCliente(){      

        try{
            cCodFam = this.camp1.getText();
            cDesFam = this.camp2.getText(); 
//          inssql = "INSERT INTO FAMILIAS VALUES(name,capacity) VALUES(?,?)";
            inssql = "INSERT INTO FAMILIAS VALUES(" + "'" + cCodFam + "'" + "," + "'"  + cDesFam + "'" + ")";        
            System.out.println(inssql);
            st = con.createStatement(); 
            nr = st.executeUpdate(inssql);
            if (nr>0){
                alert.setTitle("");
                alert.setHeaderText("");
                alert.setContentText("SE HAN INSETADO CON EXITO " + nr + " FILAS");	
                alert.showAndWait();
            }
            else{
                alert.setTitle("");
                alert.setHeaderText("");
                alert.setContentText("LOS CAMPOS ESTAN VACIOS ");	
                alert.showAndWait();   
            }
        }
        catch(SQLException e){
            if (con== null){
                System.out.println("ERROR CONEXION");
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("DESCONECTADO");	
                alertE.showAndWait();
        } 
            else{
                System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");                  
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("ERROR AL INSERTAR DATOS");	
                alertE.showAndWait();
                }
        }  

    }
    
    @FXML
    private void borrarCliente(){      

        try{
            cCodFam = this.camp1.getText();
            cDesFam = this.camp2.getText();
            if (cCodFam.isEmpty()) inssql = "DELETE FROM FAMILIAS WHERE cDesFam = " + "'" + cDesFam + "'"; 
            if (cDesFam.isEmpty()) inssql = "DELETE FROM FAMILIAS WHERE cCodFam = " + "'" + cCodFam + "'";               
            System.out.println(inssql);
            st = con.createStatement(); 
            nr = st.executeUpdate(inssql);
            if (nr>0){
            alert.setTitle("");
            alert.setHeaderText("");
            alert.setContentText("SE HAN BORRADO CON EXITO " + nr + " FILAS");	
            alert.showAndWait();
            }
            else{                
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("NO EXISTE EL CLIENTE ");	
                alertE.showAndWait();
            }
        }
        catch(SQLException e){
            if (con== null){
                System.out.println("ERROR CONEXION");
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("DESCONECTADO");	
                alertE.showAndWait();
        } 
            else{
                System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");                  
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("ERROR AL INSERTAR DATOS");	
                alertE.showAndWait();
                }
        }  

    }
    @FXML   
    public void listarClientes(){
        cCodFam = this.camp1.getText();
        cDesFam = this.camp2.getText();
        if (con== null) System.out.println("ERROR CONEXION");
        try{    
            inssql = "SELECT * FROM FAMILIAS";  
            System.out.println(inssql);
            st = con.createStatement(); 
            rs = st.executeQuery(inssql);
            while (rs.next()){
                lista.appendText(rs.getString("cCodFam")+ "                 " + rs.getString("CDESFAM") + "\n");
                System.out.println(rs.getString("cCodFam")+ "                 " + rs.getString("CDESFAM"));  
            }
        }    
            catch(SQLException e){
                System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");            
            } 
        }
    private void Modifica(){      

        try{
            cCodFam = this.camp1.getText();
            cDesFam = this.camp2.getText(); 
            if (cCodFam.isEmpty()) inssql = "DELETE FROM FAMILIAS WHERE cDesFam = " + "'" + cDesFam + "'"; 
            if (cDesFam.isEmpty()) inssql = "DELETE FROM FAMILIAS WHERE cCodFam = " + "'" + cCodFam + "'";        
            System.out.println(inssql);
            st = con.createStatement(); 
            nr = st.executeUpdate(inssql);
            if (nr>0){
                alert.setTitle("");
                alert.setHeaderText("");
                alert.setContentText("SE HAN INSETADO CON EXITO " + nr + " FILAS");	
                alert.showAndWait();
            }
            else{
                alert.setTitle("");
                alert.setHeaderText("");
                alert.setContentText("LOS CAMPOS ESTAN VACIOS ");	
                alert.showAndWait();   
            }
        }
        catch(SQLException e){
            if (con== null){
                System.out.println("ERROR CONEXION");
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("DESCONECTADO");	
                alertE.showAndWait();
        } 
            else{
                System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");                  
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("ERROR AL INSERTAR DATOS");	
                alertE.showAndWait();
                }
        }  

    }
    @FXML
    private void modificarCliente(){      
        try{
            cCodFam = this.camp1.getText();
            cDesFam = this.camp2.getText();
            cCodFamNuevo = this.camp3.getText();
            cDesFamNuevo = this.camp4.getText();
            if (cCodFam.isEmpty() && cCodFamNuevo.isEmpty() ) inssql = "UPDATE FAMILIAS SET cDesFam " + "=" + "'" + cDesFamNuevo + "'"+ " WHERE cDesFam = " + "'" + cDesFam + "'"  ;
            if (cDesFam.isEmpty() && cCodFamNuevo.isEmpty() ) inssql = "UPDATE FAMILIAS SET cDesFam " + "=" + "'" + cDesFamNuevo + "'"+ " WHERE cCodFam = " + "'" + cCodFam + "'"  ;
            if (cDesFam.isEmpty() && cDesFamNuevo.isEmpty() ) inssql = "UPDATE FAMILIAS SET cCodFam " + "=" + "'" + cCodFamNuevo + "'"+ " WHERE cCodFam = " + "'" + cCodFam + "'"  ;
            if (cCodFam.isEmpty() && cDesFamNuevo.isEmpty() ) inssql = "UPDATE FAMILIAS SET cCodFam " + "=" + "'" + cCodFamNuevo + "'"+ " WHERE cDesFam = " + "'" + cDesFam + "'"  ;
            System.out.println(inssql);
            st = con.createStatement(); 
            nr = st.executeUpdate(inssql);
            if (nr>0){
            alert.setTitle("");
            alert.setHeaderText("");
            alert.setContentText("SE HAN ACTUALIZADO CON EXITO " + nr + " FILAS");	
            alert.showAndWait();
            }
            else{
                if (cCodFam.isEmpty() && cDesFam.isEmpty() ){
                    camp1.setText("Insertar datros");
                    camp2.setText("Insertar datros");
                }
                else{
                    alertE.setTitle("");
                    alertE.setHeaderText("");
                    alertE.setContentText("NO EXISTE EL CLIENTE ");	
                    alertE.showAndWait();
                }
            }
        }
        catch(SQLException e){
            if (con== null){
                System.out.println("ERROR CONEXION");
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("DESCONECTADO");	
                alertE.showAndWait();
        } 
            else{
                System.out.println("Se ha producido un error al"
                    + " ejecutar la sentencia sql");                  
                alertE.setTitle("");
                alertE.setHeaderText("");
                alertE.setContentText("ERROR AL INSERTAR DATOS");	
                alertE.showAndWait();
                }
        }  

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
