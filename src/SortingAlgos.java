public class SortingAlgos {
    private void swap(int[] arr, int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }

    private void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private void bubbleSort(int[] arr) {
        System.out.println();
        for (int i = arr.length-1; i > 1 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
        System.out.println();
        printArray(arr);
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(arr,i,min);
        }
        System.out.println();
        printArray(arr);
    }

    private void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int toInsert = arr[i];

            while ((j > 0) && (arr[j-1] > toInsert)) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = toInsert;
        }
        System.out.println();
        printArray(arr);
    }

    public static void main(String[] args) {
        int data[] = {7, 9, 5, 2, -5, -1, -2, 0, 4, 3};

        SortingAlgos sorting = new SortingAlgos();

        sorting.bubbleSort(data);
        sorting.selectionSort(data);
        sorting.insertionSort(data);
    }
}
