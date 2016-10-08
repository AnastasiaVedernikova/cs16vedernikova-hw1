package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;
    private int LogicalSize = 0;
    public TemperatureSeriesAnalysis() {
        double[] temperatureSeries = new double[10];
        int LogicalSize = 10;
        for ( int i = 0; i < 10; i++) {
            temperatureSeries[i] = i;
        }
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        this.LogicalSize = temperatureSeries.length;
        // System.out.println(temperatureSeries);

    }

    public double average() {
        if (this.temperatureSeries.length != 0) {
            double sum = 0;
            int am = 0;
            double av;
            for ( double i: this.temperatureSeries ){
                sum += i;
                am += 1;
            }
            av = sum/am;
            return av;
        } else {
            throw new IllegalArgumentException("try again");
        }

    }

    public double deviation() {
        if (this.temperatureSeries.length != 0) {
            double skv;
            double sum = 0;
            for (double i : this.temperatureSeries) {
                sum += Math.pow(i - this.average(), 2);
            }
            skv = Math.sqrt(sum / this.temperatureSeries.length);
            return skv;
        } else {
            throw new IllegalArgumentException("try again");
        }
    }

    public double min(){
        if (this.temperatureSeries.length != 0){
            double min = this.temperatureSeries[0];
            for (int i = 1; i < this.temperatureSeries.length; i++){
                if (this.temperatureSeries[i] < min) {
                    min = this.temperatureSeries[i];
                }
            }
            return min;
        } else {
            throw new IllegalArgumentException("try again");
        }
    }

    public double max() {
        if (this.temperatureSeries.length != 0){
            double max = this.temperatureSeries[0];
            for (int i = 1; i < this.temperatureSeries.length; i++){
                if (this.temperatureSeries[i] > max){
                    max = this.temperatureSeries[i];
                }
            }
            return max;
        } else {
            throw new IllegalArgumentException("try again");
        }
    }

    public double findTempClosestToZero() {
        if (this.temperatureSeries.length != 0) {
            double maxneg = -99999998;
            double minpos = 999999989;
            for (double i: this.temperatureSeries) {
                if (i >= 0 && i < minpos) {
                    minpos = i;
                } else if (i < 0 && i > maxneg) {
                    maxneg = i;
                }
            }
            if (maxneg * (-1) == minpos) {
                return minpos;
            } else if (maxneg * (-1) > minpos) {
                return minpos;
            } else {
                return maxneg;
            }
        } else {
            throw new IllegalArgumentException("try again");
        }
    }

    public double findTempClosestToValue(double tempValue) {
        if (this.temperatureSeries.length != 0) {
            if (this.temperatureSeries.length == 1 ){
                return this.temperatureSeries[0];
            }
            int amTo = 0;
            int amAfter = 0;
            for (double i:this.temperatureSeries) {
                if (i >= tempValue) {
                    amAfter += 1;
                } else {
                    amTo += 1;
                }
            }
            int arToInd = 0;
            int arAfterInd = 0;
            double[] arTo = new double[amTo];
            double[] arAfter = new double[amAfter];
            for (double i: this.temperatureSeries) {
                if (i >= tempValue) {
                    arAfter[arAfterInd] = i;
                    arAfterInd += 1;
                } else {
                    arTo[arToInd] = i;
                    arToInd += 1;
                }
            }
            Arrays.sort(arTo);
            Arrays.sort(arAfter);
            if (arTo[arTo.length-1] > 0 && arAfter[0] > 0) {
                if (tempValue - arTo[arTo.length-1] < arAfter[0] - tempValue) {
                    return arTo[arTo.length-1];
                } else {
                    return arAfter[0];
                }

            } else if (arTo[arTo.length-1] < 0 && arAfter[0] < 0) {
                if (arTo[arTo.length-1] * (-1) - tempValue * (-1) > tempValue * (-1) - arAfter[0] * (-1)) {
                    return arAfter[0];
                } else {
                    return arTo[arTo.length-1];
                }
            } else if (arTo[arTo.length-1] < 0 && arAfter[0] > 0) {
                if (tempValue >= 0) {
                    if (arAfter[0] - tempValue <= arTo[arTo.length-1] * (-1) + tempValue) {
                        return arAfter[0];
                    } else {
                        return arTo[arTo.length-1];
                    }
                } else {
                    if (arAfter[0] + (-1) * tempValue <= arTo[arTo.length-1] * (-1) - (-1) * tempValue) {
                        return arAfter[0];
                    } else {
                        return arTo[arTo.length-1];
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("try again");
        }
        return 0.0;
    }
    public String toString(){
        return Arrays.toString(this.temperatureSeries);
    }

    public double[] findTempsLessThen(double tempValue) {
        int am = 0;
        for(double i:this.temperatureSeries){
            if (i < tempValue){
                am += 1;
            }
        }
        int[] less = new int[am];
        int lastIndex = 0;
        for(int i=0; i < this.temperatureSeries.length; i++) {
            if (this.temperatureSeries[i] < tempValue){
                less[lastIndex] = i;
                lastIndex += 1;
            }
        }
        double[] lessNum = new double[am];
        for(int i=0; i<less.length; i++) {
            lessNum[i] = this.temperatureSeries[less[i]];
        }
        return lessNum;
    }


    public double[] findTempsGreaterThen(double tempValue) {
        int am = 0;
        for(double i: this.temperatureSeries) {
            if (i >=  tempValue) {
                am += 1;
            }
        }
        double[] greater = new double[am];
        int lastIndex = 0;
        for(double i: this.temperatureSeries) {
            if (i >= tempValue){
                greater[lastIndex] = i;
                lastIndex += 1;
            }
        }
        return greater;

    }

    public TempSummaryStatistics summaryStatistics() {
         return new TempSummaryStatistics(average(), deviation(), min(), max());
      }

    public int addTemps(double... temps) {
        for(double i: temps) {
            if(i < -273.1) {
                throw new InputMismatchException();
            }
        }
        if (this.temperatureSeries.length == this.LogicalSize) {//create larger array
            double[] lid = new double[this.temperatureSeries.length * 2];
            for (int i = 0; i < this.temperatureSeries.length; i++) {
                lid[i] = this.temperatureSeries[i];
            }
            this.temperatureSeries = lid;
        }
        for(double k: temps){
            this.temperatureSeries[this.LogicalSize] = k;
            this.LogicalSize += 1;
        }
        return this.LogicalSize;
    }
}
