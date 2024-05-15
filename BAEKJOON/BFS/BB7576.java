package BAEKJOON.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BB7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        M = sc.nextInt();
        N = sc.nextInt();
        int[][] tomato = new int[N][M];
        int[][] count = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] moveY = {-1, 1, 0, 0};
        int[] moveX = {0, 0, -1, 1};
        Queue<Position> que = new LinkedList<>();
        boolean isAllOne = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tomato[i][j] = sc.nextInt();
                // 상자가 1인 경우 방문처리 + que에 삽입
                if(tomato[i][j] == 1) {
                    visited[i][j] = true;
                    que.offer(new Position(i, j));
//                    count[i][j] = 1;
                }
                if(tomato[i][j] == 0) {
                    isAllOne = false;
                }
            }
        }
        int y, x;
        int nextY, nextX;

        // 전부 다 익어있는 경우 0출력하고 종료
        if(isAllOne) {
            System.out.println(0);
            return;
        }

        while(!que.isEmpty()) {
            Position pos = que.poll();
            y = pos.y;
            x = pos.x;

            for (int i = 0; i < 4; i++) {
                // 위, 아래, 왼, 오 탐색
                nextX = x + moveX[i];
                nextY = y + moveY[i];

                // nxm 범위를 벗어난 경우
                if(nextY < 0 || nextX < 0 || nextY >= N || nextX >= M)
                    continue;

                // 이미 방문한 경우
                if(visited[nextY][nextX])
                    continue;

                // 토마토 위치 값이 -1인 경우
                if(tomato[nextY][nextX] == -1)
                    continue;


                que.offer(new Position(nextY, nextX));
                visited[nextY][nextX] = true;
                count[nextY][nextX] = count[y][x] + 1;
            }
        }

        boolean isNotTomato = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomato[i][j] == 0 && visited[i][j] == false) {
                    isNotTomato = true;
                    break;
                }
            }
            if (isNotTomato)
                break;
        }

        if(isNotTomato){
            System.out.println(-1);
        } else {
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(count[i][j] > max)
                        max = count[i][j];
                }
            }
            System.out.println(max);
        }


        sc.close();
    }

    static class Position {
        int y,x;
        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
