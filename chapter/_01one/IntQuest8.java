/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to O.
 * Hints: # 17, #74, #102
 * - If you just cleared the rows and columns as you found Os, you'd likely wind up clearing
 * the whole matrix.Try finding the cells with zeros first before making any changes to the
 * matrix.
 * - Can you use 0 (N) additional space instead of 0 (N 2 )? What information do you really
 * need from the list of cells that are zero?
 * - You probably need some data storage to maintain a list of the rows and columns that
 * need to be zeroed. Can you reduce the additional space usage to a(1) by using the
 * matrix itself for data storage?
 */
package chapter._01one;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class IntQuest8 {


    /**
     * This function, for each zero in the matrix array, zeroes everything at the column and the row that it belongs.
     *
     * @param matrix = the matrix to iterate through.
     * @return = the zeroed matrix.
     */
    public static int[][] zerofy(int[][] matrix) {
        boolean zeroFlag = false;
        Set<Integer> skipX = new HashSet<>();
        Set<Integer> skipΥ = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            if (skipX.contains(i)) continue;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && !skipΥ.contains(j)) {
                    skipX.add(i);
                    skipΥ.add(j);
                    Arrays.fill(matrix[i], 0);
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                    j = matrix[i].length;
                }
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix x dim:");
        int xDim = sc.nextInt();
        System.out.print("Enter matrix y dim:");
        int yDim = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[xDim][yDim];
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                matrix[i][j] = rand.nextInt(30);
            }
        }


        /* Printing of the original matrix */
        System.out.println("Original Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int[][] matrixZeroed = zerofy(matrix);
        /* Printing of the original matrix */
        System.out.println("Original Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        /* Printing of the zeroed matrix */
        System.out.println("\nRotated Matrix");
        for (int i = 0; i < matrixZeroed.length; i++) {
            for (int j = 0; j < matrixZeroed[i].length; j++) {
                System.out.print(matrixZeroed[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
