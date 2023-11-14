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
                System.out.println();
                board[by][bx] = rock;
                isChange = false;
                checkBoard();
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        System.out.print(board[j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println("=========================");
            }

            while(isChange) {
                isChange = false;
                checkBoard();
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        System.out.print(board[j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println("=========================");
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

    static void checkBoard() {
        int[] dx1 = {1,-1, 1, 0}; // 상하좌우대각선
        int[] dy1 = {1, 1, 0, 1};

        int[] dx2 = {-1, 1, -1, 0};
        int[] dy2 = {-1, -1, 0, -1};


        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 0; k < 4; k++) {
                    if(i+dy1[k] <= N && j+dx1[k] <= N && i+dy2[k] <= N && j+dx2[k] <= N &&
                            i+dy1[k] >= 1 && j+dx1[k] >= 1 && i+dy2[k] >= 1 && j+dx2[k] >= 1) {
                        if(board[i][j] == 0)
                            continue;

                        if (board[i][j] != board[i + dy1[k]][j + dx1[k]] && board[i + dy1[k]][j + dx1[k]] != 0 && board[i + dy1[k]][j + dx1[k]] == board[i + dy2[k]][j + dx2[k]]) {
                            board[i][j] = board[i + dy1[k]][j + dx1[k]];
                            isChange = true;
                        }
                    }
                }

            }
        }
    }
}
