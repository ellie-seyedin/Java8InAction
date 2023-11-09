package hackerRank;

import java.util.Arrays;

public class FindZigZag {
    public static void main(String[] args) {
        int[] a = {1,6,5,3,7,2,4};
        findZigZagSequence(a, 7);
    }

    public static void findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);
        int middle = (n - 1) / 2;
        int temp = a[middle];
        a[middle] = a[n - 1];
        a[n - 1] = temp;

        int start = a[middle + 1];
        int end = a[n - 2];
        while (start <= end) {
            int tmp = start;
            start = end;
            end = tmp;
            start ++;
            end--;
        }

        for (int i = 0; i <n ; i++) {
            System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
