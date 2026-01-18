package assignment_1;

import java.util.Arrays;
import java.util.Random;

public class ArrayOperations {

    // Question 1: Clone an array
    public static int[] cloneArray(int[] original) {
        System.out.println("Original array: " + Arrays.toString(original));
        int[] cloned = original.clone();
        System.out.println("Cloned array: " + Arrays.toString(cloned));
        return cloned;
    }

    // Question 2: Remove a random element from an array
    public static int[] removeRandomElement(int[] array) {
        if (array.length == 0) {
            System.out.println("Array is empty!");
            return array;
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(array.length);
        System.out.println("Removing element at index " + randomIndex + " (value: " + array[randomIndex] + ")");

        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != randomIndex) {
                newArray[j++] = array[i];
            }
        }

        System.out.println("Array after removal: " + Arrays.toString(newArray));
        return newArray;
    }

    // Question 3: Remove a specific element from an array
    public static int[] removeSpecificElement(int[] array, int element) {
        System.out.println("Removing element: " + element + " from array: " + Arrays.toString(array));

        int count = 0;
        for (int value : array) {
            if (value == element) count++;
        }

        if (count == 0) {
            System.out.println("Element not found in array!");
            return array;
        }

        int[] newArray = new int[array.length - count];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != element) {
                newArray[j++] = array[i];
            }
        }

        System.out.println("Array after removal: " + Arrays.toString(newArray));
        return newArray;
    }

    // Question 4: Reverse an array
    public static void reverseArray(int[] array) {
        System.out.println("Original array: " + Arrays.toString(array));

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        System.out.println("Reversed array: " + Arrays.toString(array));
    }
}