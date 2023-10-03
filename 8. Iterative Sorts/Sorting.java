import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.Random;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author RAÚL AVILÉS RODRÍGUEZ
 * @version 1.0
 * @userid bravil
 * @GTID 997 (i.e. 900000000)
 *
 * Collaborators: NONE
 *
 * Resources: NONE
 */
public class Sorting {


    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for bubble sort. You
     * MUST implement bubble sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }
        if(comparator == null){
            throw new IllegalArgumentException("Cannot sort with a null comparator PARCE");
        }

        int swapCount = 0;
        int compaCount = 0;

        int end = arr.length - 1;
        int start = 0;
        while(end != 0){
            int i = start;
            int swapped = start;
            while(i < end){
                if(comparator.compare(arr[i], arr[i+1])>0){
                    T dummy = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = dummy;
                    swapped = i;
                    swapCount++;
                }
                i++;
                compaCount++;
            }
            end = swapped;
        }
        System.out.println("SWAP COUNT:" + swapCount);
        System.out.println("COMPARASION COUNT:" + compaCount);
    }


    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n^2)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }
        if(comparator == null){
            throw new 
            IllegalArgumentException("Cannot sort with a null comparator PARCE");
        }

        int swapCount = -1;
        int compaCount = 0;

        for(int i = arr.length-1; i>=0; i--){
            int max = i;
            for(int j= i -1; j>=0; j--){
                if(comparator.compare(arr[j], arr[max])>0){
                    max = j;
                }
                compaCount++;
            }
            T dummy = arr[i];
            arr[i] = arr[max];
            arr[max] = dummy;
            swapCount++;
        }
        System.out.println("SWAP COUNT:" + swapCount);
        System.out.println("COMPARASION COUNT:" + compaCount);
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if(arr == null){
            throw new IllegalArgumentException("Cannot sort null array BROO");
        }
        if(comparator == null){
            throw new 
            IllegalArgumentException("Cannot sort with a null comparator PARCE");
        }

        int swapCount = 0;

        for(int i = 1; i<= arr.length-1; i++){
            int j = i;
            while(j>0 && comparator.compare(arr[j-1], arr[j])>0){
                T dummy = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = dummy;
                j--;
                swapCount++;
            }
        }

        System.out.println("SWAP COUNT:" + swapCount);

    }

    /**
     * Implement cocktail sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for cocktail sort. You
     * MUST implement cocktail sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        
    }

    
}