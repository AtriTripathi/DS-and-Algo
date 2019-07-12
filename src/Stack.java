public class Stack {
    private int[] arr;
    private int topOfStack = -1;

    private Stack(int size) {
        arr = new int[size];
    }

    private void push(int value) {
        if (topOfStack + 1 < arr.length) {
            topOfStack++;
            arr[topOfStack] = value;
        } else System.out.println("Stack Overflow");
    }

    private int pop() {
        if (topOfStack >= 0)
            return arr[topOfStack--];
        else System.out.println("Stack Underflow");
        return -1;
    }

    private void printStack() {
        for (int i=0; i<=topOfStack; i++) {
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int data[] = {7, 9, 5, 2, -5, -1, -2, 0, 4, 3};

        Stack stack = new Stack(10);

        stack.push(7);
        stack.printStack();

        stack.push(3);
        stack.printStack();

        stack.push(9);
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.push(2);
        stack.printStack();
    }
}
