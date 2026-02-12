public class UnboundedArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int data) {
        if (top + 1 == capacity) {
            resize(capacity * 2);
        }

        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        int popped = stack[top--];

        if (top + 1 > 0 && top + 1 == capacity / 4) {
            resize(capacity / 2);
        }

        return popped;
    }

    private void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity = newCapacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
