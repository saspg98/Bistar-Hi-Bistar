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
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numPeople;
    private int numRooms;
    private String address;
    private String hotelName;
    private String roomType;
    private int price;
    private long bookingReference;
    private boolean waitlist=false;
    private int hotelID;
    private int rating;

    public Booking(Booking booking) {
        this.checkIn = booking.checkIn;
        this.checkOut = booking.checkOut;
        this.numPeople = booking.numPeople;
        this.numRooms = booking.numRooms;
        this.address = booking.address;
        this.hotelName = booking.hotelName;
        this.roomType = booking.roomType;
        this.price = booking.price;
        this.bookingReference = booking.bookingReference;
        this.hotelID = booking.hotelID;
        this.rating = booking.rating;
        this.hotel = booking.hotel;
    }

   public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    private HotelDesc hotel;

    public HotelDesc getHotel() {
        return hotel;
    }

    public void setHotel(HotelDesc hotel) {
        this.hotel = hotel;
    }
    
    

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public long getBookingReference() {
        return bookingReference;
    }

    

    public void setBookingReference(long bookingReference) {
        this.bookingReference = bookingReference;
    }

    
    public Booking(LocalDate checkIn, LocalDate checkOut, int numPeople, int numRooms, String location, String hotelName, String roomType, int price) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numPeople = numPeople;
        this.numRooms = numRooms;
        this.address = location;
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

    public String getAddress() {
        return address;
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

    public void setAddress(String address) {
        this.address = address;
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
 
    public Booking(){}
    
    public void print(){
        System.err.println("Booking :"+hotelName+"  "+ roomType +"  "+ numRooms+"  "+rating);
    }
    
}
