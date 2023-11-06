package BAEKJOON.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class B1149 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] cost = new int[1000][3];
        int[][] dp = new int[1000][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] += cost[i][j] + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
            }
        }

        Arrays.sort(dp[N-1]);
        int min = dp[N-1][0];
        System.out.println(min);

    }
}
