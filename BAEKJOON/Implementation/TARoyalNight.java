package BAEKJOON.Implementation;

import java.util.Scanner;

public class TARoyalNight {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String loc = sc.next();
        int locX = loc.charAt(0) - 97;
        int locY = loc.charAt(1) - '0' -1;
        int count = 0;
        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

        for(int i=0; i<8; i++) {
            if (checkEnd(locX + dx[i], locY + dy[i]) == true) {
                count++;
            }
        }

        System.out.println(count);

    }

    static boolean checkEnd(int x, int y) { // 이동가능한지 여부를 체크하는 함수
        if(x<0 || x>7 || y<0 || y>7) { // x,y위치가 끝을 벗어나면 이동 불가
            return false;
        }
        return true; //x,y가 이동가능한 위치이면 이동 가능
    }

}
