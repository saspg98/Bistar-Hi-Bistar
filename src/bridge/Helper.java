/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import internal.Booking;
import internal.User;
import jdbc.*;
import java.sql.*;
import internal.HotelDesc;
import internal.BookingConstraints;
import internal.Rating;
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
                usr.setDOB(rs.getDate("DOB").toLocalDate().plusDays(2));
                usr.setAddress(rs.getString("Address"));
                usr.setEmail(rs.getString("EmailID"));
                usr.setCustomerID(rs.getLong("CustomerID"));
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

    public static void changePassword(String s) {

        makeConnection();

        try {

            String s1 = "UPDATE dbo.userCredential SET Password =\'" + s + "\' WHERE Username =\'" + usr.getUsername() + "\'";

            query.getSt().executeUpdate(s1);

        } catch (SQLException e) {

            closeConnection();
            e.printStackTrace();

        }

        closeConnection();
    }

    // This method is used to save information entered by user into the database 
    // User is allowed to enter password with min length of 8 characters
    public static boolean signUp(User u) {

        makeConnection();

        try {

            String s = "INSERT INTO dbo.userCredential (Username,Password) VALUES (\'" + u.getUsername() + "\',\'" + u.getPassword() + "\')";

            query.getSt().executeUpdate(s);

            s = "INSERT INTO dbo.userDetails (FirstName,LastName,EmailID,Address,PinCode,Username,Mobile,DOB) VALUES (\'" + u.getFName() + "\',\'" + u.getLName() + "\',\'" + u.getEmail() + "\',\'" + u.getAddress() + "\'," + u.getPinCode() + ",\'" + u.getUsername() + "\'," + u.getMobile() + ", \'" + u.getDOB() + "\')";

            query.getSt().executeUpdate(s);

            closeConnection();

        } catch (Exception e) {

            closeConnection();
            e.printStackTrace();
            return false;

        }
        return true;
    }

    public static void updateUserProfile(User u) {

        makeConnection();

        try {

            String s = "UPDATE dbo.userDetails SET FirstName =\'" + u.getFName() + "\',LastName =\'" + u.getLName() + "\',Address =\'" + u.getAddress() + "\',EmailID =\'" + u.getEmail() + "\',Mobile =\'" + u.getMobile() + "\',PinCode =\'" + u.getPinCode() + "\' WHERE Username =\'" + usr.getUsername() + "\'";

            query.getSt().executeUpdate(s);
            usr = u;
        } catch (SQLException e) {

            closeConnection();
            e.printStackTrace();

        }

        closeConnection();

    }

    public static ArrayList<HotelDesc> searchAndReturnHotelList(BookingConstraints bc) {

        makeConnection();

        int count = 0;

        try {
            String s;
            s = "SELECT * FROM dbo.hotelDetails WHERE City=\'" + bc.getLocation() + "\'";

            ResultSet rs = query.getSt().executeQuery(s);

            hotelList = new ArrayList();

            while (rs.next()) {

                hotel = new HotelDesc();

                int availableExecutive = rs.getInt("ExecutiveRooms"), availablePenthouse = rs.getInt("Penthouse"), availableDeluxe = rs.getInt("DeluxeRooms"), availableStandard = rs.getInt("StandardRooms");

                //Code repeated 4 times for different type of rooms
                //First type - START HERE
                for (LocalDate d = bc.getCheckIn(); d.isBefore(bc.getCheckOut()) || d.equals(bc.getCheckOut()); d = d.plusDays(1)) {

                    s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                            + "WHERE HotelID=" + rs.getInt("HotelID")
                            + " AND RoomCategory =\'Penthouse\' "
                            + "AND CheckInDate <=\'" + d.toString() + "\' AND CheckOutDate >=\'" + d.toString() + "\'";

                    ResultSet rs1 = query.getSt2().executeQuery(s);

                    if (!rs1.next()) {
                        if (rs.getInt("Penthouse") - rs1.getInt("sum") < bc.getNumRooms()) {

                            availablePenthouse = 0;
                            break;
                        } else {

                            availablePenthouse = Math.min(availablePenthouse, rs.getInt("Penthouse") - rs1.getInt("sum"));
                        }
                    } else if (rs.getInt("Penthouse") < bc.getNumRooms()) {

                        availablePenthouse = 0;
                        break;
                    }

                    rs1.close();

                }
                //First type - END HERE
                for (LocalDate d = bc.getCheckIn(); d.isBefore(bc.getCheckOut()) || d.equals(bc.getCheckOut()); d = d.plusDays(1)) {

                    s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                            + "WHERE hotelID =" + rs.getInt("HotelID")
                            + " AND RoomCategory =\'Executive\' "
                            + "AND CheckInDate <=\'" + d.toString() + "\' AND CheckOutDate>=\'" + d.toString() + "\'";

                    ResultSet rs1 = query.getSt2().executeQuery(s);

                    if (!rs1.next()) {
                        if (rs.getInt("ExecutiveRooms") - rs1.getInt("sum") < bc.getNumRooms()) {

                            availableExecutive = 0;
                            break;
                        } else {

                            availableExecutive = Math.min(availableExecutive, rs.getInt("ExecutiveRooms") - rs1.getInt("sum"));
                        }
                    } else if (rs.getInt("ExecutiveRooms") < bc.getNumRooms()) {

                        availableExecutive = 0;
                        break;
                    }

                    rs1.close();
                }

                for (LocalDate d = bc.getCheckIn(); d.isBefore(bc.getCheckOut()) || d.equals(bc.getCheckOut()); d = d.plusDays(1)) {

                    s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                            + "WHERE hotelID=" + rs.getInt("HotelID")
                            + " AND RoomCategory=\'Standard\' "
                            + "AND CheckInDate<=\'" + d.toString() + "\' AND CheckOutDate>=\'" + d.toString() + "\'";

                    ResultSet rs1 = query.getSt2().executeQuery(s);

                    if (!rs1.next()) {
                        if (rs.getInt("StandardRooms") - rs1.getInt("sum") < bc.getNumRooms()) {

                            availableStandard = 0;
                            break;
                        } else {

                            availableStandard = Math.min(availableStandard, rs.getInt("StandardRooms") - rs1.getInt("sum"));
                        }
                    } else if (rs.getInt("StandardRooms") < bc.getNumRooms()) {

                        availableStandard = 0;
                        break;
                    }

                    rs1.close();
                }

                for (LocalDate d = bc.getCheckIn(); d.isBefore(bc.getCheckOut()) || d.equals(bc.getCheckOut()); d = d.plusDays(1)) {

                    s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                            + "WHERE hotelID=" + rs.getInt("HotelID")
                            + " AND RoomCategory=\'Deluxe\' "
                            + "AND CheckInDate<=\'" + d.toString() + "\' AND CheckOutDate>=\'" + d.toString() + "\'";

                    ResultSet rs1 = query.getSt2().executeQuery(s);

                    if (!rs1.next()) {
                        if (rs.getInt("DeluxeRooms") - rs1.getInt("sum") < bc.getNumRooms()) {

                            availableDeluxe = 0;
                            break;
                        } else {

                            availableDeluxe = Math.min(availableDeluxe, rs.getInt("DeluxeRooms") - rs1.getInt("sum"));
                        }
                    } else if (rs.getInt("DeluxeRooms") < bc.getNumRooms()) {

                        availableDeluxe = 0;
                        break;
                    }

                    rs1.close();
                }

                if (availablePenthouse > 0 || availableDeluxe > 0 || availableStandard > 0 || availableExecutive > 0) {

                    hotel.setAddress(rs.getString("Address"));
                    hotel.setDescription(rs.getString("Description"));
                    hotel.setRoomAmenities(rs.getString("RoomAmenities"));
                    hotel.setHotelAmenities(rs.getString("HotelAmenities"));
                    hotel.setCity(rs.getString("City"));
                    hotel.setHotelName(rs.getString("Name"));
                    hotel.setHotelID(rs.getInt("HotelID"));
                    hotel.setNumOfRoomTypes(new int[]{availablePenthouse, availableExecutive, availableDeluxe, availableStandard});
                    hotel.setPrices(new double[]{rs.getInt("PenthousePrice"), rs.getInt("ExecutiveRoomPrice"), rs.getInt("DeluxeRoomPrice"), rs.getInt("StandardRoomPrice")});

                    Rating r = new Rating(rs.getInt("ExcellentCount"), rs.getInt("VeryGoodCount"),
                            rs.getInt("AvgCount"), rs.getInt("PoorCount"), rs.getInt("TerribleCount"),
                            rs.getInt("ReviewCount"));
                    hotel.setRating(r);
                    hotelList.add(hotel);

                }
            }

            rs.close();
            closeConnection();

        } catch (SQLException se) {

            closeConnection();
            se.printStackTrace();
        }

        return hotelList;
    }

    public static String[] distinctLocations() {

        ArrayList<String> locations = new ArrayList();
        makeConnection();
        try {
            String s;
            s = "SELECT DISTINCT City FROM dbo.hotelDetails";
            ResultSet rs = query.getSt().executeQuery(s);

            while (rs.next()) {
                locations.add(rs.getString("City"));
            }

        } catch (SQLException se) {
            closeConnection();
            se.printStackTrace();
        }

        String[] locationsArray = new String[locations.size()];
        locations.toArray(locationsArray);

        return locationsArray;
    }

    public static ArrayList<Booking> confirmedBookings() {

        ArrayList<Booking> list = new ArrayList();

        Booking b;

        makeConnection();

        String s = "SELECT * FROM dbo.confirmedBookings WHERE CustomerID =" + usr.getCustomerID() + " AND CheckInDate>=CONVERT(DATE,GETDATE())";

        try {
            ResultSet rs = query.getSt().executeQuery(s);

            int HotelID;

            while (rs.next()) {

                b = new Booking();

                //IMPORTANT!!!!! rs.getDate() gives a date two days previous to database storage
                b.setBookingReference(rs.getLong("BookingReference"));
                b.setCheckIn(rs.getDate("CheckInDate").toLocalDate().plusDays(2));
                b.setCheckOut(rs.getDate("CheckOutDate").toLocalDate().plusDays(2));
                b.setNumPeople(rs.getInt("NoOfPeople"));
                b.setNumRooms(rs.getInt("NoOfRooms"));
                b.setPrice(rs.getInt("TotalPrice"));
                b.setRoomType(rs.getString("RoomCategory"));
                HotelID = rs.getInt("HotelID");

                s = "SELECT Name,City FROM dbo.HotelDetails WHERE HotelID =" + HotelID;

                ResultSet rs1 = query.getSt2().executeQuery(s);
                rs1.next();

                b.setHotelName(rs1.getString("Name"));
                b.setAddress(rs1.getString("City"));

                rs1.close();

                list.add(b);

            }

            rs.close();
            closeConnection();

        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }

        return list;

    }

    public static ArrayList<Booking> waitlistBookings() {

        ArrayList<Booking> list = new ArrayList();

        Booking b;

        makeConnection();

        String s = "SELECT * FROM dbo.inWaitingBookings WHERE CustomerID =" + usr.getCustomerID();

        try {
            ResultSet rs = query.getSt().executeQuery(s);

            int HotelID;

            while (rs.next()) {

                b = new Booking();

                b.setBookingReference(rs.getLong("BookingReference"));
                b.setCheckIn(rs.getDate("CheckInDate").toLocalDate().plusDays(2));
                b.setCheckOut(rs.getDate("CheckOutDate").toLocalDate().plusDays(2));
                b.setNumPeople(rs.getInt("NoOfPeople"));
                b.setNumRooms(rs.getInt("NoOfRooms"));
                b.setPrice(rs.getInt("TotalPrice"));
                b.setRoomType(rs.getString("RoomCategory"));
                b.setWaitlist(true);
                HotelID = rs.getInt("HotelID");

                s = "SELECT Name,City FROM dbo.HotelDetails WHERE HotelID =" + HotelID;

                ResultSet rs1 = query.getSt2().executeQuery(s);
                rs1.next();

                b.setHotelName(rs1.getString("Name"));
                b.setAddress(rs1.getString("City"));

                rs1.close();

                list.add(b);

            }

            rs.close();
            closeConnection();

        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }

        return list;

    }

    public static ArrayList<Booking> oldBookings() {

        ArrayList<Booking> list = new ArrayList();

        Booking b;

        makeConnection();

        String s = "SELECT * FROM dbo.confirmedBookings WHERE CustomerID =" + usr.getCustomerID() + " AND CheckInDate<CONVERT(DATE,GETDATE())";

        try {
            ResultSet rs = query.getSt().executeQuery(s);

            int HotelID;

            while (rs.next()) {

                b = new Booking();

                b.setBookingReference(rs.getLong("BookingReference"));
                b.setCheckIn(rs.getDate("CheckInDate").toLocalDate().plusDays(2));
                b.setCheckOut(rs.getDate("CheckOutDate").toLocalDate().plusDays(2));
                b.setNumPeople(rs.getInt("NoOfPeople"));
                b.setNumRooms(rs.getInt("NoOfRooms"));
                b.setPrice(rs.getInt("TotalPrice"));
                b.setRoomType(rs.getString("RoomCategory"));
                HotelID = rs.getInt("HotelID");

                s = "SELECT Name,City FROM dbo.HotelDetails WHERE HotelID =" + HotelID;

                ResultSet rs1 = query.getSt2().executeQuery(s);
                rs1.next();

                b.setHotelName(rs1.getString("Name"));
                b.setAddress(rs1.getString("City"));

                rs1.close();

                list.add(b);

            }

            rs.close();
            closeConnection();

        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }

        return list;

    }

    public static long updateBooking(Booking bk) {

        makeConnection();

        try {
            if (bk.isWaitlist() == false) {
                String s = "INSERT INTO dbo.confirmedBookings (CustomerID,HotelID,RoomCategory,CheckInDate,CheckOutDate,NoOfPeople,NoOfRooms,TotalPrice)"
                        + "VALUES (" + usr.getCustomerID() + "," + bk.getHotelID() + ",\'" + bk.getRoomType() + "\',\'" + bk.getCheckIn() + "\',\'" + bk.getCheckOut() + "\'," + bk.getNumPeople() + "," + bk.getNumRooms() + "," + bk.getPrice() + ")";

                query.getSt().executeUpdate(s);

                s = "SELECT TOP 1 BookingReference FROM dbo.confirmedBookings ORDER BY BookingReference DESC";
                ResultSet rs = query.getSt().executeQuery(s);
                rs.next();
                long ref = rs.getLong("BookingReference");

                rs.close();
                closeConnection();

                return ref;
            } else {
                String s = "INSERT INTO dbo.inWaitingBookings (CustomerID,HotelID,RoomCategory,CheckInDate,CheckOutDate,NoOfPeople,NoOfRooms,TotalPrice)"
                        + "VALUES (" + usr.getCustomerID() + "," + bk.getHotelID() + ",\'" + bk.getRoomType() + "\',\'" + bk.getCheckIn() + "\',\'" + bk.getCheckOut() + "\'," + bk.getNumPeople() + "," + bk.getNumRooms() + "," + bk.getPrice() + ")";

                query.getSt().executeUpdate(s);

                s = "SELECT TOP 1 BookingReference FROM dbo.inWaitingBookings ORDER BY BookingReference DESC";
                ResultSet rs = query.getSt().executeQuery(s);
                rs.next();
                long ref = rs.getLong("BookingReference");

                rs.close();
                closeConnection();

                return ref;
            }

        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }

        return -1;
    }

    public static void cancelBooking(Booking bk) {

        makeConnection();

        try {
            if (bk.isWaitlist() == false) {
                String s = "DELETE FROM dbo.confirmedBookings WHERE BookingReference=\'" + bk.getBookingReference() + "\'";
                query.getSt().executeUpdate(s);

            } else {
                String s = "DELETE FROM dbo.isWaitingBookings WHERE BookingReference=\'" + bk.getBookingReference() + "\'";
                query.getSt().executeUpdate(s);

            }
            closeConnection();
        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }
    }

    public static boolean checkBookingPossibility(Booking bk) {

        makeConnection();

        try {

            String s = "SELECT * FROM dbo.hotelDetails WHERE BookingReference=\'" + bk.getBookingReference() + "\'";
            ResultSet rs = query.getSt().executeQuery(s);
            rs.next();

            int available;
            String roomType;

            if (bk.getRoomType().equals("Penthouse")) {
                roomType = "Penthouse";
                available = rs.getInt("Penthouse");
            } else {
                roomType = bk.getRoomType() + "Rooms";
                available = rs.getInt(bk.getRoomType() + "Rooms");
            }

            for (LocalDate d = bk.getCheckIn(); d.isBefore(bk.getCheckOut()) || d.equals(bk.getCheckOut()); d = d.plusDays(1)) {

                s = "SELECT SUM(NoOfRooms) AS sum FROM dbo.confirmedBookings "
                        + "WHERE HotelID=" + rs.getInt("HotelID")
                        + " AND RoomCategory =\'" + roomType + "\' "
                        + "AND CheckInDate <=\'" + d.toString() + "\' AND CheckOutDate >=\'" + d.toString() + "\'";

                ResultSet rs1 = query.getSt2().executeQuery(s);

                if (!rs1.next()) {
                    if (rs.getInt(roomType) - rs1.getInt("sum") < bk.getNumRooms()) {
                        available = 0;
                        break;
                    } else {

                        available = Math.min(available, rs.getInt(roomType) - rs1.getInt("sum"));
                    }
                } else if (rs.getInt(roomType) < bk.getNumRooms()) {

                    available = 0;
                    break;
                }

                rs1.close();

            }
            
            rs.close();
            
            closeConnection();
            
            return available >= bk.getNumRooms();

            
        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean modifyBooking(Booking bk) {
           
        makeConnection();

        try {
            String s = "SELECT * FROM dbo.confirmedBookings WHERE BookingReference=\'" + bk.getBookingReference() + "\'";
            ResultSet rs = query.getSt().executeQuery(s);
            rs.next();

            int oldNumRooms = rs.getInt("NoOfRooms");
      
            rs.close();
            
            s = "UPDATE dbo.confirmedBookings"
                    + "SET NoOfRooms=0 "
                    + "WHERE BookingReference=\'" + bk.getBookingReference() + "\'";
            query.getSt2().executeUpdate(s);
        
        if(checkBookingPossibility(bk))
        {
            s = "UPDATE dbo.confirmedBookings"
                    + "SET CustomerID=" + usr.getCustomerID() + ",HotelID=" + bk.getHotelID() + ",RoomCategory=\'" + bk.getRoomType() + "\',CheckInDate=\'" + bk.getCheckIn() + "\',CheckOutDate=\'" + bk.getCheckOut() + "\',NoOfPeople=" + bk.getNumPeople() + ",NoOfRooms=" + bk.getNumRooms() +",TotalPrice=" + bk.getPrice()
                    + "WHERE BookingReference=\'" + bk.getBookingReference() + "\'";
            query.getSt2().executeUpdate(s);
            closeConnection();
            return true;
        }
        else
        {
            s = "UPDATE dbo.confirmedBookings"
                    + "SET NoOfRooms=" + oldNumRooms + " "
                    + "WHERE BookingReference=\'" + bk.getBookingReference() + "\'";
            query.getSt2().executeUpdate(s);
            return false;
        }
        

        } catch (SQLException e) {
            closeConnection();
            e.printStackTrace();
        }
        
        return false;
    }
}
