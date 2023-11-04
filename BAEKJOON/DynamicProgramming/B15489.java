package BAEKJOON.DynamicProgramming;

import java.util.Scanner;

public class B15489 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(); //  y
        int C = sc.nextInt(); //  x
        int W = sc.nextInt(); // 한변 길이

        int len = R+W; // 구해야 하는 총 행의 길이
        int[][] t = new int[len][len];

        t[0][0] = 1; // 꼭대기
        int end = 1;
        for(int i=1; i<len; i++) { // len-1번째 줄까지의 파스칼 삼각형을 구함
            for(int j=0; j<len; j++) {
                if(j==0) { // 왼쪽 끝인 경우
                    t[i][j] = 1;
                } else if(j == end) { // 오른쪽 끝인 경우
                    end++;
                    t[i][j] = 1;
                    break;
                } else { // 양끝이 아닌 경우
                    t[i][j] = t[i - 1][j - 1] + t[i - 1][j];
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                sum += t[R - 1 + i][C - 1 + j];
            }
        }

        System.out.println(sum);


        sc.close();

    }
}
