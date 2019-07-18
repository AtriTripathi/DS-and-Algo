/*
 * Developed by Atri Tripathi on 18/7/19 4:51 PM
 * Last modified 18/7/19 4:51 PM
 * Copyright (c) 2019. All rights reserved
 */

import java.util.Arrays;

public class HashTable {
    private int[] arr;
    private int arrSize;

    private HashTable(int size) {
        arr = new int[size];
        arrSize = size;
        Arrays.fill(arr,-1);        // Initialize the array
    }

    private void hashFunction(int[] data) {
        for (int value : data) {
            int arrIndex = value % (arrSize-1);     // eg: 29, if the chosen array size is 30

            // If collision, look for next empty index
            while (arr[arrIndex] != -1) {
                ++arrIndex;
                System.out.println("Collision, Try " + arrIndex + " instead.");
                arrIndex %= arrSize;        // To reset the index once it crosses the array size
            }

            arr[arrIndex] = value;          // No collision, therefore insert value
        }
    }

    private void findKey(int key) {
        int arrIndex = key % (arrSize-1);

        while (arr[arrIndex] != -1) {
            if (arr[arrIndex] == key) {
                System.out.println(key + " was found at index " + arrIndex);
            }

            ++arrIndex;
            arrIndex %= arrSize;        // To reset the index once it crosses the array size
        }
    }

    private void printArray() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(30);

        int[] data = {2,5,17,7,39,9};

        hashTable.hashFunction(data);
        hashTable.printArray();
        hashTable.findKey(39);
    }
}
