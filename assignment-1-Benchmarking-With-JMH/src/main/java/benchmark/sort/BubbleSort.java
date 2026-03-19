package benchmark.sort;

public class BubbleSort implements Sorter {

    @Override
    public String getName() {
        return "Bubble Sort";
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = arr.length - 1; end > 0; end--) {
            boolean swapped = false;

            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}