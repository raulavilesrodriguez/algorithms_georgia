import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        @SuppressWarnings("unchecked")
        Numeros<Integer>[] arr = new Numeros[10];

        Numeros<Integer> x1 = new Numeros<Integer>(3);
        Numeros<Integer> x2 = new Numeros<Integer>(12);
        Numeros<Integer> x3 = new Numeros<Integer>(5);
        Numeros<Integer> x4 = new Numeros<Integer>(1);
        arr[0] = x1;
        arr[1] = x2;
        arr[2] = x3;
        arr[3] = x4;

        ArrayList<MyObject> list = new ArrayList<MyObject>();
        list.add(new MyObject(3));
        list.add(new MyObject(12));
        list.add(new MyObject(5));
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

