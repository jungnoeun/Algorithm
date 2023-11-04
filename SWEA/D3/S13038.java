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

        for(int i=1; i<=TC; i++) { // 테스트 경우 수 동안 반복
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<7; j++) { // 학교를 가는 일자를 입력받기
                day[j] = Integer.parseInt(st.nextToken());
            }

            // 첫 개강일 별 최소 일수를 minLec에 저장
            int min = Integer.MAX_VALUE;
            for(int j=0; j<7; j++) {
                if(day[j] == 1) {
                    int daycnt = j; // j번째 날을 기준으로 시작
                    int listening = 0; // 실제로 들은 강의 수

                    while(true) {
                        if(day[daycnt%7] == 1) { // 0~6 외의 날짜는 조회못하므로 %7을 사용
                            listening++; // 강의를 들어서 +1
                        }
                        daycnt++; // 다음날도 조회해야 하므로 +1

                        if(listening == N)  { // 들어야 하는 강의 수가 되었다면
                            min = Math.min(min, daycnt - j); // 기존 값과 새로 구한 값중 작은 것으로 저장
                            break;
                        }
                    }

                }
            }

            System.out.println("#"  + i + " " + min);

        }

    }
}
