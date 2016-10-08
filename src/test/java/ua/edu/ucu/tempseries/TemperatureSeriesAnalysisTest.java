package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {//average    one el
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class) //         exception
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() { //                               normal
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviation(){                       //deviation normal
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 31.963758774587195;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class) //         exception
    public void testDeviationWithEmptyArray() {
       double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }
    @Test
    public void testDeviationWithOneElementArray() {//    one el
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {//min   one el
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class) //         exception
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Test
    public void testMin(){                       //min  normal
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -2.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {//max   one el
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class) //         exception
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Test
    public void testMax(){                       //max  normal
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 100.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testClosestToValue(){                       //closest to value  normal
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(5);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class) //         exception
    public void testClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(5);
    }

    @Test
    public void testClosestToValueWithOneElementArray() {//   one el
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(3);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZero(){                       //closest to zero  normal
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -0.7;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class) //         exception
    public void testClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testClosestToZeroWithOneElementArray() {//   one el
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testGreaterThenValue(){                       //greater then value  normal
       double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[4];//"[7.0,8.0,23.0,100.0]";
        expResult[0] = 7.0;
        expResult[1] = 8.0;
        expResult[2] = 23.0;
        expResult[3] = 100.0;
       // Arrays.toString(expResult);
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(6);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testGreaterThenValueWithOneElementArray() {//   one el
        double[] temperatureSeries = {-0.7};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[0];
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(7);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testLessThenValue(){                       //less then value  normal
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[3];//"[-0.7, 1.1, -2.0]";
        expResult[0] = -0.7;
        expResult[1] = 1.1;
        expResult[2] = -2.0;
        double[] actualResult = seriesAnalysis.findTempsLessThen(5);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testLessThenValueWithOneElementArray() {//   one el
        double[] temperatureSeries = {-0.7};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[1]; //"[-0,7]";
        expResult[0] = -0.7;
        double[] actualResult = seriesAnalysis.findTempsLessThen(3);
        assertEquals(Arrays.toString(expResult),Arrays.toString(actualResult));
    }

    @Test
    public void testTempSummeryStatistic() { //            summeryStatistic           normal
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 17.675;
        double actualResult = seriesAnalysis.summaryStatistics().getAvgTemp();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTemps() { //            addTemps          normal
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 11;
        int actualResult = seriesAnalysis.addTemps(1,2,3);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempWithOneElementArray() {//   one el
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 2;
        int actualResult = seriesAnalysis.addTemps(4);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class) //         exception <273
    public void testAddTempTooNegative() {
        double[] temperatureSeries = {8.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(-274);
    }

}
