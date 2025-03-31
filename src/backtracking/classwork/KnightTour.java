package backtracking.classwork;

public class KnightTour {

    public static int[][] knightTour(int n) {
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }

        arr[0][0] = 1;

        int[] movesX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] movesY = {1, 2, 2, 1, -1, -2, -2, -1};

        knightTour(n, arr, movesX, movesY, 0, 0, 1);

        return arr;
    }

    private static boolean isValid(int[][] arr, int n, int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < n && arr[x][y] == -1);
    }

    private static boolean knightTour(int n, int[][] arr, int[] movesX, int[] movesY, int currX, int currY, int step) {
        if (step == n * n) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nextX = movesX[i] + currX;
            int nextY = movesY[i] + currY;
            if (isValid(arr, n, nextX, nextY)) {
                arr[nextX][nextY] = step;
                boolean isTourCompletedByGoingThere = knightTour(n, arr, movesX, movesY, nextX, nextY, step + 1);
                if (isTourCompletedByGoingThere) {
                    return true;
                }
                arr[nextX][nextY] = -1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] arr = knightTour(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
