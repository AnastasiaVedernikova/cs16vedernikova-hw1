package ua.edu.ucu.tempseries;

//import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by cs.ucu.edu.ua on 07.10.2016.
 */
public class Main {
    public static void main(String[] array) {
        TemperatureSeriesAnalysis Tak = new TemperatureSeriesAnalysis(new double[] {8});
        System.out.println(Tak.average());
        System.out.println(Tak.deviation());
        System.out.println(Tak.findTempClosestToValue(5));
        System.out.println(Tak.findTempClosestToZero());
        System.out.println(Arrays.toString(Tak.findTempsGreaterThen(6)));
        System.out.println(Arrays.toString(Tak.findTempsLessThen(5)));
        System.out.println(Tak.max());
        System.out.println(Tak.min());
        System.out.println(Tak.summaryStatistics().getAvgTemp());
        System.out.println(Tak.addTemps(-273));
        System.out.println(Tak.addTemps(5));
        System.out.println(Tak);
    }
}