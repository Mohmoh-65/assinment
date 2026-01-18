package assignment_1;

public class SinglyLinkedList {

    // Node class for singly linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Basic operations
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void display() {
        Node current = head;
        System.out.print("Singly Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Question 5: Concatenate two linked lists
    public void concatenate(SinglyLinkedList list2) {
        if (this.head == null) {
            this.head = list2.head;
        } else if (list2.head != null) {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = list2.head;
        }
        this.size += list2.size;
    }

    // Question 6: Rotate linked list to the right by k places
    public void rotateRight(int k) {
        if (head == null || head.next == null || k == 0) {
            return;
        }

        // Calculate length
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return;

        // Find the new tail (length - k - 1)
        Node newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        head = newHead;
    }

    // Question 7 & 8: Search for element and return its position
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

    // Question 9: Remove at specific position
    public void removeAt(int position) {
        if (position < 0 || position >= size || head == null) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
}