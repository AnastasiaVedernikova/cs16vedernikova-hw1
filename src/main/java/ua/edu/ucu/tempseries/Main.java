package ua.edu.ucu.tempseries;

/**
 * Created by cs.ucu.edu.ua on 07.10.2016.
 */
public class Main {
    public static void main(String[] array) {

        TemperatureSeriesAnalysis Tak = new TemperatureSeriesAnalysis(new double[] {1,5,7,8,-1,-2,100});
        // System.out.println(Tak.addTemps(new double[]{2,3}));
        System.out.println(Tak.average());
        System.out.println(Tak.deviation());
        System.out.println(Tak.findTempClosestToValue(5));
        System.out.println(Tak.findTempClosestToZero());
        Tak.findTempsGreaterThen(6);
        System.out.println(Tak);
        Tak.findTempsLessThen(20);
        System.out.println(Tak);
        System.out.println(Tak.max());
        System.out.println(Tak.min());
        System.out.println(Tak);


    }

}