/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    public Connection getConexion(){
      String connectionUrl = 
              "jdbc:sqlserver://UHYXE30132\\MSSQLSERVER1;"
              +"database=ARTE;"
              +"user=xd"
              +"password=12345"
              +"timeout=30"
              +"encrypt=true;trustServerCertificate=true";
      try{
          Connection con = DriverManager.getConnection(connectionUrl);
          return con;
      }catch(SQLException ex){
          return null;
      }
}
    
}

