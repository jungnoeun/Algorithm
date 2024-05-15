package BAEKJOON.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BB2178 {

    public static void main(String[] args) {
        int[][] miro = new int[100][100];
        int[][] count = new int[100][100];
        boolean[][] visited = new boolean[100][100];
        int N, M;
        int[] moveY = {-1,1,0,0};
        int[] moveX = {0, 0, -1, 1};

        Queue<Position> que = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                miro[i][j] = str.charAt(j) - '0';
            }
        }

        que.offer(new Position(0, 0));
        visited[0][0] = true;
        count[0][0] = 1;
        int nextY=0, nextX = 0;

        while(!que.isEmpty()) {
            Position pos = que.poll();
            int y = pos.y;
            int x = pos.x;
            for (int i = 0; i < 4; i++) {
                nextY = y + moveY[i];
                nextX = x + moveX[i];


                // nxm 범위를 벗어나는 경우
                if(nextY < 0 || nextX < 0 || nextY >= N || nextX >= M)
                    continue;

                // 이미 방문한 경우
                if(visited[nextY][nextX])
                    continue;

                // 칸의 값이 0인 경우
                if(miro[nextY][nextX] == 0)
                    continue;

                // count 배열에 현재 위치까지 오는데 지난 칸수를 기록
                count[nextY][nextX] = count[y][x] + 1;
                visited[nextY][nextX] = true;
                que.offer(new Position(nextY, nextX));

            }

        }

        System.out.println(count[N - 1][M - 1]);
        sc.close();
    }

    static class Position {
        int x,y;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
