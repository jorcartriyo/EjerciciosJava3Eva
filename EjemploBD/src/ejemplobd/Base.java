package ejemplobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que contiene diferentes métodos estáticos para realizar operaciones sobre
 * una base de datos.
 * @author 1DAMDAW
 */
public class Base {
    
    /**
     * Método que conecta con la base de datos.
     * @param url Dirección donde se encuentra la base de datos (en local)
     * @return La conexión establecida o null en caso de fallar la conexión.
     */
    public static Connection conectar(String url){
        Connection conexion = null;
        try{
            // Carga el driver sqlite-jdbc y establece conexión
            //conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","EXABD","EXABD");
            conexion = DriverManager.getConnection("jdbc:sqlite:"+url);
            if(conexion!=null){
                System.out.println("Conectado");
            }
        }
        catch(SQLException e){
            System.out.println("Se ha producido un error al"
                    + " establecer la conexión con la base de datos de ejemplo");            
        }        
        
        return conexion;
    }
    
    /**
     * Método para cerrar la conexión con la base de datos.
     * @param conexion Objeto de tipo Connection con el que cerramos la conexión.
     */
    public static void cerrarConexion(Connection conexion){
        try{                
            if(conexion!=null){
                conexion.close();                
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }                
    }
    
    /**
     * Método estático para crear la tabla en la base de datos.
     * @param conexion Objeto de tipo Connection en el cual tenemos establecida la conexión.
     * @param sql Cadena con la sentencia a ejecutar.
     */
    public static void crearTabla(Connection conexion, String sql){
        try{
            Statement stmt = conexion.createStatement();
            stmt.execute(sql);            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }        
    }
    
    
    /**
     * Método estático para realizar la inserción en la base de datos.
     * @param conexion Objeto de tipo Connection en el cual tenemos establecida la conexión.
     * @param sql  Cadena con la sentencia a ejecutar.
     * @param name Campo de la tabla con el nombre.
     * @param capacity Campo de la tabla con la capacidad.
     */
    public static void insertar(Connection conexion, String sql, String name, double capacity){
        try{
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Método estático que realiza la consulta en la base de datos.
     * @param conexion Objeto de tipo Connection en el cual tenemos establecida la conexión.
     * @param sql Cadena con la sentencia a ejecutar.
     * @return Devuelve un objeto de tipo ResultSet con lo obtenido tras la ejecución de la consulta.
     */
    public static ResultSet consulta(Connection conexion, String sql){
        ResultSet rs = null;
        try{
           Statement stmt = conexion.createStatement();
           rs = stmt.executeQuery(sql);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    /**
     * Método estático para imprimir por pantalla el resultado de la ejecución de una consulta.
     * @param rs Objeto de tipo ResultSet con el contenido de la ejecución de la consulta.
     */
    public static void imprimirConsulta(ResultSet rs){
        try{
            while(rs.next()){
                System.out.println(rs.getInt("Id")+"\t"+
                                   rs.getString("name") + "\t"+
                                   rs.getDouble("capacity"));
            }            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }        
    }
    
    /**
     * Método estático para borrar una fila de una tabla de la base de datos.
     * @param conexion Objeto de tipo Connection en el cual tenemos establecida la conexión.
     * @param sql Cadena con la sentencia a ejecutar.
     * @param id Campo de la tabla que se utiliza para identificar la fila a borrar.
     */
    public static void borrar(Connection conexion, String sql, int id){
        try{
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Método estático para actualizar una fila de una tabla de la base de datos.
     * @param conexion Objeto de tipo Connection en el cual tenemos establecida la conexión.
     * @param sql Cadena con la sentencia a ejecutar.
     * @param id Campo de la tabla que se utiliza para identificar la fila a borrar.
     * @param name Campo de la tabla con el nombre.
     * @param capacity Campo de la tabla con la capacidad.
     */
    public static void actualiza(Connection conexion, String sql, int id, String name, double capacity){
        try{
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }    
}
