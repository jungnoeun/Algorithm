package D3;

import java.util.Scanner;

public class S5431 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, K;
        int[] notSubmit;
        for(int i=0; i<T; i++) {
            N = sc.nextInt();
            K = sc.nextInt();
            notSubmit = new int[N+1];
            for(int j=1; j<=K; j++) {
                int submit = sc.nextInt();
                notSubmit[submit]++;
            }

            System.out.print("#" + (i+1));
            for(int j=1; j<=N; j++) {
                if(notSubmit[j] == 0) {
                    System.out.print(" "+ j);
                }
            }
            System.out.println();
        }
    }
}
