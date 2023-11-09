package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlippedMatrix {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(List.of(
                1, 2, 3, 4,
                4, 5, 6, 3,
                7, 8, 9, 5
        ));

        int[][] flippedMatrix = verticalFlip(matrix);
//         Print the flipped matrix
        for (int[] row : flippedMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] verticalFlip(List<List<Integer>> matrix) {
        int numRows = matrix.size();
        int numCols = matrix.get(0).size();
        int[][] flippedMatrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                flippedMatrix[i][j] = matrix.get(numRows - 1 - i).get(j);
            }
        }

        return flippedMatrix;
    }

    public static class MatrixFlip {
        public static void main(String[] args) {
//            Math.max(
//                    matrix.get(i).get(j),
//                    Math.max(
//                            matrix.get(i).get(n - 1 - j),
//                            Math.max(
//                                    matrix.get(n - 1 - i).get(j),
//                                    matrix.get(n - 1 - i).get(n - 1 - j)
//                            )));
            List<List<Integer>> matrix = new ArrayList<>(Arrays.asList(
                    Arrays.asList(112, 42, 83, 119),
                    Arrays.asList(56, 125, 56, 49),
                    Arrays.asList(15, 78, 101, 43),
                    Arrays.asList(62, 98, 114, 108)));


            //119 83 42 112
            //49  56 125 56
            //43  101 78 15
            //108 114 98 62

            int sum = flippingMatrix(matrix);
            System.out.println(sum);
        }

        public static int flippingMatrix(List<List<Integer>> matrix) {
            // Write your code here
            int sum = 0;
            int n = matrix.size();
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                   sum += Math.max(matrix.get(i).get(j), Math.max(matrix.get(i).get(n-1-j),
                           Math.max(matrix.get(n-1-i).get(j),
                           matrix.get(n-1-i).get(n-1-j))));
                }
            }
            return sum;

        }

    }
}
