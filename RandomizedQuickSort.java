import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Lakindu Oshadha (lakinduoshadha98@gmail.com)
 */
public class RandomizedQuickSort {

    /**
     * Takes the first element of given array ( arr )  as pivot and
     * arranges the elements less than pivot in left ( arr[0] - arr[pivot] ) and
     * the elements greater than pivot in right ( arr[pivot] - arr([high] ).
     *
     * @param arr unPartitioned array
     * @param low least index of arr
     * @param high highest index of arr
     * @return index of pivot
     */
    public static int partition(int[] arr, int low, int high){

        // Initializing local variables
        int pivot = arr[low];   // Taking the 1st element as the pivot
        int i = low;
        int temp;

        // arranging the elements less than pivot in left ( arr[0] - arr[pivot] ) and
        // the elements greater than pivot in right ( arr[pivot] - arr([high] ).
        for (int j = low + 1; j <= high; j++){
            if (arr[j] <= pivot){
                i++;
                // Swap elements
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot and arr[i]
        arr[low] = arr[i];
        arr[i] = pivot;

        return i;
    }

    /**
     * Takes a random element of given array ( arr )  as pivot and
     * arranges the elements less than pivot in left ( arr[0] to arr[pivot] ) and
     * the elements greater than pivot in right ( arr[pivot] to arr([high] ).
     *
     * @param arr unPartitioned array
     * @param low least index of arr
     * @param high highest index of arr
     * @return index of pivot
     */
    public static int randomizedPartition (int[] arr, int low, int high) {

        // Creating a random int between low & high
        Random rdm = new Random();
        int random = rdm.nextInt(high - low + 1) + low;

        // Swap the first element with the random element
        int temp = arr[low];
        arr[low] = arr[random];
        arr[random] = temp;

        return partition(arr,low,high);
    }

    /**
     * Sorts the given array in Ascending order with randomized quick sort algorithm.
     *
     * @param arr unSorted array
     * @param low leasr index of arr
     * @param high highest index of arr
     */
    public static void randomizedQuickSort (int[] arr, int low, int high) {

        // Initializing local variables
        int q;

        // Calling randomizedQuickSort method recursively
        if(low < high){
            q = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low,q - 1);
            randomizedQuickSort(arr, q+1, high);
        }

    }

    /**
     * Gives a brief introduction to user
     * Takes the array and the size of the array which is to be sorted from the user.
     *
     * @return inputArray
     * @throws IOException
     */
    public static int[] getInputArray() throws IOException{
        // Giving a brief Introduction to the user
        System.out.print("This program will sort integer numbers in given Array using Randomized Quick Sort.\n" + "n - " +
                "No. of integers in input Array.\n" + "\nEnter input arr size(n): ");

        // Getting input size from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // Getting the unsorted arr from the user
        int[] arr = new int[n];
        int inputSize = 0;
        String input;
        do {
            System.out.print("Enter " + n + " integers, separated using space, to sort (n1 n2 n3 ...): ");
            input = reader.readLine();
            inputSize = input.split(" ").length;
        } while (inputSize != n);

        String[] numbers = input.split(" ");
        for (int j = 0; j < n; j++) {
            arr[j] = Integer.parseInt(numbers[j]);
        }

        return arr;
    }

    /**
     * Takes unSorted and Sorted arrays and
     * Prints them with a brief description.
     *
     * @param unSorted unSorted Array
     * @param sorted Sorted Array
     */
    public static void printReport (int[] unSorted, int[] sorted){
        System.out.println("\n" + "Unsorted Array : " + Arrays.toString(unSorted));
        System.out.println("Sorted Array : " + Arrays.toString(sorted));
    }

    /**
     * Testing randomizedQuickSort method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        int[] unSortedArr = getInputArray();    // Getting the array from the user
        int[] sortedArr = unSortedArr.clone();  // Cloning the unSorted Array

        randomizedQuickSort(sortedArr,0,sortedArr.length - 1);  // Calling the randomizedQuickSort with the clone
        printReport(unSortedArr,sortedArr);     // Printing sorted and unSorted arr

    }

}
