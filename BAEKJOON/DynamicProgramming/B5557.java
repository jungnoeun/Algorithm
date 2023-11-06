package BAEKJOON.DynamicProgramming;

import java.util.Scanner;

public class B5557 {
    static int[] numbers;
    static int N;
    static long count = 0;
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];;
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        dfs(0,0);
        System.out.println(count);

    }


    static void dfs(int n, int sum) {
        if(n == N) {
            count++;
            return;
        }
        if((sum + numbers[n]) >= 0 && (sum + numbers[n]) <= 20) {
            sum += numbers[n];
            dfs(n+1, sum);
        } else {
            return;
        }
        if((sum - numbers[n]) >= 0 && (sum - numbers[n]) <= 20) {
            sum -= numbers[n];
            dfs(n+1, sum);
        } else {
            return;
        }

    }

}
