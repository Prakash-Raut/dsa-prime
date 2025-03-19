package backtracking.classwork;

public class RatMaze {

    private static boolean isValid(int row, int col, int [][] maze, boolean[][] vis, int n, int m) {
        return (row < n && row >=0 && col < m && col >=0 && maze[row][col] == 1 && !vis[row][col]);
    }

    public static void ratInAMaze(int[][] maze, boolean[][] vis, int row, int col, String path, int n, int m) {
        if (row == n-1 && col == m-1) {
            System.out.println(path);
            return;
        }
        // Direction: Down Left Right Up
        if (isValid(row + 1, col, maze, vis, n, m)) {
            vis[row + 1][col] = true;
            ratInAMaze(maze, vis, row + 1, col, path + 'D', n, m);
            vis[row + 1][col] = false;
        }

        if (isValid(row, col - 1, maze, vis, n, m)) {
            vis[row][col - 1] = true;
            ratInAMaze(maze, vis, row, col - 1, path + 'L', n, m);
            vis[row][col - 1] = false;
        }

        if (isValid(row, col + 1, maze, vis, n, m)) {
            vis[row][col + 1] = true;
            ratInAMaze(maze, vis, row, col + 1, path + 'R', n, m);
            vis[row][col + 1] = false;
        }

        if (isValid(row - 1, col, maze, vis, n, m)) {
            vis[row - 1][col] = true;
            ratInAMaze(maze, vis, row - 1, col, path + 'U', n, m);
            vis[row - 1][col] = false;
        }
    }

    public static void main(String[] args) {
        int [][] maze = {
                {1,1,1,0},
                {1,1,0,1},
                {1,1,0,0},
                {1,1,1,1}
        };

        int n = maze.length;
        int m = maze[0].length;

        boolean[][] vis = new boolean[n][m];

        vis[0][0] = true;

        ratInAMaze(maze, vis, 0, 0, "", n, m);

    }
}
