/*
 * Developed by Atri Tripathi on 18/7/19 4:51 PM
 * Last modified 18/7/19 4:51 PM
 * Copyright (c) 2019. All rights reserved
 */

import java.util.Arrays;

/*
Note: In Hash Table, it is always preferable to have the array size which is at least twice the size of the
number of elements, at the minimum. This ensures lesser number of collisions.
 */
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
            int arrIndex = value % arrSize;     // Restrict the array index within the array size

            // If collision, look for next empty index
            while (arr[arrIndex] != -1) {
                ++arrIndex;
                System.out.println("Collision, Try " + arrIndex + " instead.");
                arrIndex %= arrSize;        // To reset the index once it crosses the array size
            }

            arr[arrIndex] = value;          // No collision, therefore insert the value
        }
    }


    /*
    This function is used to prevent Clustering of data, where due to collisions the values are added to the
    immediate next indices. Hence, to overcome this, we randomize the Step distance.
     */
    private void doubleHashFunction(int[] data) {
        for (int value : data) {
            int arrIndex = value % arrSize;     // Restrict the array index within the array size

            int stepDistance = 7 - (value % 7);   // Randomizes the number of places to jump when collision happens,
                                                  // Select any prime number (eg: here we chose 7). Use trial and error
            // If collision, look for next empty index
            while (arr[arrIndex] != -1) {
                arrIndex += stepDistance;

                System.out.println("Collision, Try " + arrIndex + " instead.");
                arrIndex %= arrSize;        // To reset the index once it crosses the array size
            }

            arr[arrIndex] = value;          // No collision, therefore insert value
        }
    }

    private void findKey(int key) {
        int arrIndex = key % arrSize;

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

        int[] data = {1,2,5,17,7,39,9,31,29};

        hashTable.hashFunction(data);
        hashTable.printArray();
        hashTable.findKey(31);

        System.out.println();

        int[] dataForCollision = {3,2,5,17,7,39,9,31,29,23,4,3,43,53,23,56,65,34,23,66,46,33,65,};

        HashTable doubleHashTable = new HashTable(60);
        doubleHashTable.doubleHashFunction(dataForCollision);
        doubleHashTable.printArray();
    }
}
