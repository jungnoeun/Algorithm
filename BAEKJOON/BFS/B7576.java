package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[1000][1000];
        Queue<Pair> que = new ArrayDeque<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean isZero = false;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 토마토 상자 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
//                    startX = j;
//                    startY = i;
                    // 처음에는 1이 있는 곳 하나만 선택해서 큐에 넣고 시작했다.
                    // 하지만 여러 곳에 1이 있으면 동시에 진행되므로 1이 있는 위치는 다 넣어주어야 한다.
                    que.offer(new Pair(i, j));
                }
            }
        }

//        que.offer(new Pair(startY, startX));
//        visited[startY][startX] = 1;

        while(!que.isEmpty()) {
            Pair now = que.poll();
            int y = now.y;
            int x = now.x;
            int ny = 0, nx = 0;
            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    continue;
                }

                if(arr[ny][nx] == 0) {
                    arr[ny][nx] = arr[y][x] + 1;
                    que.offer(new Pair(ny, nx));
                }


            }

        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    isZero = true;
                    break;
                }
                if(arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        if(isZero) {
            System.out.println(-1);
        } else {
            System.out.println(max-1);
        }

        br.close();

    }

    static class Pair {
        int y;
        int x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
