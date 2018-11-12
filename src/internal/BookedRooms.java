/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.sql.Date;

/**
 *
 * @author Snehit
 */
public class BookedRooms {
    Date checkIn;
    Date checkOut;
    int numPeople;
    int numRooms;
    String location;
    String hotelName;
    String roomType;
    
    public BookedRooms(String hotelName, String roomType, int numPeople, int numRooms, String location, Date checkIn, Date checkOut) {
        
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.numPeople = numPeople;
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
    
    public int getNumPeople() {
        return numPeople;
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
    
    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
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
