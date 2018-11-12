/*

 */
package internal;

import java.sql.Date;
/**
 *
 * @author Snehit
 */
public class BookingConstraints {
    
    Date checkIn;
    Date checkOut;
    double maxPrice;
    int numRooms;
    String location;
    String hotelName;
    String roomType;
    
    public BookingConstraints(String hotelName, String roomType, double maxPrice, int numRooms, String location, Date checkIn, Date checkOut) {
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.maxPrice = maxPrice;
        this.numRooms = numRooms;
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    
    public String getHotelName() {
        return hotelName;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public double getMaxPrice() {
        return maxPrice;
    }

    public String getLocation() {
        return location;
    }
    
    public int getNumRooms() {
        return numRooms;
    }
        
    public Date getCheckIn() {
        return checkIn;
    }
        
    public Date getCheckOut() {
        return checkOut;
    }
    
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }
        
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }
        
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
    
}
