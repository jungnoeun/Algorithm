package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B1926 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pair> que = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열
        int[][] arr = new int[500][500];
        boolean[][] visited = new boolean[500][500];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};


        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int size = 0;
                que.clear();

                if(arr[i][j] == 1 && !visited[i][j]) {
                    que.offer(new Pair(i, j));
                    visited[i][j] = true;
                    count++;
                    size++;
                }

                while(!que.isEmpty()) {
                    Pair cur = que.poll();
                    int x = cur.x;
                    int y = cur.y;

                    int nx, ny;

                    for (int k = 0; k < 4; k++) {
                        nx = x + dx[k];
                        ny = y + dy[k];

                        if(nx < 0 || ny < 0 || nx >=m || ny >= n) {
                            continue;
                        }
                        // 이미 방문한 곳이거나 그림 영역이 아닌 경우
                        if(visited[ny][nx] || arr[ny][nx] == 0) {
                            continue;
                        }


                        // 그림 영역인 경우 이동 => 큐에 넣음
                        visited[ny][nx] = true;
                        que.offer(new Pair(ny, nx));
                        size++;

                    }

                }

                if(size > max) {
                    max = size;
                }

            }
        }

        System.out.println(count);
        System.out.println(max);

        br.close();
    }

    static class Pair {
        int x,y;
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
