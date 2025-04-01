package backtracking.classwork;

import java.util.ArrayList;

public class SmartKeypad {

    public static ArrayList<String> smartKeypad(String input) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> ans = new ArrayList<>();

        smartKeypad(input, map, 0, ans, "");

        return ans;
    }

    public static void smartKeypad(String input, String[] map, int index, ArrayList<String> ans, String curr) {
        if (index == input.length()) {
            ans.add(curr);
            return;
        }

        int keypadNumber = input.charAt(index) - '0';

        String keypadString = map[keypadNumber];

        for (int i = 0; i < keypadString.length(); i++) {
            curr = curr + keypadString.charAt(i);
            smartKeypad(input, map, index + 1, ans, curr);
            curr = curr.substring(0, curr.length() - 1); // backtracking
        }
    }

    public static void main(String[] args) {
        System.out.println(smartKeypad("23"));
    }
}
