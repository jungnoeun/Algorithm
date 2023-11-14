package D3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S1859 {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] arr;
        int max;
        int N;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            max = Integer.MIN_VALUE;
            long result = 0;

            for (int i = arr.length-1; i >= 0; i--) {
                if(arr[i]>max) { // 뒤에서부터 큰값 - 작은 값 하면 조건을 성립
                    max = arr[i];
                }
                result += max - arr[i];
            }
            System.out.println("#" + test_case + " " + result);

        }
        sc.close();
    }
}
