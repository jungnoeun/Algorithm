package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14178 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int N, M;
        int water = 0;
        int count = 0;

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            water = 1;
            water += (2 * M);

            if (N % water == 0) {
                System.out.println("#"+ i + " " + N / water);
            } else {
                System.out.println("#"+ i + " " + ((N / water) + 1));
            }

        }
    }
}
