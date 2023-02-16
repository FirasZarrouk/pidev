/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author afifa
 */
public class connection {
    
    //DB PARAM
    static final String URL ="jdbc:mysql://localhost:3306/pidev";
    static final String USER ="root";
    static final String PASSWORD ="";
    
    //var
    private Connection cnx;
    //1
    static connection instance;
    
    //const
    //2
    public connection(){
        try {
            cnx = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public Connection getCnx() {
        return cnx;
    }

    //3
    public static connection getInstance() {
        if(instance == null)
            instance = new connection();
        
        return instance;
    }
    
}