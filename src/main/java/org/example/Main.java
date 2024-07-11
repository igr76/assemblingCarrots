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
                if (copyArray[i] == MAX_WEIGHT) {//совпадение с максимальным весом
                    totalHarvest+=copyArray[i];trips++;}else
                if (copyArray[i] != 0) {
                    for (int j = 1; j < copyArray.length; j++) {
                        int currentWeight=0;int currentTotalWeight=0; int currentPosition=0;//накопление веса
                            currentWeight=copyArray[i] + copyArray[j];
                        if (currentTotalWeight < currentWeight && currentWeight<MAX_WEIGHT) {
                            currentTotalWeight = currentWeight;
                            currentPosition = j;
                        }else if (currentWeight == MAX_WEIGHT) {// сумма с максимальным весом
                                totalHarvest += currentWeight;
                                copyArray[j] = 0;
                                trips++;j=copyArray.length;
                        } else if (j == copyArray.length) {// учесть наибольший  вес от максимального
                            totalHarvest += currentTotalWeight;
                            copyArray[currentPosition] = 0;
                            trips++;
                        }
                        if (trips>=MAX_TRIPS) {return totalHarvest;}
                    }
                }
                if (trips>=MAX_TRIPS) {return totalHarvest;}
            }
        }
    }
}