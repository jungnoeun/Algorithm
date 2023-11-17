package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {

    static int[][] arr = new int[300][300];
    static int[][] visited = new int[300][300];
    static int l;
    static int sx, sy, dx, dy;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            l = Integer.parseInt(br.readLine());

            // 시작점
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            // 도착점
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(visited[dy][dx] - 1);

            // 초기화
            for (int i = 0; i < l; i++) {
                Arrays.fill(arr[i], 0);
                Arrays.fill(visited[i], 0);
            }
        }

        br.close();
    }

    static void bfs() {
        Queue<Pair> que = new ArrayDeque<>();
        que.offer(new Pair(sy, sx));
        visited[sy][sx] = 1;
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};

        while(!que.isEmpty()) {
            Pair now = que.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= l || ny >= l) {
                    continue;
                }

                if(visited[ny][nx] == 0) {
                    que.offer(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                }

            }

        }

    }

    static class Pair {
        int x,y;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
