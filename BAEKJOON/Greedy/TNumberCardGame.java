package BAEKJOON.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class TNumberCardGame {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] cards = new int[N][M];
        int[] best = new int[N];

        // card 값 입력받기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                cards[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N; i++) {
            Arrays.sort(cards[i]);
            best[i] = cards[i][0];
        }

        Arrays.sort(best);
        System.out.println(best[N-1]);

    }
}
