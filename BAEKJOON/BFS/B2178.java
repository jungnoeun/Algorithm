package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2178 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pair> que = new ArrayDeque<>();

        int[][] miro = new int[100][100];
        int[][] visited = new int[100][100];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = str.charAt(j) - '0';
            }
        }

        que.offer(new Pair(0, 0));
        visited[0][0] = 1;
        while (!que.isEmpty()) {
            Pair poll = que.poll();
            int y = poll.y;
            int x = poll.x;
            int ny, nx;
            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }
                if(visited[ny][nx] >= 1 || miro[ny][nx] == 0) {
                    continue;
                }
                que.offer(new Pair(ny, nx));
                visited[ny][nx] = visited[y][x] + 1;
            }
        }

        System.out.println(visited[N-1][M-1]);
        br.close();

    }

    static class Pair {
        int x;
        int y;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }


    }

}
