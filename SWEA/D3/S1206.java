package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        StringTokenizer st;
        int[][] bd = new int[256][1000];
        int result;

        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) { // 빌딩 높이 저장
                bd[0][j] = Integer.parseInt(st.nextToken());
                if(bd[0][j]!=0) { // 만약에 건물 높이가 0이 아니면 1로 채움
                    for (int k = 1; k <= bd[0][j]; k++) {
                        bd[k][j] = 1; // 세로로 값을 채움
                    }
                }
            }

            result = 0;
            for (int j = 2; j < N-2; j++) { // 가로
                for (int k = 0; k <= bd[0][j]; k++) { // 세로
                    // 양옆 두칸 확인, 현재 위치: bd[k][j]
                    if(bd[k][j-2] == 0 && bd[k][j-1] == 0 && bd[k][j+1] == 0 && bd[k][j+2] == 0) {
                        result++;
                    }
                }
            }

            System.out.println("#" + i + " " + result);
            for (int j = 0; j < N; j++) {
                Arrays.fill(bd[j], 0);
            }
        }
    }
}
