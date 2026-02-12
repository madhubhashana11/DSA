import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public QueueStackPushFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push - O(1)
    public void push(int data) {
        q1.add(data);
    }

    // Pop - O(n)
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove();

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
