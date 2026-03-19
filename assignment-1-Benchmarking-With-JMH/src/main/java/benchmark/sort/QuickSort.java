package benchmark.sort;

public class QuickSort implements Sorter {

    @Override
    public String getName() {
        return "Quick Sort";
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;

        int pivot = arr[left + (right - left) / 2];

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }
}