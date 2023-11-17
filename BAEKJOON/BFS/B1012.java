package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1012 {

    static int[][] visited;
    static int[][] arr;
    static int M, N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        arr = new int[50][50];
        visited = new int[50][50];
        int x,y;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 위치 개수

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1; // 배추 존재
            }

            int count = 0; // 배추가 있는 구역의 개수

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 1 && visited[i][j] == 0) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);

            // 초기화
            for (int i = 0; i < N; i++) {
                Arrays.fill(arr[i], 0);
                Arrays.fill(visited[i], 0);
            }

        }

        br.close();
    }

    static void bfs(int sy, int sx) {
        Queue<Pair> que = new ArrayDeque<>();
        que.offer(new Pair(sy, sx));
        visited[sy][sx] = 1;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!que.isEmpty()) {
            Pair now = que.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx <0 || ny >= N || nx >= M) {
                    continue;
                }
                if(visited[ny][nx] == 0 && arr[ny][nx] == 1) {
                    que.offer(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] +1;
                }

            }

        }

    }

    static class Pair {
        int y, x;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
