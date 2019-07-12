public class BinarySearch {
    private int[] arr;

    private BinarySearch(int[] data) {
        arr = data;
    }

    // Logic for Binary Search
    private int getIndex(int value) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi)/2;

            if (value < arr[mid])   hi = mid - 1;
            else if (value > arr[mid])  lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Data should be sorted beforehand
        int data[] = {-5, -2, 0, 3, 4, 7, 9, 10};

        BinarySearch binarySearch = new BinarySearch(data);

        int index = binarySearch.getIndex(-2);

        if (index != -1)
            System.out.println("Element found at position: " + (index + 1));
        else
            System.out.println("Element not found in the list");
    }

}
