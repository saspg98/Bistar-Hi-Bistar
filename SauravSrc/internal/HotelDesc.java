/*
 * TODO: Add reviews!
 */
package internal;

import java.sql.Date;

/**
 *
 * @author Sarthak
 */
public class HotelDesc {
    
    //IMP! The database query has to sort the roomtypes of the hotel according to their prices in ASCENDING order
    //In the method,getPriceRange(), it is assumed that the lowest price is stored in prices[0], and the highest in prices[price.length-1]
    
    String hotelName;
    String[] roomTypes;
    double[] prices;
    int stars;
    int numReviews;
    String description;
    String amenities;
    
    
    private static final String CURRENCY = "\u20B9";
    public HotelDesc(String hotelName, String[] roomType, double[] price, int stars, int numReviews, String description, String amenities) {
        this.hotelName = hotelName;
        this.roomTypes = roomType;
        this.prices = price;
        this.stars = stars;
        this.numReviews = numReviews;
        this.description = description;
        this.amenities = amenities;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String[] getRoomTypes() {
        return roomTypes;
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

    public String getAmenities() {
        return amenities;
    }
    
    
    
    

    public String getPriceRange() {
        //TODO: Pretty print all currency(upto two decimal places)
        if(prices.length>1)
            return CURRENCY + prices[0]+"-"+CURRENCY+prices[prices.length-1];
        else
            return CURRENCY+String.valueOf(prices[0]);
    }
    
    
    //TODO: COMPLETE METHOD! DUMMY BODY
    public double getCost(String type, int rooms, Date checkIn, Date checkOut){
        return 3450;
    }
    
    
    
    
}
