import java.util.ArrayList;

public class LinearSearch {
    private int[] arr;

    private LinearSearch(int[] data) {
        arr = data;
    }

    // Logic for Linear Search
    private int getIndex(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    // (Optional) Logic to return the indices of all occurrences
    private ArrayList<Integer> getIndices(int value) {
        ArrayList<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                indexList.add(i);
        }
        return indexList;
    }

    public static void main(String[] args) {
        int data[] = {7, 9, 5, 2, -5, -1, -2, 0, 4, 3};

        LinearSearch linearSearch = new LinearSearch(data);

        int index = linearSearch.getIndex(2);

        if (index != -1)
            System.out.println("Element found at position: " + (index + 1));
        else
            System.out.println("Element not found in the list");

        // Optional Part
        ArrayList<Integer> indices = linearSearch.getIndices(2);
        System.out.println("Element found at positions: " + (indices));
    }
}
