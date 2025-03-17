package recursion.classwork;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static List<String> findSubsets(String s) {
        List<String> res = new ArrayList<>();
        findSubsetsHelper(s, 0, "", res);
        return res;
    }

    private static void findSubsetsHelper(String s, int i, String curr, List<String> res) {
        if (i == s.length()) {
            res.add(curr);
            return;
        }
        // Include the current character
        findSubsetsHelper(s, i + 1, curr + s.charAt(i), res);

        // Exclude the current character
        findSubsetsHelper(s, i + 1, curr, res);
    }

    public static void main(String[] args) {
        System.out.println("findSubsets(\"abc\") = " + findSubsets("abc"));
    }
}
