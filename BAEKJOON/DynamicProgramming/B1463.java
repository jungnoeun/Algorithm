package BAEKJOON.DynamicProgramming;

import java.util.Scanner;

public class B1463 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();
        int[] d = new int[X+1];
        for(int i=2; i<=X; i++) {
            d[i] = d[i-1] + 1; // 1을 빼는 연산
            if(i%2 == 0) { // 2로 나누는 연산
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            if(i%3 == 0) { // 3으로 나누는 연산
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
        }

        System.out.println(d[X]);
    }
}
