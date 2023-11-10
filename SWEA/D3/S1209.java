package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1209 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[100][100];
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;

            // 배열의 값들을 입력받아 arr[][]에 저장
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로 탐색
            int sum=0;
            for (int i = 0; i < 100; i++) {
                sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                if(sum > max) {
                    max = sum;
                }
            }

            // 세로 탐색
            for (int i = 0; i < 100; i++) {
                sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += arr[j][i];
                }
                if(sum > max) {
                    max = sum;
                }
            }

            // 내려가는 대각선 탐색
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += arr[0+i][0+i];
            }
            if(sum > max) {
                max = sum;
            }

            // 올라가는 대각선 탐색
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += arr[99-i][0+i];
            }
            if(sum > max) {
                max = sum;
            }

            sb.append("#").append(N).append(" ").append(max).append('\n');

        }

        System.out.println(sb.toString());

    }
}
