package benchmark;

import benchmark.data.ArrayFactory;
import benchmark.data.DataType;
import benchmark.sort.*;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@State(Scope.Thread)
@Fork(1)
public class SortBenchmarks {

    @Param({"1000000"})
    private int size;

    @Param({"RANDOM", "SORTED", "REVERSED", "ALMOST_SORTED"})
    private String typeName;

    private int[] base;

    @Setup
    public void setup() {
        DataType type = DataType.valueOf(typeName);
        base = ArrayFactory.makeArray(type, size);
    }



    @Benchmark
    public int[] quick() {
        int[] arr = Arrays.copyOf(base, base.length);
        new QuickSort().sort(arr);
        return arr;
    }

    @Benchmark
    public int[] radix() {
        int[] arr = Arrays.copyOf(base, base.length);
        new RadixSort().sort(arr);
        return arr;
    }

    @Benchmark
    public int[] javaSort() {
        int[] arr = Arrays.copyOf(base, base.length);
        Arrays.sort(arr);
        return arr;
    }
}