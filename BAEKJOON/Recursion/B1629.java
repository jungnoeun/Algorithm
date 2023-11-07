package BAEKJOON.Recursion;

import java.util.Scanner;

public class B1629 {

    static int result = 1;
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        long C = sc.nextLong();

        sc.close();
        dfs(A,B,C);
        System.out.println(result);

    }

    static long dfs(int A, int B, long C) {
        if (B == 0) {
            return 1;
        }

        long n = dfs(A,B/2, C); // {(A^n * A^n) * (A^n * A^n)} % C ==  (A^n * A^n %C) * (A^n * A^n %C)

        if(B%2 == 0) { // 짝수번 곱하면
            return n * n % C; // a^4 = a^2 * a^2
        } else { // 홀수번 곱하면
            return (n*n%C) * (A % C); // a^5 = a^3 * a^2
        }

    }
}
