package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2814 {

    static int n;
    static boolean[] visited;
    static int[][] arr;
    static int max;

    public static void main(String args[]) throws Exception
    {

        int T;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N+1][N+1];
            visited = new boolean[N + 1];
            n = N;
            max = Integer.MIN_VALUE;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
                arr[y][x] = 1;
            }

            for (int i = 1; i < N + 1; i++) {
                dfs(1, i); // 노드 1부터 차례로 방문
                visited[i] = false; // 방문한 노드 무효 처리
            }

            System.out.println("#" + test_case + " " + max);

        }
    }

    static void dfs(int cnt, int v) {
        visited[v] = true; // 노드 방문 처리

        for (int i = 0; i < n + 1; i++) {
            if(arr[v][i] == 1 && !visited[i]) { // v와 인접한 노드인지 & 이미 방문한 노드인지 확인
                dfs(cnt + 1, i); // 방문하는 경우 노드개수+1
                visited[i] = false; // 방문 무효 처리
            }
        }
        max = Math.max(cnt, max); // 노드들을 방문한 후 경로의 길이를 비교하여 긴 값을 저장
    }
}
