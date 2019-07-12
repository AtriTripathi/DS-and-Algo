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

    private int peek() {
        return arr[topOfStack];
    }

    private void pushMany(String multipleValues) {
        String[] values = multipleValues.split(" ");
        for (String value : values) {
            push(Integer.parseInt(value));
        }
    }

    private void printStack() {
        for (int i=0; i<=topOfStack; i++) {
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
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

        stack.pushMany("12 7 87 24");
        stack.printStack();

        System.out.println(stack.peek());
    }
}
