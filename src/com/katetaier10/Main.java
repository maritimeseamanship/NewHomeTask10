package com.katetaier10;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final Random RANDOM = new Random();
    public static final int COUNT = 20;

    public static void main(String[] args) {

        // Реализовать метод который сортирует массив целых чисел быстрой сортировкой.

        int[] arrayRandom = new int[COUNT];
        int low = 0;
        int high = arrayRandom.length - 1;
        arrayRandom = createArray();
        System.out.println("The initial random array is: " + Arrays.toString(arrayRandom));
        quickSort(arrayRandom, low, high);
        System.out.println("The sorted random array is: " + Arrays.toString(arrayRandom));

    }

    private static int[] createArray() {
        int min = 1;
        int max = 100;
        int[] arrayRandom = new int[COUNT];
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = RANDOM.nextInt(max) + min;
        }
        return arrayRandom;
    }

    private static void quickSort(int[] arrayRandom, int low, int high) {
        if(low < high){
            int pivot = partition(arrayRandom, low, high);
            quickSort(arrayRandom, low, pivot-1);
            quickSort( arrayRandom, pivot + 1, high);
        }
    }

    private static void swap(int[] arrayRandom, int low, int pivot){
        int tmp = arrayRandom[low];
        arrayRandom[low] = arrayRandom[pivot];
        arrayRandom[pivot] = tmp;
    }

    private static int partition(int[] arrayRandom, int low, int high){
        int p = low, j;
        for(j = low + 1; j <= high; j++) {
            if(arrayRandom[j] < arrayRandom[low])
                swap(arrayRandom, ++p, j);
        }

        swap(arrayRandom, low, p);
        return p;
    }

}
