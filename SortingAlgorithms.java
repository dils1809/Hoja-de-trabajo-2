import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] randomNumbers = generateRandomNumbers(3000);
        saveToFile("random_numbers.txt", randomNumbers);

        int[] orderedNumbers = readFromFile("random_numbers.txt");
        System.out.println("Gnome Sort:");
        gnomeSort(orderedNumbers.clone());
        System.out.println("Merge Sort:");
        mergeSort(orderedNumbers.clone());
        System.out.println("Quick Sort:");
        quickSort(orderedNumbers.clone());
        System.out.println("Radix Sort:");
        radixSort(orderedNumbers.clone());
        System.out.println("Randomized Sort:");
        randomizedSort(orderedNumbers.clone());

        System.out.println("Sorted Numbers:");
        System.out.println(Arrays.toString(orderedNumbers));
    }

    public static int[] generateRandomNumbers(int n) {
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(10000);
        }
        return numbers;
    }

    public static void saveToFile(String fileName, int[] numbers) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (int number : numbers) {
                fileWriter.write(number + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFromFile(String fileName) {
        int[] numbers = new int[3000];
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            for (int i = 0; i < 3000 && scanner.hasNextInt(); i++) {
                numbers[i] = scanner.nextInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public static void gnomeSort(int[] numbers) {
        gnomeSort(numbers, 0, numbers.length - 1);
    }

    public static void gnomeSort(int[] numbers, int left, int right) {
        // gnomeSort
    }

    public static void mergeSort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);
    }

    public static void mergeSort(int[] numbers, int left, int right) {
        // mergeSort
    }

    public static void merge(int[] numbers, int left, int middle, int right) {
        // merge
    }

    public static void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    public static void quickSort(int[] numbers, int low, int high) {
        // quickSort
    }

    public static int partition(int[] numbers, int low, int high) {
        // partition
        return 0;
    }

    public static void radixSort(int[] numbers) {
        int maxNumber = getMaxNumber(numbers);
        for (int exp = 1; maxNumber / exp > 0; exp *= 10) {
            countingSort(numbers, exp);
        }
    }

    public static int getMaxNumber(int[] numbers) {
        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }

    public static void countingSort(int[] numbers, int exp) {
        int[] output = new int[numbers.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // countingSort 
    }

    public static void randomizedSort(int[] numbers) {
        randomizedSort(numbers, 0, numbers.length - 1);
    }

    public static void randomizedSort(int[] numbers, int low, int high) {
        // randomizedSort
    }
}
