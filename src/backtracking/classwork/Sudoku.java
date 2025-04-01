package backtracking.classwork;

public class Sudoku {

    public static boolean sudokuSolver(int[][] board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return sudokuSolver(board, row + 1, 0);
        if (board[row][col] != 0) return sudokuSolver(board, row, col + 1);

        for (int i = 1; i <= 9; i++) {
            if (isSafeSudoku(board, row, col, i)) {
                board[row][col] = i;
                if (sudokuSolver(board, row, col + 1)) return true;
                board[row][col] = 0; // backtracking
            }
        }

        return false;
    }

    private static boolean isSafeSudoku(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }

        int gridRow = row / 3;
        int gridCol = col / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cellRow = 3 * gridRow + i;
                int cellCol = 3 * gridCol + j;
                if (board[cellRow][cellCol] == num) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudokuSolver(board, 0, 0);

        for (int[] a : board) {
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
