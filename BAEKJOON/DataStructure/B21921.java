package BAEKJOON.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 지난 일수
        int X = Integer.parseInt(st.nextToken()); // 며칠 동안? 기준 날짜
        int sum = 0;
        int max = 0;
        int week = 1;

        int[] visitor = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        for(int i=0; i<X; i++) {
            sum += visitor[i];
        }
        max = sum;

        for(int i=X; i<N; i++) {
            int j = i-X; // i는 오른쪽 끝에 추가되는 숫자, j는 왼쪽 끝에서 빠지는 숫자
            sum += visitor[i];
            sum -= visitor[j];
            if(sum>max){
                max = sum;
                week = 1;
            }
            else if (sum == max){
                week++;
            }

        }

        if(max == 0)
            System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(week);
        }

    }
}
