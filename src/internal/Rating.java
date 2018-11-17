/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

/**
 *
 * @author Snehit
 */
public class Rating {
    
    public int reviewCount;
    public int excellentCount;
    public int veryGoodCount;
    public int averageCount;
    public int poorCount;
    public int terribleCount;
    public int totalRatingCount;
    
    public Rating(int excellentCount, int veryGoodCount, int averageCount, int poorCount, int terribleCount, int reviewCount) {
        this.excellentCount = excellentCount;
        this.veryGoodCount = veryGoodCount;
        this.averageCount = averageCount;
        this.poorCount = poorCount;
        this.terribleCount = terribleCount;
        this.reviewCount = reviewCount;
        totalRatingCount = excellentCount+veryGoodCount+averageCount+poorCount+terribleCount;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getExcellentCount() {
        return excellentCount;
    }

    public void setExcellentCount(int excellentCount) {
        this.excellentCount = excellentCount;
    }

    public int getVeryGoodCount() {
        return veryGoodCount;
    }

    public void setVeryGoodCount(int veryGoodCount) {
        this.veryGoodCount = veryGoodCount;
    }

    public int getAverageCount() {
        return averageCount;
    }

    public void setAverageCount(int averageCount) {
        this.averageCount = averageCount;
    }

    public int getPoorCount() {
        return poorCount;
    }

    public void setPoorCount(int poorCount) {
        this.poorCount = poorCount;
    }

    public int getTerribleCount() {
        return terribleCount;
    }

    public void setTerribleCount(int terribleCount) {
        this.terribleCount = terribleCount;
    }

    public int getTotalRatingCount() {
        return totalRatingCount;
    }
    
    
    public double getOverallRating() {
        double r=(5.0*excellentCount+4.0*veryGoodCount+3.0*averageCount+2.0*poorCount+1.0*terribleCount)/(
        totalRatingCount);
        return r;
    }
}
