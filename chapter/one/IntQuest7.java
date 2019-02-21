/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
 * Hints: #51, #100
 * - Try thinking about it layer by layer. Can you rotate a specific layer?
 * - Rotating a specific layer would just mean swapping the values in four arrays. Ifyou were
 * asked to swap the values in two arrays, could you do this? Can you then extend it to four
 * arrays?
 */
package chapter.one;


import java.util.Random;
import java.util.Scanner;

public class IntQuest7 {
    private static int[][] rotated;
    private static int xDim = 0;
    private static int yDim = 0;


    /**
     * This function rotates the matrix left by 90 degrees.
     * It does so, by reading the matrix from the last to the first column, row by row.
     * e.g.
     * for each column from the end:
     *  for each row from the beginning:
     * The result is a rotated matrix and is stored at the static variable 'rotated'.
     * @param matrix = the matrix to be rotated
     */
    private static void rotate(int[][] matrix) {
        getRotatedRam(matrix.length);
        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                addElement(matrix[j][i]);
            }
        }
    }


    /**
     * This function adds elements to the rotated array.
     * It populates element by element, row by row.
     * It increments the indexes accordingly.
     * @param element = element to add each time.
     */
    private static void addElement(int element){
        rotated[xDim][yDim] = element;
        if (++yDim == rotated.length){
            yDim = 0;
            if (++xDim == rotated.length){
                xDim = 0;
            }
        }
    }


    /**
     * This function is initializing the rotated matrix.
     * @param size = the size to initialize the matrix.
     */
    private static void getRotatedRam(int size){
        rotated = new int[size][size];
    }



    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size:");
        int matrixSize = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = rand.nextInt(256);
            }
        }
        rotate(matrix); //  Here the rotation takes place.

        /* Printing of the original matrix */
        System.out.println("Original Matrix");
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        /* Printing of the rotated matrix */
        System.out.println("\nRotated Matrix");
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(rotated[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
