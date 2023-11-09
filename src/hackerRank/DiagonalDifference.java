package hackerRank;

import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> arr = List.of(
                List.of(1,2,3),
                List.of(2,3,5),
                List.of(1,4,5)
        );
        int i = diagonalDifference(arr);
        System.out.println(i);
    }
    public static int diagonalDifference(List<List<Integer>> arr){
        int primarySumDiagonal = 0;
        int secondarySumDiagonal = 0;

        int size = arr.size();
        for (int i = 0; i <size ; i++) {
            primarySumDiagonal += arr.get(i).get(i);
            secondarySumDiagonal += arr.get(i).get(size-1-i);

        }
        return Math.abs(primarySumDiagonal - secondarySumDiagonal);
    }


}
