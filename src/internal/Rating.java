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
    
    public Rating(int excellentCount, int veryGoodCount, int averageCount, int poorCount, int terribleCount, int reviewCount) {
        this.excellentCount = excellentCount;
        this.veryGoodCount = veryGoodCount;
        this.averageCount = averageCount;
        this.poorCount = poorCount;
        this.terribleCount = terribleCount;
        this.reviewCount = reviewCount;
    }
    
    public double getRating() {
        int r=(5*excellentCount+4*veryGoodCount+3*averageCount+2*poorCount+1*terribleCount)/reviewCount;
        return r;
    }
}
