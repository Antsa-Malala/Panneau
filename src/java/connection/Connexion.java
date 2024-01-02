/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author Antsa
 */
public class Connexion {
    public static Connection getConnect(String base) throws Exception{
        try{
                Class.forName("org.postgresql.Driver");
                Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/panneau", "panneau", "panneau");
                return connect;    
        }
        catch(Exception e){
            throw e;
        }
    }
}  
