/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import pt.ua.encontreja.entity.Rating;

/**
 *
 * @author mezca
 */
public class RatingCalc {

    private final List<Rating> ratings;

    public RatingCalc(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public double getAvgRat() {
        double avg = 0;
        int count = 0;
        for (Rating rat : ratings) {
            avg += rat.getRatng();
            count++;
        }

        return avg / (double) count;
    }
}
