package benchmark;

import benchmark.data.ArrayFactory;
import benchmark.data.DataType;
import benchmark.sort.*;
import benchmark.util.SortChecker;

public class Main {

    public static void main(String[] args) {

        int size = 100000;

        Sorter[] sorters = {
                new BubbleSort(),
                new QuickSort(),
                new RadixSort()
        };

        for (DataType type : DataType.values()) {
            int[] original = ArrayFactory.makeArray(type, size);

            for (Sorter sorter : sorters) {
                int[] copy = original.clone();

                sorter.sort(copy);
                SortChecker.check(original, copy);

                System.out.println(sorter.getName() + " OK for " + type);
            }
        }

        System.out.println("^_^ Every test has passed");
    }
}