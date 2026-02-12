public class CircularDoublyLinkedList {

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

        Node tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;

        head = newNode;
    }

    public void insertAtEnd(int data) {
        if (head == null) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
    }

    public void delete(int key) {
        if (head == null) return;

        Node current = head;

        do {
            if (current.data == key) {

                if (current.next == current) {
                    head = null;
                    return;
                }

                current.prev.next = current.next;
                current.next.prev = current.prev;

                if (current == head) {
                    head = current.next;
                }

                return;
            }
            current = current.next;
        } while (current != head);
    }

    public void display() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }
}
