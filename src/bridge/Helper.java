/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import com.sun.webkit.graphics.RenderTheme;
import internal.User;
import jdbc.*;
import java.sql.*;
import internal.HotelDesc;
import internal.BookingConstraints;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sarthak
 */
public class Helper {

    private static JDBCConnection query;
    
    private static User usr;
    
    private static HotelDesc hotel;
    
    private static ArrayList<HotelDesc> hotelList;

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
    
    public static void updateUserProfile(User u){
        
        makeConnection();
        
        try{
            
            System.out.println(usr.getUsername());
            
            String s = "UPDATE dbo.userDetails SET FirstName =\'"+u.getFName()+"\',LastName =\'"+u.getLName()+"\',Address =\'"+u.getAddress()+"\',EmailID =\'"+u.getEmail()+"\',Mobile =\'"+u.getMobile()+"\',PinCode =\'"+u.getPinCode()+"\' WHERE Username =\'"+usr.getUsername()+"\'"; 
            
            query.getSt().executeUpdate(s);
            
        }catch (SQLException e) {

            closeConnection();
            e.printStackTrace();
            
        }
        
        closeConnection();
       
    }
    
    
    public static ArrayList<HotelDesc> searchAndReturnHotelList(BookingConstraints bc){
        
        makeConnection();
        
        try {
            String s;
            s = "SELECT * FROM dbo.hotelDetails WHERE City=\'"+ bc.getLocation()+"\'";
            
            ResultSet rs = query.getSt().executeQuery(s);
            
            while (rs.next()) {
                ArrayList<String> availableRoomTypes = new ArrayList();
                ArrayList<Integer> price= new ArrayList();
                boolean availableExecutive = true, availablePenthouse = true, availableDeluxe = true, availableStandard = true;

                //Code repeated 4 times for different type of rooms
                for (LocalDate d = bc.getCheckIn(); d.isBefore(bc.getCheckOut()) || d.equals(bc.getCheckOut()); d.plusDays(1)) {
                    s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                            + "WHERE HotelID=" + rs.getInt("HotelID")
                            + " AND RoomCategory='Penthouse' "
                            + "AND (CheckInDate<='" + d.toString() + "' AND CheckOutDate>='" + d.toString() + "')";
                    
                    ResultSet rs1 = query.getSt2().executeQuery(s);
                    rs1.next();
                    if (rs.getInt("Penthouse") - rs1.getInt("sum") < bc.getNumRooms()) {
                        availablePenthouse = false;
                    }
                }
                for (LocalDate d = bc.getCheckIn(); d.isBefore(bc.getCheckOut()) || d.equals(bc.getCheckOut()); d.plusDays(1)) {
                    s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                            + "WHERE hotelID=" + rs.getInt("HotelID")
                            + " AND RoomCategory=\'Executive\' "
                            + "AND (CheckInDate<=\'" + d.toString() + "\' AND CheckOutDate>=\'" + d.toString() + "\')";
                    
                    ResultSet rs1 = query.getSt2().executeQuery(s);
                    rs1.next();
                    if (rs.getInt("ExecutiveRooms") - rs1.getInt("sum") < bc.getNumRooms()) {
                        availableExecutive = false;
                    }
                }
                for (LocalDate d = bc.getCheckIn(); d.isBefore(bc.getCheckOut()) || d.equals(bc.getCheckOut()); d.plusDays(1)) {
                    s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                            + "WHERE hotelID=" + rs.getInt("HotelID")
                            + " AND RoomCategory=\'Standard\' "
                            + "AND (CheckInDate<=\'" + d.toString() + "\' AND CheckOutDate>=\'" + d.toString() + "\')";
                    
                    ResultSet rs1 = query.getSt2().executeQuery(s);
                    rs1.next();
                    if (rs.getInt("StandardRooms") - rs1.getInt("sum)") < bc.getNumRooms()) {
                        availableStandard = false;
                    }
                }
                for (LocalDate d = bc.getCheckIn(); d.isBefore(bc.getCheckOut()) || d.equals(bc.getCheckOut()); d.plusDays(1)) {
                    s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                            + "WHERE hotelID=" + rs.getInt("HotelID")
                            + " AND RoomCategory=\'Deluxe\' "
                            + "AND (CheckInDate<=\'" + d.toString() + "\' AND CheckOutDate>=\'" + d.toString() + "\')";
                    
                    ResultSet rs1 = query.getSt2().executeQuery(s);
                    rs1.next();
                    if (rs.getInt("DeluxeRooms") - rs1.getInt("sum") < bc.getNumRooms()) {
                        availableDeluxe = false;
                    }
                }
                
                if (availablePenthouse == true) {
                    availableRoomTypes.add("Penthouse");
                    price.add(rs.getInt("PenthousePrice"));
                }
                if (availableExecutive == true) {
                    availableRoomTypes.add("Executive");
                    price.add(rs.getInt("ExecutiveRoomPrice"));
                }
                if (availableDeluxe == true) {
                    availableRoomTypes.add("Deluxe");
                    price.add(rs.getInt("DeluxeRoomPrice"));
                }
                if (availablePenthouse == true) {
                    availableRoomTypes.add("Standard");
                    price.add(rs.getInt("StandardRoomPrice"));
                }
                
                if (availablePenthouse == true || availableDeluxe == true || availableStandard == true || availableExecutive == true) {
                    hotel.setAdress(rs.getString("Adress"));
                    hotel.setDescription(rs.getString("Description"));
                    hotel.setRoomAmenities(rs.getString("RoomAmenities"));
                    hotel.setHotelAmenities(rs.getString("HotelAmenities"));
                    hotel.setCity(rs.getString("City"));
                    hotel.setHotelName(rs.getString("Name"));
                    
                    String[] availableRoomTypesArray = new String[availableRoomTypes.size()];
                    availableRoomTypes.toArray(availableRoomTypesArray);
                    hotel.setRoomTypes(availableRoomTypesArray);
                    
                    double[] priceArray = new double[price.size()];
                    Iterator<Integer> iterator = price.iterator();
                    for (int i = 0; i < priceArray.length; i++)
                    {
                        priceArray[i] = iterator.next();
                    }
                    hotel.setPrices(priceArray);
                    
                    hotelList.add(hotel);
                }
            }
        } catch (SQLException se) {
            closeConnection();
            se.printStackTrace();
        }
       
        return hotelList;
    }
    
    public static String[] distinctLocations(){
        
        makeConnection();
        ArrayList<String> locations = new ArrayList();
        try {
            String s;
            s = "SELECT DISTINCT City FROM dbo.hotelDetails";
            ResultSet rs = query.getSt().executeQuery(s);
            
            while (rs.next()) 
                locations.add(rs.getString("City"));
            
        }catch (SQLException se) {
            closeConnection();
            se.printStackTrace();
        }
            
        String[] locationsArray = new String[locations.size()];
        locations.toArray(locationsArray);
            
        return locationsArray;
    }

}
 