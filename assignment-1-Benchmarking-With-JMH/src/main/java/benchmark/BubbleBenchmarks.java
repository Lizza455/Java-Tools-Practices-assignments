package benchmark;

import benchmark.data.ArrayFactory;
import benchmark.data.DataType;
import benchmark.sort.BubbleSort;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 2, time = 1)
@Fork(1)
@State(Scope.Thread)
public class BubbleBenchmarks {

    @Param({"100000"})
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
    public int[] bubble() {
        int[] arr = Arrays.copyOf(base, base.length);
        new BubbleSort().sort(arr);
        return arr;
    }
}