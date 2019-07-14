public class Queue {
    private int[] arr;
    private int front = 0, rear = 0, numberOfItems = 0;
    private int queueSize;

    private Queue(int size) {
        arr = new int[size];
        queueSize = size;
    }

    private void insert(int value) {
        if (numberOfItems + 1 < queueSize) {
            arr[rear] = value;
            rear++;
            numberOfItems++;
            printQueue();
        } else System.out.println("Queue is full");
    }

    // This is the only function which is different in Priority Queue where the value is inserted in decreasing order
    private void priorityInsert(int value) {
        if (numberOfItems == 0) {
            insert(value);
        } else {
            int i;
            for(i = numberOfItems-1; i>=0; i--) {
                if (value > arr[i]) {
                    arr[i+1] = arr[i];
                } else break;
            }
            arr[i+1] = value;
            rear++;
            numberOfItems++;
        }
    }

    private void remove() {
        if (numberOfItems > 0) {
            arr[front] = 0;
            front++;
            numberOfItems--;
            printQueue();
        } else System.out.println("Queue is empty");
    }

    private void printQueue() {
        for (int val: arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.insert(2);
        queue.insert(4);
        queue.insert(7);
//        queue.remove();
        queue.insert(1);
        queue.insert(9);
        queue.insert(5);
    }
}
