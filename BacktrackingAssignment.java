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

    public static void findCombinations(String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println("");
            return;
        }
        keypadFind(0, n, new StringBuilder(), str);
    }

    public static void keypadFind(int pos, int length, StringBuilder ans, String str) {
        // base case
        if (pos == length) {
            System.out.println(ans);
        } else {
            char letters[] = keypad[Character.getNumericValue(str.charAt(pos))];
            for (int i = 0; i < letters.length; i++) {
                keypadFind(pos + 1, length, new StringBuilder(ans).append(letters[i]), str);
            }
        }
    }

    public static char keypad[][] = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
            { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public static boolean isSafeKnight(int board[][], int row, int col) {
        return row >= 0 && row < board.length &&
                col >= 0 && col < board.length &&
                board[row][col] == -1;
    }

    public static boolean knightTour(int board[][], int row, int col, int moveNo) {
        int n = board.length;
        // base case
        if (moveNo == n * n - 1) {
            System.out.println("Sollution exists");
            return true;
        }

        // recursion
        // 8 choices
        int rowMoves[] = { -2, -2, -1, 1, 2, 2, 1, -1 };
        int colMoves[] = { -1, 1, 2, 2, 1, -1, -2, -2 };
        for (int i = 0; i < rowMoves.length; i++) {
            int nextRow = row + rowMoves[i];
            int nextCol = col + colMoves[i];

            if (isSafeKnight(board, nextRow, nextCol)) {
                board[nextRow][nextCol] = moveNo + 1;
                if (knightTour(board, nextRow, nextCol, moveNo + 1)) {
                    return true;
                }
                board[nextRow][nextCol] = -1;
            }
        }
        return false;
    }

    public static void printBoard(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Q1: Rat in a Maze
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };

        solveMaze(maze);

        // Q2: Keypad Combinations
        findCombinations("23");

        // Q3: Knight's Tour
        int len = 6;
        int board[][] = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                board[i][j] = -1;
            }
        }

        board[0][0] = 0;

        if (knightTour(board, 0, 0, 0)) {
            printBoard(board);
        } else {
            System.out.println("Sollution not found!");
        }
    }
}
