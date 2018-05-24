/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigomorseinterfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Router1
 */
public class MorseFXMLController implements Initializable {
    private String palabra="";     
    private String morse[] = {" .---- ", " ..--- ", " ... -- ", " ....- ", " ..... ", 
        " _.... ", " _ _... ", " - - -.. ", "----.", "-----", ".-", "-...", 
        "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", 
        ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", 
        "--..", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", 
        "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
        "--.-", ".-.", "...", " - ", " ..- ", "...-", ".--", "-..-", 
        "-.--", "--..", " ", ".-.-.-", "--..--", "..--..", "---...", 
        "-....-", "!"," "}; 
    String letras = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .,?:-!"; 
    int posicion=0; 
    String suma=""; 
    @FXML
    private TextField entrada;
    @FXML
    private TextField salida;     
    @FXML
    private void accionTraducir(ActionEvent event) {
        palabra = entrada.getText();
        
        for (int f = 0; f < palabra.length(); f++) {             
            posicion=letras.indexOf(palabra.charAt(f)); 
            suma+=morse[posicion];              
        }
        salida.setText(suma);
    }
    @FXML
    private void accionBorrar(ActionEvent event) {
        entrada.setText("");
        salida.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
