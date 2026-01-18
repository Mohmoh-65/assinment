package assignment_1;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Data Structure Assignment 1 - Ali Alsadiq ===\n");

        // Test Array Operations
        System.out.println("=== ARRAY OPERATIONS ===");
        int[] testArray = {1, 2, 3, 4, 5, 2, 6};

        // Q1: Clone array
        System.out.println("\n--- Q1: Clone Array ---");
        ArrayOperations.cloneArray(testArray);

        // Q2: Remove random element
        System.out.println("\n--- Q2: Remove Random Element ---");
        ArrayOperations.removeRandomElement(testArray);

        // Q3: Remove specific element
        System.out.println("\n--- Q3: Remove Specific Element ---");
        ArrayOperations.removeSpecificElement(testArray, 2);

        // Q4: Reverse array
        System.out.println("\n--- Q4: Reverse Array ---");
        ArrayOperations.reverseArray(testArray.clone());

        // Test Singly Linked List
        System.out.println("\n\n=== SINGLY LINKED LIST ===");
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1); sll.add(2); sll.add(3); sll.add(4); sll.add(5);
        sll.display();

        // Q5: Concatenate two lists
        System.out.println("\n--- Q5: Concatenate Lists ---");
        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.add(6); sll2.add(7); sll2.add(8);
        sll.concatenate(sll2);
        sll.display();

        // Q6: Rotate right
        System.out.println("\n--- Q6: Rotate Right by 2 ---");
        sll.rotateRight(2);
        sll.display();

        // Q7 & 8: Search element
        System.out.println("\n--- Q7 & 8: Search Element ---");
        System.out.println("Position of 4: " + sll.search(4));
        System.out.println("Position of 10: " + sll.search(10));

        // Q9: Remove at position
        System.out.println("\n--- Q9: Remove at Position 2 ---");
        sll.removeAt(2);
        sll.display();

        // Test Doubly Linked List
        System.out.println("\n\n=== DOUBLY LINKED LIST ===");
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(1); dll.add(2); dll.add(3); dll.add(2); dll.add(4); dll.add(3);
        dll.display();

        // Q12: Remove duplicates
        System.out.println("\n--- Q12: Remove Duplicates ---");
        dll.removeDuplicates();
        dll.display();

        // Q13: Traverse reverse
        System.out.println("\n--- Q13: Traverse Reverse ---");
        dll.traverseReverse();

        // Q14: Search element
        System.out.println("\n--- Q14: Search Element ---");
        System.out.println("Position of 3: " + dll.search(3));

        // Test Circular Linked List
        System.out.println("\n\n=== CIRCULAR LINKED LIST ===");
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(1); cll.add(2); cll.add(3); cll.add(4); cll.add(5);
        cll.display();

        // Q15: Insert at position
        System.out.println("\n--- Q15: Insert at Position 2 ---");
        cll.insertAt(10, 2);
        cll.display();

        // Q16: Delete at position
        System.out.println("\n--- Q16: Delete at Position 3 ---");
        cll.deleteAt(3);
        cll.display();

        // Q17: Search element
        System.out.println("\n--- Q17: Search Element ---");
        System.out.println("Position of 10: " + cll.search(10));

        // Q18: Split list
        System.out.println("\n--- Q18: Split List ---");
        CircularLinkedList[] halves = cll.split();
        System.out.println("First half:");
        halves[0].display();
        System.out.println("Second half:");
        halves[1].display();

        System.out.println("\n=== All operations completed successfully! ===");
    }
}