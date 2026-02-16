import java.util.*;

public class arrays2d {

    public static void searchMatrix(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Key found at: " + i + ", " + j);
                }
            }
        }
    }

    public static void matrixRange(int matrix[][]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > largest) {
                    largest = matrix[i][j];
                }
                if (matrix[i][j] < smallest) {
                    smallest = matrix[i][j];
                }
            }
        }

        System.out.println("Matrix range starts from " + smallest + " to " + largest);
    }

    public static void spiralMatrix(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endCol && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // left
            for (int i = endRow - 1; i >= startCol + 1; i--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            // variable updates
            startRow++;
            startCol++;
            endCol--;
            endRow--;

            System.out.println();
        }
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        // Brute Force Approach

        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[i].length; j++) {
        // if (i == j) {
        // sum += matrix[i][j];
        // } else if ((i + j) == matrix.length - 1) {
        // sum += matrix[i][j];
        // }
        // }
        // }

        // Optimized Approach
        for (int i = 0; i < matrix.length; i++) {
            // pd
            sum += matrix[i][i];

            // sd and covering the edge case:
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }

        return sum;
    }

    public static boolean searchSortedMatrix(int matrix[][], int key) {
        // We start from matrix's most upper right corner element

        // int row = 0, col = matrix[0].length - 1;
        // while (row < matrix.length && col >= 0) {
        // if (matrix[row][col] == key) {
        // System.out.println("Key found at: (" + row + ", " + col + ")");
        // return true;
        // } else if (key < matrix[row][col]) {
        // col--;
        // } else {
        // row++;
        // }
        // }
        // System.out.println("Key not found");
        // return false;

        // We start from element opp to it in position.
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == key) {
                System.out.println("Key found at: (" + row + ", " + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        System.out.println("Key not found!");
        return false;

    }

    public static boolean searchSortedByRowMatrix(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[0].length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] == key) {
                    return true;
                } else if (matrix[i][mid] < key) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int matrix[][] = new int[4][4];

        // // input matrix elements
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // matrix[i][j] = sc.nextInt();
        // }
        // }

        // // print matrix elements
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // System.out.print(matrix[i][j] + " ");
        // }
        // System.out.println();
        // }

        // searchMatrix(matrix, 4);
        // matrixRange(matrix);
        // spiralMatrix(matrix);

        int matrix[][] = { { 1, 3, 9 },
                { 5, 7, 13 },
                { 6, 8, 12 }
        };

        // System.out.println(diagonalSum(matrix));

        // searchSortedMatrix(matrix, 5);
        System.out.println(searchSortedByRowMatrix(matrix, 20));
    }
}
