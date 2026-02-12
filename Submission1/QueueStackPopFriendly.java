import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public QueueStackPopFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push - O(n)
    public void push(int data) {
        q2.add(data);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop - O(1)
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return q1.remove();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
