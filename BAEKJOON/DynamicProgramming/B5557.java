package BAEKJOON.DynamicProgramming;

import java.util.Scanner;

public class B5557 {

    public static void main(String[] args) throws Exception {

        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N+1]; // 연산할 수의 배열
        for (int i = 1; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int total = sc.nextInt(); // 만들어야 하는 숫자

        long count = 0;
        long[][] dp =  new long[N+1][21]; // 0~20 사이 값을 유지하면서 total이 되기 위한 연산 횟수 배열
        dp[1][numbers[1]] = 1; // 첫번째 연산으로는 +연산만 가능


        for (int i = 1; i <= N - 1; i++) {
            // 0~20까지 0이 아닌 연산 가능한 값 찾기
            for (int j = 0; j <= 20; j++) {
                // 연산을 할 수 있을 때
                if(dp[i][j] != 0) {
                    // 현재 단계에서 다음 수를 더하거나 뺐을 때
                    int plus = j + numbers[i+1];
                    int minus = j - numbers[i+1];
                    if(plus >=0 && plus<=20) { // 다음 수를 더하는 경우
                        dp[i + 1][plus] += dp[i][j]; //현재 수 까지의 경우의 수를 더해줌
                    }
                    if(minus >=0 && minus<=20) {
                        dp[i + 1][minus] += dp[i][j];
                    }

                }
            }
        }

        count = dp[N-1][total]; // 마지막 숫자는 되어야 하는 숫자이므로 N-1번째 연산의 total번째 값을 출력

        System.out.println(count);


    }
}
