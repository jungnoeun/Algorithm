package BAEKJOON.Recursion;

import java.util.Scanner;

public class B1629 {

    static int result = 1;
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        sc.close();
        dfs(A,B,C,0);
        System.out.println(result);

    }

    static void dfs(int A, int B, int C, int cnt) {
        if (B == cnt) {
            return;
        }

        result *= A;
        if (result >= C) {
            result %= C;
        }
        cnt++;

        dfs(A, B, C, cnt);

    }
}
