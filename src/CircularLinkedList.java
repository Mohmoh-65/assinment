package assignment_1;

public class CircularLinkedList {

    // Node class for circular linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Basic operations
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty");
            return;
        }

        System.out.print("Circular Linked List: ");
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    // Question 15: Insert a node at specific position
    public void insertAt(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(data);

        if (position == 0) { // Insert at head
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
        } else if (position == size) { // Insert at tail
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        } else { // Insert in middle
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Question 16: Delete a node from specific position
    public void deleteAt(int position) {
        if (position < 0 || position >= size || head == null) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 0) { // Delete head
            if (head == tail) { // Only one node
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (position == size - 1) { // Deleting tail
                tail = current;
            }
        }
        size--;
    }

    // Question 17: Search for an element in circular linked list
    public int search(int element) {
        if (head == null) return -1;

        Node current = head;
        int position = 0;

        do {
            if (current.data == element) {
                return position;
            }
            current = current.next;
            position++;
        } while (current != head);

        return -1; // Element not found
    }

    // Question 18: Split circular linked list into two halves
    public CircularLinkedList[] split() {
        CircularLinkedList[] halves = new CircularLinkedList[2];
        halves[0] = new CircularLinkedList();
        halves[1] = new CircularLinkedList();

        if (head == null) return halves;

        // Find middle
        Node slow = head;
        Node fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // First half
        Node current = head;
        do {
            halves[0].add(current.data);
            current = current.next;
        } while (current != slow.next);

        // Second half
        current = slow.next;
        do {
            halves[1].add(current.data);
            current = current.next;
        } while (current != head);

        return halves;
    }
}