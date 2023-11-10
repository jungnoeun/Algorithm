package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1208 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N;
        int[] arr = new int[101];
        for (int test_case = 1; test_case <= 10; test_case++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 101; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                Arrays.sort(arr);
                arr[1]++;
                arr[100]--;
            }
            Arrays.sort(arr);
            bw.write("#" + test_case + " " + (arr[100]-arr[1]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
