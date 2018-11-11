/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class JDBCConnection {
    
        private static Connection con;
        private static Statement st;

    public static Connection getCon() {
        return con;
    }

    public static Statement getSt() {
        return st;
    }
    
        
    
            public JDBCConnection()
            {
                try{
                
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                con = DriverManager.getConnection("jdbc:sqlserver://172.16.48.87:1433;databaseName=OHBP;username=sa;password=sayrav123");
                
                st = con.createStatement();
                
                 }
                catch(SQLException se)
                {
                    JOptionPane.showMessageDialog(null, "Error! Unable to estabilish connection with database.");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Error! Unable to install driver.");
                }
                
                
            }
                 
    
}
