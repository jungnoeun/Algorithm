package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1860 {
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        boolean isPossible = true;
        StringBuilder sb = new StringBuilder();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arrive = new int[N];
            Arrays.fill(arrive, 0);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrive[i] = Integer.parseInt(st.nextToken());
            }

            isPossible = true;
            int babbang = 0; // 만든 붕어빵의 수
            Arrays.sort(arrive); // 오름차순 정렬

            int multi = 1;

            if(arrive[0] >= M) { // arrive[0] < M 이면 impossible.
                for (int i = 0; i < N; i++) {
                    if(i == 0) {
                        babbang = babbang + (arrive[0] / M) * K; // 초기 붕어빵 값
                        multi = arrive[0] / M;
                        babbang--;
                    } else if(babbang == 0 && arrive[i] / M > multi) { // 붕어빵을 채울 수 있는 경우
                        babbang = babbang + (arrive[i] / M - multi) * K;
                        multi = arrive[i] / M;
                        babbang--;
                    } else if(babbang > 0) { // 붕어빵을 제공할 수 있는 경우
                        babbang--;
                    } else {
                        isPossible = false;
                        break;
                    }
                }

            } else {
                isPossible = false;
            }

            sb.append("#").append(test_case).append(" ");
            if (isPossible) {
                sb.append("Possible");
            }else {
                sb.append("Impossible");
            }
            sb.append('\n');

        }

        System.out.println(sb.toString());

    }
}
