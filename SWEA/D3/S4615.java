package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4615 {

    static int[][] board;
    static int N;
    static boolean isChange;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int M;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 보드 한변 길이. 4 6 8
            M = Integer.parseInt(st.nextToken()); // 돌을 놓는 횟수

            board = new int[N + 1][N + 1];
            int bx, by;
            bx = N/2;
            by = N/2;

            // 초기 세팅
            board[bx][by] = 2;
            board[bx+1][by] = 1;
            board[bx][by+1] = 1;
            board[bx+1][by+1] = 2;

            int rock;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                by = Integer.parseInt(st.nextToken());
                bx = Integer.parseInt(st.nextToken());
                rock = Integer.parseInt(st.nextToken());

                board[by][bx] = rock;

                checkBoard(by, bx);

            }


            int w = 0, b = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(board[i][j] == 1) {
                        b++;
                    } else if(board[i][j] == 2) {
                        w++;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(b).append(" ").append(w).append('\n');

        }
        System.out.println(sb.toString());

    }

    static void checkBoard(int y, int x) {
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1}; // 상하좌우대각선
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            while(true) {
                if (ny < 1 || ny > N || nx < 1 || nx > N) {
                    break;
                }
                if(board[ny][nx] == 0) { // 0이면 상하좌우대각선에 같은게 있어도 안바뀜
                    break;
                }
                if(board[y][x] != board[ny][nx]) {
                    ny += dy[i];
                    nx += dx[i];
                }
                else { // board[y][x] == board[ny][nx]
                    break;
                }
            }

            if((ny >= 1 && ny <= N && nx >= 1 && nx <= N ) && board[ny][nx] == board[y][x]) {
                while(y != ny || x != nx) { // board[y][x] == board[ny][nx] 이므로 이 사이의 값을 다 바꿔줌
                    board[ny][nx] = board[y][x];
                    ny -= dy[i];
                    nx -= dx[i];
                }
            }

        }


    }
}
