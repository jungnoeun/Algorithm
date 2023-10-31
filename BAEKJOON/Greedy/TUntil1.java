package BAEKJOON.Greedy;

import java.util.Scanner;

public class TUntil1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;

        while(N != 1) {
            // N이 K로 나누어 떨어지는 경우
            if(N%K == 0) {
               N = N/K;
            } else {
                N = N-1;
            }
            count++;
        }
        System.out.println(count);

    }
}
