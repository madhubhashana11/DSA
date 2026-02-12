import java.util.Stack;

public class StackQueueDequeueFriendly {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public StackQueueDequeueFriendly() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue - O(n)
    public void enqueue(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(data);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue - O(1)
    public int dequeue() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        return s1.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
