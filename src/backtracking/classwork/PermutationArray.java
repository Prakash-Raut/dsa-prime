package backtracking.classwork;

import java.util.Arrays;

public class PermutationArray {

    public static void permute(int[] arr, int l, int r) {
        if (l == r) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(arr, i, l);
            permute(arr, l + 1, r);
            swap(arr, i, l); // Backtracking
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr, 0, arr.length - 1);
    }
}
