package org.example;

import java.util.Arrays;

public class Main {
    private static final int MAX_WEIGHT = 5;
    private static final int MAX_TRIPS = 10;
    public static void main(String[] args) {

        System.out.println("Максимальное количество собранной моркови за  " +
                MAX_TRIPS + "  ходок - " + algorithmHarvest(new int[]{1,2,3,4,5}) + " кг.");
    }

    public static int algorithmHarvest(int[] array) {
        int totalHarvest = 0;
        int trips = 0;
        while (true) {
            int[] copyArray = Arrays.copyOf(array, array.length);
            for (int i = 0; i < copyArray.length; i++) {
                if (copyArray[i] != 0) {
                    for (int j = 1; j < copyArray.length; j++) {
                        if (copyArray[i] == MAX_WEIGHT) {
                            totalHarvest+=copyArray[i];trips++;}else
                                if ((copyArray[i] +copyArray[j])== MAX_WEIGHT) {
                            totalHarvest=copyArray[i]+copyArray[j];
                            copyArray[j]=0; trips++;break;}
                    }
                }
                if (trips>=MAX_TRIPS) {return totalHarvest;}
            }
        }
    }
}