package BAEKJOON.STackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class eatingIce_DFS_BFS {

    static int[][] v;
    static int[][] d;
    static int[] dx = {-1,0,1,0}; // 따로 배열을 만들 필요는 없어보임.
    static int[] dy = {0,-1,0,1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        d = new int[N+1][M+1];
        v = new int[N+1][M+1];
        int count = 0;

        for(int i=1; i<N+1; i++) { // i는 row
            String ices = br.readLine();
            for(int j=1; j<M+1; j++) {
                d[i][j] = ices.charAt(j-1) - '0';
            }
        }


        for(int i=1; i<N+1; i++) {
            for(int j=1; j<M+1; j++) {
                if(v[i][j] == 0 && d[i][j] == 0) { // 0이면 방문 안한거고 1이면 방문한거
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    static void dfs(int x, int y) {

//        if(v[x][y] == 1) // 재귀 종료 조건: 방문을 이미 한 경우
//            return 1;

        v[x][y] = 1; //방문 처리

        for(int i=0; i<dx.length ; i++)  {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > 0 && nx <= N && ny >0 && ny <= M) { // N, M 의 범위를 넘지 않으면서
                if(d[nx][ny] == 0) { // 방문 가능한 상태이고,
                    if(v[nx][ny] == 0)  // 방문한 적이 없으면
                        dfs(nx, ny); // dfs로 방문 탐색 시작
                }
            }
        }

    }


}
