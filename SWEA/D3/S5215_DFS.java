package D3;

import java.util.Scanner;

public class S5215_DFS {

    static int N, L; // N:재료수, L:제한 칼로리
    static int[] taste; // 맛점수 모음
    static int[] cal; // 칼로리 모음
    static int max;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            L = sc.nextInt();
            taste = new int[N];
            cal = new int[N];
            max = 0;

            for (int i = 0; i < N; i++) { // 입력받기
                taste[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            dfs(0,0, 0);
            System.out.println("#" + test_case + " " + max);

        }



    }

    static void dfs(int tsum, int idx, int csum) {
        if(csum > L) {
            return;
        }
        if(idx == N) {
            if(tsum > max) {
                max = tsum;
            }
            return;
        }


        // i번째 재료를 포함하는 경우
        dfs(tsum + taste[idx], idx+1, csum + cal[idx]);

        // i번째 재료를 포함하지 않는 경우
        dfs(tsum, idx+1, csum);


    }

}
