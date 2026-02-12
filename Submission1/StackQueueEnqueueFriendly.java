import java.util.Stack;

public class StackQueueEnqueueFriendly {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public StackQueueEnqueueFriendly() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue - O(1)
    public void enqueue(int data) {
        s1.push(data);
    }

    // Dequeue - O(n)
    public int dequeue() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        int removed = s1.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return removed;
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
