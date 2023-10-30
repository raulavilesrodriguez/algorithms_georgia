import java.util.Arrays; // Import the Arrays class

public class Main {
    
    public static void main(String[] args){

        String kmpPattern = "ababa";
        String kmpText = "ababaaababa";
        String kmpNoMatch = "ababbaba";

        String sellPattern = "sell";
        String sellText = "She sells seashells by the seashore.";
        String sellNoMatch = "sea lions trains cardinal boardwalk";

        String multiplePattern = "ab";
        String multipleText = "abab";

        //_________BOYER MOORE algorithm_______________

        /*
            pattern: sell
            text: She sells seashells by the seashore.
            indices: 4
            expected total comparisons: 20
         */

        CharacterComparator comparator1 = new CharacterComparator();

        System.out.println("BOYER MOORE: " + PatternMatching.boyerMoore(sellPattern, sellText, comparator1));
        System.out.println("Compararison count was: " + comparator1.getComparisonCount());

        /*
            pattern: sell
            text: sea lions trains cardinal boardwalk
            indices: -
            expected total comparisons: 9
         */

        CharacterComparator comparator2 = new CharacterComparator();

        System.out.println("BOYER MOORE: " + PatternMatching.boyerMoore(sellPattern, sellNoMatch, comparator2));
        System.out.println("Compararison count was: " + comparator2.getComparisonCount());

        /*
            pattern: ab
            text: abab
            indices: 0, 2
            expected total comparisons: 5
         */

        CharacterComparator comparator3 = new CharacterComparator();

        System.out.println("BOYER MOORE: " + PatternMatching.boyerMoore(multiplePattern, multipleText, comparator3));
        System.out.println("Compararison count was: " + comparator3.getComparisonCount());

        /*
            pattern: sea lions trains cardinal boardwalk
            text: sell
            indices: -
            expected total comparisons: 0
         */
        CharacterComparator comparator4 = new CharacterComparator();

        System.out.println("BOYER MOORE: " + PatternMatching.boyerMoore(sellNoMatch, sellPattern, comparator4));
        System.out.println("Compararison count was: " + comparator4.getComparisonCount());
        
        // _____________KPM algorithm__________
        /*
            pattern: ababa
            failure table: [0, 0, 1, 2, 3]
            comparisons: 4
         */

        CharacterComparator comparator5 = new CharacterComparator();
        int[] failureTable = PatternMatching.buildFailureTable(kmpPattern, comparator5);
        System.out.println("failure Table: " + Arrays.toString(failureTable));
        System.out.println("Compararison count was: " + comparator5.getComparisonCount());

        /*
            pattern: ababa
            text: ababaaababa
            indices: 0, 6
            expected total comparison: 18
         */
        /*
            failure table: [0, 0, 1, 2, 3]
            comparisons: 4
         */
        /*
        a | b | a | b | a | a | a | b | a | b | a
        --+---+---+---+---+---+---+---+---+---+---
        a | b | a | b | a |   |   |   |   |   |
        - | - | - | - | - |   |   |   |   |   |         comparisons: 5
          |   | a | b | a | b | a |   |   |   |
          |   |   |   |   | - |   |   |   |   |         comparisons: 1
          |   |   |   | a | b | a | b | a |   |
          |   |   |   |   | - |   |   |   |   |         comparisons: 1
          |   |   |   |   | a | b | a | b | a |
          |   |   |   |   | - | - |   |   |   |         comparisons: 2
          |   |   |   |   |   | a | b | a | b | a
          |   |   |   |   |   | - | - | - | - | -       comparisons: 5

        comparisons: 14
         */

        CharacterComparator comparator6 = new CharacterComparator();
        System.out.println("KMP: " + PatternMatching.kmp(kmpPattern, kmpText, comparator6));
        System.out.println("Compararison count was: " + comparator6.getComparisonCount());
        
        /*
            pattern: ababa
            text: ababbaba
            indices: -
            expected total comparison: 10
         */
        /*
            failure table: [0, 0, 1, 2, 3]
            comparisons: 4
         */
        /*
        a | b | a | b | b | a | b | a
        --+---+---+---+---+---+---+---
        a | b | a | b | a |   |   |
        - | - | - | - | - |   |   |            comparisons: 5
          |   | a | b | a | b | a |
          |   |   |   | - |   |   |            comparisons: 1

        comparisons: 6
         */
        CharacterComparator comparator7 = new CharacterComparator();
        System.out.println("KMP: " + PatternMatching.kmp(kmpPattern, kmpNoMatch, comparator7));
        System.out.println("Compararison count was: " + comparator7.getComparisonCount());

        /*
            pattern: ababbaba
            text: ababa
            indices: -
            expected total comparison: 0
         */
        CharacterComparator comparator8 = new CharacterComparator();
        System.out.println("KMP: " + PatternMatching.kmp(kmpNoMatch, kmpPattern, comparator8));
        System.out.println("Compararison count was: " + comparator8.getComparisonCount());




    }
}
