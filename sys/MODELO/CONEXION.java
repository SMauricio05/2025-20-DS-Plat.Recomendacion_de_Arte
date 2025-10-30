/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class CONEXION {
    private Connection conn;
    public CONEXION(){
        conn = null;
    }
    
    public void conectar(){
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PlataformaArte;user=prueba;password=12345;encrypt=false");
            System.out.print("se estableció la conexión con la Base de Datos.");
        }catch(SQLException e){
            System.out.println("Error al conectar a la Base de Datos.Error" +e.getMessage());
        }
    }
}
