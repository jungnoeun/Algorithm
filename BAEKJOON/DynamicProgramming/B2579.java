package BAEKJOON.DynamicProgramming;

import java.util.Scanner;

public class B2579 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] stair = new int[301]; // 계단
        int[] dp = new int[301]; // dp 테이블

        for (int i = 1; i <= T; i++) {
            stair[i] = sc.nextInt();
        }
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int n = 4; n <= T; n++) {
            dp[n] = Math.max(dp[n-3] + stair[n-1], dp[n-2]) + stair[n];
        }

        System.out.println(dp[T]);

    }
}
