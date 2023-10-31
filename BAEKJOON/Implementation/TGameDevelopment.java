package BAEKJOON.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TGameDevelopment {

    static int N, M;
    static int[][] place;
    static int[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        place = new int[N][M];
        d = new int[N][M];
        int checkVisit = 0, count = 1;


        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int direct = Integer.parseInt(st.nextToken());

        // 바다 육지 입력받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true) {
            d[y][x] = 1;
            // 만약 방향이 북쪽이면, 서쪽으로 이동
            if(direct == 0) {
                if(checkMove(x-1, y) == true) {
                    x = x-1;
                    d[y][x] = 1;
                    checkVisit = 0;
                    count++;
                }
               else checkVisit++;
            }

            // 방향이 서쪽이면 남쪽으로 이동
            else if(direct == 3) {
                if(checkMove(x, y + 1) == true) {
                    y = y+1;
                    d[y][x] = 1;
                    checkVisit = 0;
                    count++;
                }
                else checkVisit++;
            }

            // 방향이 남쪽이면 동쪽으로 이동
            else if(direct == 2) {
                if(checkMove(x+1, y) == true) {
                    x = x+1;
                    d[y][x] = 1;
                    checkVisit = 0;
                    count++;
                }
                else checkVisit++;
            }

            // 방향이 동쪽이면 북쪽으로 이동
            else if(direct == 1) {
                if(checkMove(x, y - 1) == true) {
                    y = y - 1;
                    d[y][x] = 1;
                    checkVisit = 0;
                    count++;
                }
                else checkVisit++;
            }

            direct = checkDirect(direct);

            if(checkVisit == 4) {
                break;
            }
        }

        System.out.println(count);

    }

    static int checkDirect(int dir) { // 방향을 설정
        if(dir == 0) {
            return 3;
        }
        return dir-1;
    }

    static boolean checkMove(int x, int y) { // 이동가능한지 체크하는 함수

        if(y<0 || x<0 || x>=M || y>=N) { // 이동할 곳이 NxM을 벗어나면 false 리턴
            return false;
        }
        else if(place[y][x] == 1) { // 이동할 곳이 바다이면 false 리턴
            return false;
        }
        else if(d[y][x] == 1) { // 이미 방문한 곳이라면
            return false;
        }
        return true;
    }
}
