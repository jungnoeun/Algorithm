package BAEKJOON.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class B1103 {
    static int N, M, max;
    static char[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static boolean repeat = false;
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N+1][M+1];
        dp = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        int input;

        // board 에 값 채우기
        for (int i = 1; i < N + 1; i++) {
            String str = sc.next();
            for (int j = 1; j < M + 1; j++) {
                board[i][j] = str.charAt(j-1);
            }
        }

        dp[1][1] = 1;
        visited[1][1] = true;

        dfs(1, 1, 1);
        if(repeat)
            System.out.println(-1);
        else {
            System.out.println(max);
        }

        sc.close();
    }

    static void dfs(int y, int x, int count) {
        int move = Character.getNumericValue(board[y][x]); // board[x][y]값
        dp[y][x] = count;
        if(count > max) {
//            System.out.println(count + ".." + y + "," + x);
            max = count;
        }

        for (int i = 0; i < moveX.length; i++) {
            int nextX = x + (move * moveX[i]);
            int nextY = y + (move * moveY[i]);

            // 보드 밖을 벗어나면 게임 종료
            if(nextX < 1 || nextY < 1 || nextY > N || nextX > M)
                continue;

            // 구멍에 빠지면 게임 종료
            if(board[nextY][nextX] == 'H')
                continue;

            // count : 현재까지의 이동횟수
            // dp[nextY][nextX] : 다음 위치의 이동횟수
            // 지금 방문하려는 곳이 현재 count 값보다 크면 굳이 방문하지 않는다.
            // 방문해도 잘하면 같고, 아니면 이동해도 (+1해도) 어차피 작음
            if(count < dp[nextY][nextX]) {
                continue;
            }

            // 무한히 반복되는 구조면 게임 종료하고 -1 출력
            if(visited[nextY][nextX]) {
                repeat = true;
                return;
            }

            visited[nextY][nextX] = true;
            dfs(nextY, nextX, count+1);
            visited[nextY][nextX] = false;
            // 이때 false로 바꿔주는 이유는 상하좌우로 움직이면서 가장 큰 count값을 찾기 위해 여러 경로를 탐색하기 위해 false로 설정해 처음 상태로 돌려준다.

        }

    }

}
