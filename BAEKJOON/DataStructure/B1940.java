package BAEKJOON.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int n, cnt = 0;
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(arr[i]+arr[j] == M) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
