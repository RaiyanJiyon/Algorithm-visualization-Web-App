import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmVisualizationLogic {

    private static Scanner scanner = new Scanner(System.in);

    // Quicksort Algorithm
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    // Merge Sort Algorithm
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = Arrays.copyOfRange(array, left, left + n1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, mid + 1 + n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Dijkstra's Algorithm
    public static void dijkstraAlgorithm(/* Add parameters as needed */) {
        // Add Dijkstra's algorithm logic here
        System.out.println("Dijkstra's Algorithm logic will be implemented here.");
    }

    // Helper method to swap elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter elements for the array:");

        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(array));

        // Test Quicksort
        quickSort(array, 0, array.length - 1);
        System.out.println("After Quicksort: " + Arrays.toString(array));

        // Test Merge Sort
        int[] array2 = Arrays.copyOf(array, array.length); // Create a copy for Merge Sort
        mergeSort(array2, 0, array2.length - 1);
        System.out.println("After Merge Sort: " + Arrays.toString(array2));

        // Test Dijkstra's Algorithm
        dijkstraAlgorithm(/* Add parameters as needed */);
    }
}
