import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlgorithmVisualizationLogic {

    private static Scanner scanner = new Scanner(System.in);

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void quickSort(int[] array, int low, int high) {
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

    private static void mergeSort(int[] array, int left, int right) {
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

    public static void main(String[] args) {
        int size = getSizeFromUser();

        int[] array = getArrayFromUser(size);
        System.out.println("Original Array: " + Arrays.toString(array));

        while (true) {
            int sortChoice = getSortChoiceFromUser();
            switch (sortChoice) {
                case 1:
                    // Quick Sort
                    quickSort(array, 0, array.length - 1);
                    System.out.println("After Quick Sort: " + Arrays.toString(array));
                    break;

                case 2:
                    // Merge Sort
                    int[] arrayCopy = Arrays.copyOf(array, array.length);
                    mergeSort(arrayCopy, 0, arrayCopy.length - 1);
                    System.out.println("After Merge Sort: " + Arrays.toString(arrayCopy));
                    break;

                case 3:
                    // Backtrack and choose array size again
                    size = getSizeFromUser();
                    array = getArrayFromUser(size);
                    System.out.println("Original Array: " + Arrays.toString(array));
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }

    private static int getSizeFromUser() {
        int size = 0;
        while (true) {
            try {
                System.out.print("Enter the size of the array: ");
                size = scanner.nextInt();
                if (size <= 0) {
                    throw new InputMismatchException();
                }
                break; // If no exception, break out of the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.nextLine(); // Clear the buffer
            }
        }
        return size;
    }

    private static int[] getArrayFromUser(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = getElementFromUser(i + 1);
        }
        return array;
    }

    private static int getElementFromUser(int index) {
        int attempts = 3;
        while (attempts > 0) {
            try {
                System.out.print("Element " + index + ": ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the buffer
                attempts--;

                if (attempts == 0) {
                    System.out.println("Sorry, your attempts are over. Exiting the program.");
                    System.exit(0);
                } else {
                    System.out.println("You have " + attempts + " attempts remaining.");
                }
            }
        }
        return 0; // This line should not be reached
    }

    private static int getSortChoiceFromUser() {
        while (true) {
            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Quick Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Backtrack and choose array size again");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1, 2, 3, or 4): ");

            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }
}
