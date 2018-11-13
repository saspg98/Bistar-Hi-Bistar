/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.time.LocalDate;

/**
 *
 * @author Snehit
 */
public class Booking {
    LocalDate checkIn;
    LocalDate checkOut;
    int numPeople;
    int numRooms;
    String location;
    String hotelName;
    String roomType;
    int price;
    boolean waitlist=false;

    public Booking(LocalDate checkIn, LocalDate checkOut, int numPeople, int numRooms, String location, String hotelName, String roomType, int price) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numPeople = numPeople;
        this.numRooms = numRooms;
        this.location = location;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        
    public LocalDate getCheckIn() {
        return checkIn;
    }
        
    public LocalDate getCheckOut() {
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
        
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
        
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isWaitlist() {
        return waitlist;
    }

    public void setWaitlist(boolean waitlist) {
        this.waitlist = waitlist;
    }
    
    
}
