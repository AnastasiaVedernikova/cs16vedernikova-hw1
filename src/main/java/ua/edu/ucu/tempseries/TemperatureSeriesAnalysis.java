package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;
    private int LogicalSize = 0;
    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[10];
        LogicalSize = 10;
        for (int i=0;i<10;i++){
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
            for (double i: this.temperatureSeries){
                sum += i;
                am += 1;
            }
            av = sum/am;
            return av;
        }else{
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
        }else{
            throw new IllegalArgumentException("try again");
        }
    }

    public double min(){
        if (this.temperatureSeries.length != 0){
            double min=this.temperatureSeries[0];
            for (int i=1; i< this.temperatureSeries.length; i++){
                if (this.temperatureSeries[i]< min){
                    min = this.temperatureSeries[i];
                }
            }
            return min;
        }else{
            throw new IllegalArgumentException("try again");
        }
    }

    public double max() {
        if (this.temperatureSeries.length != 0){
            double max=this.temperatureSeries[0];
            for (int i=1; i<this.temperatureSeries.length; i++){
                if (this.temperatureSeries[i]> max){
                    max = this.temperatureSeries[i];
                }
            }
            return max;
        }else{
            throw new IllegalArgumentException("try again");
        }
    }

    public double findTempClosestToZero() {
        if (this.temperatureSeries.length != 0) {
            double max_neg = -99999999;
            double min_pos = 999999999;
            for (double i: this.temperatureSeries) {
                if (i >= 0 && i < min_pos) {
                    min_pos = i;
                } else if (i < 0 && i > max_neg) {
                    max_neg = i;
                }
            }
            if (max_neg * (-1) == min_pos) {
                return min_pos;
            } else if (max_neg * (-1) > min_pos) {
                return min_pos;
            } else {
                return max_neg;
            }
        }else{
            throw new IllegalArgumentException("try again");
        }
    }

    public double findTempClosestToValue(double tempValue) {
        if (this.temperatureSeries.length != 0) {
            if (this.temperatureSeries.length == 1 ){
                return this.temperatureSeries[0];
            }
            int am_to = 0;
            int am_after = 0;
            for (double i:this.temperatureSeries) {
                if (i >= tempValue) {
                    am_after += 1;
                } else {
                    am_to += 1;
                }
            }
            int ar_to_ind = 0;
            int ar_after_ind = 0;
            double[] ar_to = new double[am_to];
            double[] ar_after = new double[am_after];
            for (double i: this.temperatureSeries) {
                if (i >= tempValue) {
                    ar_after[ar_after_ind] = i;
                    ar_after_ind += 1;
                } else {
                    ar_to[ar_to_ind] = i;
                    ar_to_ind += 1;
                }
            }
            Arrays.sort(ar_to);
            Arrays.sort(ar_after);
            if (ar_to[ar_to.length-1] > 0 && ar_after[0] > 0) {
                if (tempValue - ar_to[ar_to.length-1] < ar_after[0] - tempValue) {
                    return ar_to[ar_to.length-1];
                } else {
                    return ar_after[0];
                }

            } else if (ar_to[ar_to.length-1] < 0 && ar_after[0] < 0) {
                if (ar_to[ar_to.length-1] * (-1) - tempValue * (-1) > tempValue * (-1) - ar_after[0] * (-1)) {
                    return ar_after[0];
                } else {
                    return ar_to[ar_to.length-1];
                }
            } else if (ar_to[ar_to.length-1] < 0 && ar_after[0] > 0) {
                if (tempValue >= 0) {
                    if (ar_after[0] - tempValue <= ar_to[ar_to.length-1] * (-1) + tempValue) {
                        return ar_after[0];
                    } else {
                        return ar_to[ar_to.length-1];
                    }
                } else {
                    if (ar_after[0] + (-1) * tempValue <= ar_to[ar_to.length-1] * (-1) - (-1) * tempValue) {
                        return ar_after[0];
                    } else {
                        return ar_to[ar_to.length-1];
                    }
                }
            }
        }else{
            throw new IllegalArgumentException("try again");
        }
        return 0.0;
    }
    public String toString(){
        return Arrays.toString(this.temperatureSeries);
    }

    public double[] findTempsLessThen(double tempValue) {
        int am=0;
        for(double i:this.temperatureSeries){
            if (i<tempValue){
                am += 1;
            }
        }
        int[] less = new int[am];
        int lastIndex = 0;
        for(int i=0; i<this.temperatureSeries.length; i++){
            if (this.temperatureSeries[i]<tempValue){
                less[lastIndex] = i;
                lastIndex += 1;
            }
        }
        double[] less_num = new double[am];
        for(int i=0; i<less.length; i++){
            less_num[i] = this.temperatureSeries[less[i]];
        }
        return less_num;
    }


    public double[] findTempsGreaterThen(double tempValue) {
        int am=0;
        for(double i: this.temperatureSeries){
            if (i>=tempValue){
                am += 1;
            }
        }
        double[] greater = new double[am];
        int lastIndex = 0;
        for(double i:this.temperatureSeries){
            if (i>=tempValue){
                greater[lastIndex] = i;
                lastIndex += 1;
            }
        }
        return greater;

    }

    public TempSummaryStatistics summaryStatistics() {
         return new TempSummaryStatistics(average(),deviation(),min(),max());
      }

    public int addTemps(double... temps) {
        for(double i: temps){
            if(i < -273){
                throw new InputMismatchException();
            }
        }
        if (this.temperatureSeries.length == this.LogicalSize) {//create larger array
            double[] l_d = new double[this.temperatureSeries.length * 2];
            for (int i = 0; i < this.temperatureSeries.length; i++) {
                l_d[i] = this.temperatureSeries[i];
            }
            this.temperatureSeries = l_d;
        }
        for(double k: temps){
            this.temperatureSeries[this.LogicalSize] = k;
            this.LogicalSize += 1;
        }
        return this.LogicalSize;
    }
}
