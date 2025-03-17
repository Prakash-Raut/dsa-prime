package recursion.homework;

public class MatrixPath {

    public static int totalWays(int m, int n) {
        // Base case: If we reach the last row/column, only one way remains
        if (m == 1 || n == 1) return 1;
        // Sum of paths from above and left
        return totalWays(m - 1, n) + totalWays(m, n - 1);
    }

    public static int totalWaysCombination(int m, int n) {
        int N = m + n - 2; // Total moves
        int R = Math.min(m - 1, n - 1); // Choose the smaller R to optimize
        double result = 1; // Store result in double to prevent integer overflow

        // Compute C(N, R) using iterative multiplication and division
        for (int i = 1; i <= R; i++) {
            result = result * (N - R + i) / i;
        }

        return (int) result; // Convert final answer to integer
    }

    public static void main(String[] args) {
        System.out.println("totalWays(3,3) = " + totalWays(3, 3));
        System.out.println("totalWaysCombination(3,3) = " + totalWaysCombination(3, 3));
    }
}
