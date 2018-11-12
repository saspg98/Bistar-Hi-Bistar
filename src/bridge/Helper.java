/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import internal.User;
import jdbc.*;
import java.sql.*;

/**
 *
 * @author Sarthak
 */
public class Helper {

    private static JDBCConnection query;
    
    private static User usr;

    private static void makeConnection() {

        query = new JDBCConnection();
    }

    private static void closeConnection() {

        try {
            query.getSt().close();
            query.getCon().close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {

                if (query.getCon() != null && !query.getCon().isClosed()) {

                    query.getCon().close();
                }

            } catch (SQLException se) {

                se.printStackTrace();

            }

        }

    }

    //verify if the given username 'u' and password 'p' exist
    //-----used in LoginForm
    public static User verifyAndReturnUserInfo(String u, String p) {
        //Verify password and return a User object given a username
        //-----used in LoginForm

        makeConnection();

        String s = "SELECT * FROM dbo.userCredential WHERE Username = \'" + u + "\' AND " + "Password =\'" + p + "\'";

        try {

            ResultSet rs = query.getSt().executeQuery(s);

            if (!rs.next()) {

                rs.close();

                closeConnection();

                return null;

            }

        } catch (Exception e) {

            closeConnection();

            e.printStackTrace();

        }

        usr = new User();

        s = "SELECT * FROM dbo.userDetails WHERE username = \'" + u + "\'";

        try {

            ResultSet rs = query.getSt().executeQuery(s);

            while (rs.next()) {
                
                usr.setFName(rs.getString("FirstName"));
                usr.setLName(rs.getString("LastName"));
                usr.setDOB(rs.getString("DOB"));
                usr.setAddress(rs.getString("Address"));
                usr.setEmail(rs.getString("EmailID"));
                usr.setCustomerID(rs.getInt("CustomerID"));
                usr.setMobile(rs.getString("Mobile"));
                usr.setPinCode(rs.getInt("PinCode"));
                usr.setUsername(u);
                usr.setPassword(p);
             
            }

            rs.close();

            closeConnection();

        } catch (Exception e) {

            closeConnection();

            e.printStackTrace();

        }

        return usr;

    }

    // This method is used to save information entered by user into the database 
    // User is allowed to enter password with min length of 8 characters
    public static boolean signUp(User u) {

        makeConnection();

        try {
            
            String s = "INSERT INTO dbo.userCredential (Username,Password) VALUES (\'" + u.getUsername() + "\',\'" + u.getPassword() + "\')";

            query.getSt().executeUpdate(s);

            s = "INSERT INTO dbo.userDetails (FirstName,LastName,EmailID,Address,PinCode,Username,Mobile) VALUES (\'" + u.getFName() + "\',\'" + u.getLName() + "\',\'" + u.getEmail() + "\',\'" + u.getAddress() + "\'," + u.getPinCode() + ",\'" + u.getUsername() + "\'," +u.getMobile()+")";

            query.getSt().executeUpdate(s);

            closeConnection();
            
        } catch (Exception e) {

            closeConnection();
            e.printStackTrace();
            return false;
            
        }
        return true;
    }
    
    //Method to update the new details of the user in the database
    public static void updateUserProfile(User u){
        
        makeConnection();
        
        try{
            
            String s = "UPDATE dbo.userDetails SET FirstName =\'"+u.getFName()+"\',LastName =\'"+u.getLName()+"\',Address =\'"+u.getAddress()+"\',EmailID =\'"+u.getEmail()+"\',Mobile =\'"+u.getMobile()+"\',PinCode =\'"+u.getPinCode()+"\' WHERE Username =\'"+usr.getUsername()+"\'"; 
            
            query.getSt().executeUpdate(s);
            
        }catch (SQLException e) {
            
            e.printStackTrace();
            
        }finally{  closeConnection(); }
       
    }
    
    public static void updatePassword(){
        
        makeConnection();
        
        try{
        
        String s = "UPDATE dbo.userCredential SET Password =\'"+usr.getPassword()+"\' WHERE Username =\'"+usr.getUsername()+"\'";
        
        query.getSt().executeUpdate(s);
        
        }catch (SQLException e) {
            
            e.printStackTrace();
            
        }finally{  closeConnection(); } 
        
    }
}
