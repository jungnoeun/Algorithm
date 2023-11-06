package BAEKJOON.DynamicProgramming;

import java.util.Scanner;

public class B9095 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int N = sc.nextInt();
            int[] d = new int[N+4]; // 1~N까지 사용, 연산의 횟수를 저장 N<3일 경우를 대비해 +4해줌

            d[1] = 1; // 처음 1이 되는 연산의 경우는 1가지 (+1)
            d[2] = 2;
            d[3] = 4;


            for (int j = 4; j <= N; j++) {
                d[j] = d[j - 1] + d[j - 2] + d[j - 3];
            }

            System.out.println(d[N]);
        }
    }
}
