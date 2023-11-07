package D3;

import java.util.Scanner;


public class S5215_DP {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int N, L; // N:재료수, L:제한 칼로리
        int[] taste; // 맛점수 모음
        int[] cal; // 칼로리 모음
        int[][] dp; // dp 테이블

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            L = sc.nextInt();
            taste = new int[N+1];
            cal = new int[N+1];
            dp = new int[21][10001]; // N번 까지의 물건 중 L+1보다 작은 최대값을 저장하는 함수

            for (int i = 1; i <= N; i++) { // 입력받기
                taste[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= L; j++) {
                    if(cal[i] > j) { // i번째를 포함하지 않은 경우. i번째가 제한값 보다 큰 경우
                        dp[i][j] = dp[i-1][j];
                    } else { // i번째를 포함시켰을 경우와 i번째를 포함하지 않은 경우 중 큰 것을 고름
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cal[i]] + taste[i]);
                    }
                }
            }

            System.out.println("#" + test_case + " " + dp[N][L]);
        }

    }

}
