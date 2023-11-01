package BAEKJOON.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class TEfficientCoin {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] d = new int[M+1];
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.fill(d, 10001);
        d[0] = 0;

        for(int i=0; i<N; i++) {
            for(int j=coins[i]; j<M+1; j++) { // 화폐단위로 (+화폐크기)를 계산하여 반복. 2의 경우 2,4,6,8...번째의 화폐개수를 계산
                if(d[j - coins[i]] != 10001) { // 화폐단위가 겹치는 경우, 즉 화폐단위가 2,3 이 있을때 6은 두 계산과정에 모두 해당됨
                    d[j] = Math.min(d[j], d[j - coins[i]] + 1); // 앞서 계산한 화폐개수와 이번에 계산한 화폐개수 중 작은 것을 선택
                }
            }
        }
        if(d[M] == 10001)
            System.out.println(-1);
        else
            System.out.println(d[M]);
    }
}
