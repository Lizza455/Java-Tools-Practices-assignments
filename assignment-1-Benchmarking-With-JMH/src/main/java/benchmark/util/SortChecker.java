package benchmark.util;

import java.util.Arrays;

public class SortChecker {

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void check(int[] original, int[] actual) {
        int[] expected = Arrays.copyOf(original, original.length);
        Arrays.sort(expected);

        if (!isSorted(actual)) {
            throw new AssertionError("Not sorted -_-");
        }

        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError("Different result from the  Arrays.sort() -_-");
        }
    }
}