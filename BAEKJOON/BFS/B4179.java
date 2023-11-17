package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] miro = new char[1000][1000];
        Queue<Pair> jque = new ArrayDeque<>();
        Queue<Pair> fque = new ArrayDeque<>();
        int[][] dist1 = new int[1000][1000];
        int[][] dist2 = new int[1000][1000];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                miro[i][j] = str.charAt(j);
                dist1[i][j] = -1;
                dist2[i][j] = -1;

                if(miro[i][j] == 'J') { // 지훈이의 처음 위치
                    jque.offer(new Pair(i, j));
                    dist1[i][j] = 0;
                } else if(miro[i][j] == 'F') { // 불의 처음 위치
                    fque.offer(new Pair(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        // 불이 번지는 속도 구하기
        while(!fque.isEmpty()) {
            Pair poll = fque.poll();
            int y = poll.y;
            int x = poll.x;

            int ny, nx;

            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];

                if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
                    continue;
                }

                // 이동한 위치가 J / F / # 인 경우 다음 위치 탐색
                if(dist2[ny][nx] >= 0 || miro[ny][nx] == '#') {
                    continue;
                }

                dist2[ny][nx] = dist2[y][x] + 1; // 이동한 경우 이전값 + 1 해줌
                fque.offer(new Pair(ny, nx));
            }
        }

        // 지훈이가 이동하는 속도 구하기
        while(!jque.isEmpty()) {
            Pair poll = jque.poll();
            int y = poll.y;
            int x = poll.x;

            int ny, nx;

            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];

                if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
                    System.out.println(dist1[y][x] + 1);
                    return;
                }

                // 이동한 위치가 J / F / # 인 경우 다음 위치 탐색
                if(dist1[ny][nx] >= 0 || miro[ny][nx] == '#') {
                    continue;
                }

                // 지훈이보다 불이 먼저 온 경우
                if(dist2[ny][nx] != -1 && dist2[ny][nx] <= dist1[y][x] + 1) {
                    continue;
                }

                dist1[ny][nx] = dist1[y][x] + 1; // 이동한 경우 이전값 + 1 해줌
                jque.offer(new Pair(ny, nx));
            }
        }

        System.out.println("IMPOSSIBLE");

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
