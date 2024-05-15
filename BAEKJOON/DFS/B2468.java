package BAEKJOON.DFS;

import java.util.Arrays;
import java.util.Scanner;

public class B2468 {
    static int[][] area;
    static int[][] waterArea; // 잠긴 지역 -1 표시
    static boolean[][] visited;
    static int[] moveX = {-1,1,0,0};
    static int[] moveY = {0,0,-1,1};
    static int N;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        area = new int[N][N];
        waterArea = new int[N][N];
        visited = new boolean[N][N];
        int max = 1;
        int maxHeight = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] = sc.nextInt();
                if(area[i][j] > maxHeight) {
                    maxHeight = area[i][j];
                }
            }
        }

        // N은 2~100까지 비교
        for (int i = 2; i <= maxHeight; i++) {
            count = 0;

            // 초기화 설정
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // 만약 i보다 낮은 위치면 -1
                    if(area[j][k] < i) {
                        waterArea[j][k] = -1;
                    }else { // 만약 i보다 높거나 같은 위치면 물에 안잠겨서 값 그대로 유지
                        waterArea[j][k] = area[j][k];
                    }
                }
                Arrays.fill(visited[j], false);
            }



            // 처음부터 한칸씩 이동
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(visited[j][k] == false && waterArea[j][k] != -1) {
                        dfs(j,k);
                        count++;
                    }
                }
            }
            // 최대 안전영역일때 최대count 값과 resultCount의 개수를 갱신
            if(count > max) {
                max = count;
            }
//            System.out.println("높이: " + i + " count: " + count + " max: " + max );
        }

        System.out.println(max);
        sc.close();
    }

    static void dfs(int y, int x) {
        // 방문한 지역임을 표시
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            // 앞으로 이동할 위치
            int nextY = y + moveY[i];
            int nextX = x + moveX[i];

            // 범위를 넘어서면 다른방향으로
            if(nextY < 0 || nextX < 0 || nextY >= N || nextX >= N) {
                continue;
            }

            // 잠긴지역이면 pass
            if(waterArea[nextY][nextX] == -1) {
                continue;
            }

            // 이미 방문한 지역이면 패스
            if(visited[nextY][nextX]) {
                continue;
            }

            visited[nextY][nextX] = true;
            dfs(nextY, nextX);
//            visited[nextY][nextX] = false;
        }
    }
}
