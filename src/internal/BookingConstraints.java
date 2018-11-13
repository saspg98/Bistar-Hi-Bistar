/*

 */
package internal;

import java.time.LocalDate;
/**
 *
 * @author Snehit
 */
public class BookingConstraints {
    
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double maxPrice;
    private int numRooms;
    private String location;

    
    public BookingConstraints(double maxPrice, int numRooms, String location, LocalDate checkIn, LocalDate checkOut) {
        this.maxPrice = maxPrice;
        this.numRooms = numRooms;
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
        
    public LocalDate getCheckIn() {
        return checkIn;
    }
        
    public LocalDate getCheckOut() {
        return checkOut;
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
        
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
        
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
    
}
