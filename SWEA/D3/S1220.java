package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1220 {
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;
        boolean isN = false;
        int[][] table = new int[100][100];
        int count = 0;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int table_size = Integer.parseInt(br.readLine());
            for (int i = 0; i < 100; i++) {
                Arrays.fill(table[i], 0);
            }

            isN = false;
            count = 0;

            // table 입력받기
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <100; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // table 한 줄씩 탐색
            for (int i = 0; i < 100; i++) {
                isN = false; // 다음 줄을 확인할 때 isN이 true인 상태로 남아있을 수도 있으므로 false로 초기화해줘야 함
                for (int j = 0; j < 100; j++) {
                    if(table[j][i] == 1) { // 만약 1(N)이 있으면
                        isN = true;
                    } else if(table[j][i] == 2 && isN == true) { // 위에 1(N)이 있고 현재 위치에는 2(S)가 있으면
                        count++; // 교착상태 +1
                        isN = false;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(count).append('\n');

        }

        System.out.println(sb.toString());

    }
}
