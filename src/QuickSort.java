public class QuickSort {
    private void swap(int[] arr, int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,high);
        return i;
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr,low,high);

            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }
    }

    private void printArray(int[] arr) {
        for (int val: arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int data[] = {7, 9, 5, 2, -5, -1, -2, 0, 4, 3};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(data,0,data.length-1);
        quickSort.printArray(data);
    }
}
