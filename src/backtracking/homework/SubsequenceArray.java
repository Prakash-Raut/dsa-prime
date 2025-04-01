package backtracking.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsequenceArray {

    public static ArrayList<ArrayList<Integer>> subsequences(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(arr);
        subsequences(arr, ans, curr, 0);
        return ans;
    }

    public static void subsequences(int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int index) {
        ans.add(new ArrayList<>(curr));

        for (int i = index; i < arr.length; i++) {
            curr.add(arr[i]);
            subsequences(arr, ans, curr, i + 1);
            curr.removeLast(); // backtracking
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 7};

        ArrayList<ArrayList<Integer>> ans = subsequences(arr);

        System.out.println(ans);

    }
}
