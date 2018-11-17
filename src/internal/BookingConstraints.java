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
    private boolean showAll;
    private int numGuests;

    public BookingConstraints(LocalDate checkIn, LocalDate checkOut, double maxPrice, int numRooms, String location, boolean showAll) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.maxPrice = maxPrice;
        this.numRooms = numRooms;
        this.location = location;
        this.showAll = showAll;
    }

    public boolean isShowAll() {
        return showAll;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }
    
    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
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
