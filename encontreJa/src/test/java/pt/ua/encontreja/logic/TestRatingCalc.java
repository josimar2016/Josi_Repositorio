package pt.ua.encontreja.logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import logic.RatingCalc;
import org.junit.Before;
import org.junit.Test;
import pt.ua.encontreja.entity.Rating;
import static org.junit.Assert.*;

/**
 *
 * @author mezca
 */
public class TestRatingCalc {
    
    private RatingCalc ratingCal;
    private static final double DELTA = 1e-15;
    
    @Before
    public void setUp() 
    {
       
        List<Rating> ratings = new ArrayList<>();
        Rating rat1 = new Rating();
        rat1.setRtng(5);
        
        Rating rat2 = new Rating();
        rat2.setRtng(3);
        
        Rating rat3 = new Rating();
        rat3.setRtng(4);
        
        ratings.add(rat1);
        ratings.add(rat2);
        ratings.add(rat3);
        ratingCal = new RatingCalc(ratings);
        
    }
    
    @Test
    public void testGetAvgRat() 
    {
        
        double res = ((5+3+4) / 3);
        assertEquals("average user rating",res, ratingCal.getAvgRat(),DELTA);
       
    }
    
}
