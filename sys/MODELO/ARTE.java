/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arte;

import java.sql.Connection;

public class ARTE {

    
    public static void main(String[] args) {
        // Crear instancia de la clase Conexion
        Conexion conexion = new Conexion();
        
        // Intentar conectar
        Connection con = conexion.getConexion();
        
        // Comprobar si la conexión fue exitosa
        if (con != null) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("Conexión exitosa.");
        }
    }
    }
    
