package BAEKJOON.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12847 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 일수
        int m = Integer.parseInt(st.nextToken()); // 가능 일수
        Long sum = 0L;
        Long max = 0L;

        int[] salary = new int[n]; // 일별 급여
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            salary[i] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 윈도우 슬라이딩
        for(int i=0; i<m; i++) {
            sum += salary[i];
        }
        max = sum;

        // 두번째~ 윈도우 슬라이딩
        for(int i=m; i<n; i++) {
            int j = i - m; //j: 왼쪽부터 빠지는 수(봉급), i: 오른쪽부터 추가되는 수(봉급)
            sum -= salary[j];
            sum += salary[i];
            if(sum > max) max = sum;
        }

        System.out.println(max);

    }
}
