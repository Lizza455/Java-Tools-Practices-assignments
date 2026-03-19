package benchmark.data;

import java.util.Random;

public class ArrayFactory {

    private static final long SEED = 42L;

    public static int[] makeArray(DataType type, int size) {
        return makeArray(type, size, SEED);
    }

    public static int[] makeArray(DataType type, int size, long seed) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }

        return switch (type) {
            case RANDOM -> makeRandom(size, seed);
            case SORTED -> makeSorted(size);
            case REVERSED -> makeReversed(size);
            case ALMOST_SORTED -> makeAlmostSorted(size, seed);
        };
    }

    private static int[] makeRandom(int size, long seed) {
        Random rnd = new Random(seed);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt();
        }

        return arr;
    }

    private static int[] makeSorted(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        return arr;
    }

    private static int[] makeReversed(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        return arr;
    }

    private static int[] makeAlmostSorted(int size, long seed) {
        int[] arr = makeSorted(size);
        Random rnd = new Random(seed);

        int swaps = Math.max(1, size / 100);

        for (int i = 0; i < swaps; i++) {
            int a = rnd.nextInt(size);
            int b = rnd.nextInt(size);

            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        return arr;
    }
}