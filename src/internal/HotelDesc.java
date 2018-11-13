/*
 * TODO: Add reviews!
 */
package internal;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author Sarthak
 */
public class HotelDesc {
    
    //IMP! The database query has to sort the roomtypes of the hotel according to their prices in ASCENDING order
    //In the method,getPriceRange(), it is assumed that the lowest price is stored in prices[0], and the highest in prices[price.length-1]
    public static final String[] ROOM_TYPES = {"Penthouse","Executive","Deluxe","Standard"};
    
    String hotelName;
    int[] numOfRoomTypes;
    double[] prices;
    int stars;
    int numReviews;
    String description;
    String roomAmenities;
    String hotelAmenities;
    Rating rating;
    String address;
    String city;



    private static final String CURRENCY = "\u20B9";
    public HotelDesc(String hotelName, int[] roomType, double[] price, int stars, int numReviews, String description, String roomAmenities, String hotelAmenities, Rating rating, String adress) {
        this.hotelName = hotelName;
        this.numOfRoomTypes = roomType;
        this.prices = price;
        this.stars = stars;
        this.numReviews = numReviews;
        this.description = description;
        this.roomAmenities = roomAmenities;
        this.hotelAmenities = hotelAmenities;
        this.rating=rating;
        this.address=adress;
    }

        public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
    
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setNumOfRoomTypes(int[] numOfRoomTypes) {
        this.numOfRoomTypes = numOfRoomTypes;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoomAmenities(String roomAmenities) {
        this.roomAmenities = roomAmenities;
    }

    public void setHotelAmenities(String hotelAmenities) {
        this.hotelAmenities = hotelAmenities;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

    public String getHotelName() {
        return hotelName;
    }

    public int[] getNumOfRoomTypes() {
        return numOfRoomTypes;
    }
    
    
    
    public boolean isAvailable(String type){
        int index=-1;
        for(int i=0;i<ROOM_TYPES.length;i++){
            if(ROOM_TYPES[i].equals(type)){
                index = i;
                break;
            }
        }System.out.println("If array out of bounds then type aint available");
        if(numOfRoomTypes[index]>0)
            return true;
        
        return false;
    }

    public double[] getPrices() {
        return prices;
    }

    public int getStars() {
        return stars;
    }

    public int getNumReviews() {
        return numReviews;
    }

    public String getDescription() {
        return description;
    }

    public String getRoomAmenities() {
        return roomAmenities;
    }
    
    public String getHotelAmenities() {
        return hotelAmenities;
    }
    
    public String getAddress() {
        return address;
    }
    
    public Rating getRating() {
        return rating;
    }

    
    
    

    public String getPriceRange() {
        //TODO: Pretty print all currency(upto two decimal places)
        if(prices.length>1)
            return CURRENCY + prices[0]+"-"+CURRENCY+prices[prices.length-1];
        else
            return CURRENCY+String.valueOf(prices[0]);
    }
    
    
    //TODO: COMPLETE METHOD! DUMMY BODY
    public static int getCost(String type, int rooms, LocalDate checkIn, LocalDate checkOut){
        return 3450;
    }

    public HotelDesc() {
        System.out.println("Empty Hotel created");
    }
    
    
    public void print(){
        System.out.println("Printing Hotel Description!");
        System.out.println(hotelName);
        System.out.println(address);
    }
    
}
