package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S13038 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] day = new int[8];
        int[] minLec = new int[8];
        int it = 0;
        int result = 0;
        int minStart = 0;

        for(int i=1; i<=TC; i++) { // 테스트 경우 수 동안 반복
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=7; j++) { // 학교를 가는 일자를 입력받기
                day[j] = Integer.parseInt(st.nextToken());
            }

            it = 1; // 일주일 동안 강의를 들을 수 있는 최대 일수
            for (int j = 1; j <= 7; j++) { // 강의 j번에(j<7) 따라 들어야 하는 최소한의 일수
                if(day[j] == 1) {
                    if(it == 1) {
                        minStart = j-1;
                    }
                    minLec[it++] = j;
                }
            }

            it -= 1; // 7일동안 강의를 들을 수 있는 최대의 날짜 수

            if(it == 1) {
                result = 7*(N-1) + minLec[1] - minStart;
            }
            else {
                result = (N/it) * 7;
                result += minLec[N % it];
                result -= minStart;
            }

            System.out.println("#"  + i + " " + result);

        }

    }
}
