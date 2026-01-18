package assignment_1;

public class DoublyLinkedList {

    // Node class for doubly linked list
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Basic operations
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void display() {
        Node current = head;
        System.out.print("Doubly Linked List (forward): ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Question 12: Remove duplicates from doubly linked list
    public void removeDuplicates() {
        if (head == null) return;

        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    // Remove runner node
                    if (runner.prev != null) {
                        runner.prev.next = runner.next;
                    }
                    if (runner.next != null) {
                        runner.next.prev = runner.prev;
                    }
                    if (runner == tail) {
                        tail = runner.prev;
                    }
                    size--;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }

    // Question 13: Traverse in reverse and print all elements
    public void traverseReverse() {
        System.out.print("Doubly Linked List (reverse): ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Question 14: Search for an element in doubly linked list
    public int search(int element) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.data == element) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1; // Element not found
    }
}