package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2817 {

    static int[] numArr;
    static int N; // 수열의 길이
    static int M; // 합
    static int count = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        numArr = new int[20];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            sb.append("#").append(test_case).append(" ").append(count).append('\n');

            count = 0;
            Arrays.fill(numArr, 0);
        }
        System.out.println(sb.toString());

        br.close();

    }

    static void dfs(int start, int sum) {
        if(sum == M) {
            count++;
            return;
        } else if(sum > M) {
            return;
        }

        for (int i = start; i < N; i++) {
            sum += numArr[i];
            dfs(i + 1, sum);
            sum -= numArr[i];

        }

    }

}
