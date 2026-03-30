public class BacktrackingAssignment {

    public static boolean isSafe(int maze[][], int row, int col, int sol[][]) {
        int n = maze.length;
        return (row >= 0 && row < n &&
                col >= 0 && col < n &&
                maze[row][col] == 1 &&
                sol[row][col] == 0);
    }

    public static boolean solveMazeLogic(int maze[][], int row, int col, int sollution[][]) {
        int n = maze.length;
        // base case
        if (row == n - 1 && col == n - 1 && maze[row][col] == 1) {
            sollution[row][col] = 1;
            return true;
        }

        // recursion
        if (isSafe(maze, row, col, sollution)) {
            sollution[row][col] = 1;

            // right
            if (solveMazeLogic(maze, row, col + 1, sollution)) {
                return true;
            }

            // left
            if (solveMazeLogic(maze, row, col - 1, sollution)) {
                return true;
            }

            // down
            if (solveMazeLogic(maze, row + 1, col, sollution)) {
                return true;
            }

            // up
            if (solveMazeLogic(maze, row - 1, col, sollution)) {
                return true;
            }
            sollution[row][col] = 0;
            return false;
        }
        return false;
    }

    public static void solveMaze(int maze[][]) {
        int n = maze.length;
        int sollution[][] = new int[n][n];

        if (!solveMazeLogic(maze, 0, 0, sollution)) {
            System.out.println("Sollution does not exist!");
            return;
        }
        printMaze(sollution);
    }

    public static void printMaze(int maze[][]) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        int n = maze.length;

        solveMaze(maze);
    }
}
