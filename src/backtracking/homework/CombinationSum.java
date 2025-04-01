package backtracking.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, ans, curr, 0);
        return ans;
    }

    public static void combinationSum(int[] arr, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int index) {
        if (sum < 0) return;
        if (sum == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            curr.add(arr[i]);
            combinationSum(arr, sum - arr[i], ans, curr, i + 1);
            curr.removeLast(); // backtracking
        }
    }

    public static void main(String[] args) {
        int[] candidate = {8, 1, 3, 7, 2, 1, 5};

        ArrayList<ArrayList<Integer>> ans = combinationSum(candidate, 12);

        System.out.println(ans);
    }
}
