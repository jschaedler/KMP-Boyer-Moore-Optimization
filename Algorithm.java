import java.util.*;

public class Algorithm {


    /**
     * A combination of the Boyer-Moore and the KMP pattern matching algorithms that optimizes
     * them to perform more efficiently than either of the algorithms by themselves.
     *
     *
     * @param pattern a string that that will be searched for in the text
     * @param text a string that may or may not have the pattern within it
     * @param comparator a comparison counter to keep track of the comparisons made between the characters
     *                   from the pattern and the text
     * @throws IllegalArgumentException if the pattern, text, or comparator is null
     * @return a LinkedList containing the starting indices marking the spot in the text where the pattern
     *                   was found
     */
    public static List<Integer> KMPBoyerMoore(String pattern, String text, Comparator<Character> comparator) {
        if (pattern == null || text == null || comparator == null) {
            throw new IllegalArgumentException("The parameters must not be null");
        }
        if (pattern.length() > text.length() || pattern.length() == 0 || text.length() == 0) {
            throw new IllegalArgumentException("The pattern and the text must have length greater than 0 and the " +
                    "text's length must be greater than or equal to the pattern's length");
        }

        List<Integer> found = new LinkedList<>();
        int[] failure = new int[pattern.length()];
        Map<Character, Integer> last = new HashMap<>();
        preProcess(pattern, failure, last, comparator);

        int j = 0;
        int k = 0;
        int i = pattern.length() - 1;
        boolean kIncremented = false;
        boolean noShift;

        while (k - j <= text.length() - pattern.length()) {
            noShift = true;

            if (!kIncremented) {
                if (comparator.compare(text.charAt(i + k), pattern.charAt(i)) != 0) {
                    noShift = false;
                    int shift = last.getOrDefault(text.charAt(i + k), -1);
                    k = (k + i - shift);
                }

            }
            kIncremented = false;
            if (noShift) {
                if (comparator.compare(pattern.charAt(j), text.charAt(k)) == 0) {
                    if (j == i - 1) {
                        found.add(k - j);
                        j = failure[i];
                        k += 2;


                    } else {
                        j++;
                        k++;
                        kIncremented = true;
                    }
                } else if (j == 0) {
                    k++;
                } else {
                    j = failure[j - 1];
                    kIncremented = true;

                }
            }
        }

    return found;
    }

    /**
     * Builds failure table and last occurrence table necessary in performing intelligent shifts when comparing
     *                   the pattern to the text.  O(n) time complexity where n is the length of the pattern
     * @param pattern the pattern to pre-process
     * @param failure an array representing the failure table needed for the KMP algorithm
     * @param last a hashmap representing the last occurrence table needed for the Boyer Moore algorithm
     * @param comparator a comparison counter to keep track of the comparisons made between the characters
     *                   from the pattern and the text
     */
    protected static void preProcess(String pattern, int[] failure, Map<Character, Integer> last, Comparator<Character> comparator) {


        failure[0] = 0;
        int i = 0;
        int j = 1;
        last.put(pattern.charAt(0), 0);
        while (j < pattern.length()) {

            if (comparator.compare(pattern.charAt(i), pattern.charAt(j)) == 0) {
                failure[j] = i + 1;
                i++;
                last.put(pattern.charAt(j), j++);

            } else if (i == 0) {
                failure[j] = 0;
                last.put(pattern.charAt(j), j++);

            } else {
                i = failure[i - 1];
            }
        }

    }



}
