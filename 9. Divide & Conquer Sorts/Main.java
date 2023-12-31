//import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        Comparacion<Integer> comp = new Comparacion<>();
        

        Integer[] arr2 = {9,13,10,13,10,2,7};
        System.out.println("Unsorted array:");
        String result1 = toString(arr2);
        System.out.println(result1);
        System.out.println("Sorted array with BUBBLE SORT:");
        //Sorting.bubbleSort(arr2, comp);
        Sorting.bubbleSort(arr2, (a, b) -> a - b);
        String resultBubble = toString(arr2);
        System.out.println(resultBubble);

        Integer[] arr3 = {8,5,5,8,7,7,12,13,11,1,1};
        System.out.println("Unsorted array:");
        String result2 = toString(arr3);
        System.out.println(result2);
        System.out.println("Sorted array with SELECTION SORT:");
        Sorting.selectionSort(arr3, (a, b) -> a - b);
        String resultSelection = toString(arr3);
        System.out.println(resultSelection);

        Integer[] arr4 = {8,6,4,3,13,2,2,3,9,3};
        System.out.println("Unsorted array:");
        String result3 = toString(arr4);
        System.out.println(result3);
        System.out.println("Sorted array with INSERTION SORT:");
        Sorting.insertionSort(arr4, comp);
        String resultInsertion = toString(arr4);
        System.out.println(resultInsertion);

        Integer[] arr5 = {4,69,8,11,9,1,7,9,6,11,1};
        System.out.println("Unsorted array:");
        String result4 = toString(arr5);
        System.out.println(result4);
        System.out.println("Sorted array with COCKTAIL SHAKER SORT:");
        Sorting.cocktailSort(arr5, comp);
        String resultCocktail = toString(arr5);
        System.out.println(resultCocktail);

        Integer[] arr6 = {3,10,7,9,12,2,6,9,1,6,7,4};
        System.out.println("Unsorted array");
        String result6 = toString(arr6);
        System.out.println(result6);
        System.out.println("Sorted array with MERGE SORT:");
        Sorting.mergeSort(arr6, (a, b) -> a - b);
        String resultMerge = toString(arr6);
        System.out.println(resultMerge);

        Integer[] arr7 = {371,49,361,497,288,388,72,183,5,6,76,304,352};
        System.out.println("Unsorted array");
        String result7 = toString(arr7);
        System.out.println(result7);
        System.out.println("Sorted array with LSD RADIX SORT:");
        Sorting.lsdRadixSort(arr7);
        String resultLSDradix = toString(arr7);
        System.out.println(resultLSDradix);
    }

    // Method to print results
    public static <T> String toString(T[] arr){
        String result = "";
        for (int i =0; i < arr.length; i++){
            result = result + arr[i] + ", ";
        }
        result = "[" + result.replaceAll(", $", "") + "]";
        return result;
    }


}

