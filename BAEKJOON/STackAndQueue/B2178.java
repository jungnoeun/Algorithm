package BAEKJOON.STackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] v = new int[N+1][M+1];
        int[][] miro = new int[N+1][M+1];
        Queue<Pairs> q = new LinkedList<Pairs>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        sc.nextLine();

        // 미로 입력 받기
        for(int i=1; i<=N; i++) {
            String nums = sc.nextLine();
            for(int j=1; j<=M; j++) {
                miro[i][j] = nums.charAt(j-1) - '0';
            }
        }

        // q에 (1,1)을 넣음
        // v[1][1] = 방문
        // q에서 1,1 꺼냄
        // 위아래양옆 방문여부 확인하고 큐에 넣음
        //

        int nx, ny;

        q.offer(new Pairs(1,1));
        v[1][1] = 1;
        while(!q.isEmpty()) {
            Pairs loc = q.poll(); // 큐에서 뻄
            for(int i=0; i<4; i++) { // 상하좌우 확인
                nx = loc.x + dx[i];
                ny = loc.y + dy[i];
                if(nx<1 || nx>N || ny<1 || ny>M)
                    continue;

                if(v[nx][ny] >= 1 || miro[nx][ny] == 0) // 이미 방문을 했거나 가지 못하는 곳일때
                    continue;

                q.offer(new Pairs(nx, ny));
                v[nx][ny] = v[loc.x][loc.y] + 1;
            }
        }

        System.out.println(v[N][M]);


    }

    static class Pairs{
        int x;
        int y;

        public Pairs() {}
        public Pairs(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
