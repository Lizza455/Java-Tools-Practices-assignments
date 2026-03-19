package benchmark.sort;

public class RadixSort implements Sorter {

    @Override
    public String getName() {
        return "Radix Sort";
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int n = arr.length;
        int[] temp = new int[n];

        int RADIX = 256;
        int MASK = 0xFF;

        for (int shift = 0; shift < 32; shift += 8) {
            int[] count = new int[RADIX];

            // count digits
            for (int value : arr) {
                int digit = (value >>> shift) & MASK;
                count[digit]++;
            }

            // prefix sum
            if (shift != 24) {
                for (int i = 1; i < RADIX; i++) {
                    count[i] += count[i - 1];
                }
            } else {
                // hadling negatuves
                int sum = 0;
                int[] newCount = new int[RADIX];

                for (int i = 128; i < RADIX; i++) {
                    sum += count[i];
                    newCount[i] = sum;
                }
                for (int i = 0; i < 128; i++) {
                    sum += count[i];
                    newCount[i] = sum;
                }

                count = newCount;
            }


            for (int i = n - 1; i >= 0; i--) {
                int value = arr[i];
                int digit = (value >>> shift) & MASK;
                temp[--count[digit]] = value;
            }


            System.arraycopy(temp, 0, arr, 0, n);
        }
    }
}