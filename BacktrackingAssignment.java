public class BacktrackingAssignment {

    public static int ratWays(int maze[][], int i, int j, int n, int m) {
        // base case
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        // recursion
        int w1 = ratWays(maze, i + 1, j, n, m);
        int w2 = ratWays(maze, i - 1, j, n, m);
        int w3 = ratWays(maze, i, j + 1, n, m);
        int w4 = ratWays(maze, i, j - 1, n, m);

        return w1 + w2 + w3 + w4;
    }

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        int n = maze.length;

        System.out.println(ratWays(maze, 0, 0, n, n));
    }
}
