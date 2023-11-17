package BAEKJOON.BFS;

import java.util.Scanner;

public class B1697 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[K+1];
        int min = 0;

        if(N >= K) {
            System.out.println(N - K);
            return;
        }

        for(int i=0; i<N; i++) {
            arr[i] = N-i;
        }

        for (int i = N+1; i <= K; i++) {
            if(i%2 == 0) {
                min = arr[i/2] + 1;
            } else {
                min = Math.min(arr[(i+1)/2] , arr[(i-1)/2]) + 2;
            }
            arr[i] = Math.min(min, arr[i-1]+1);

        }

        System.out.println(arr[K]);

    }
}
