package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1493 {
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int x = 1, y = 1, idp = 1;
            int dx = 2, dy = 1;
            int rx, ry;
            int px=1, py=1, qx=1, qy=1;

            // p 범위 찾기
            while(true) {
                if(y <= p && p <= x) {
                    break;
                }
                x += dx; // x축 위치의 값
                y += dy; // y축 위치의 값
                dx++;
                dy++;
                idp++;

            }


            if(p == x) {
                px = idp;
                py = 1;
            } else if(p == y) {
                py = idp;
                px = 1;
            } else { //  y < p < x
                py = 1;
                px = idp;
                while(x != p) {
                    px--;
                    py++;
                    x--;
                }
            }




            x=1; y=1; dx=2; dy =1;
            int idq = 1;
            // q 범위 찾기
            while(true) {
                if(y <= q && q <= x) {
                    break;
                }
                x += dx;
                y += dy;
                dx++;
                dy++;
                idq++;

            }

            if(q == x) {
                qx = idq;
                qy = 1;
            } else if(q == y) {
                qy = idq;
                qx = 1;
            } else { //  y < q < x
                qy = 1;
                qx = idq;
                while(x != q) {
                    qx--;
                    qy++;
                    x--;
                }
            }



            // p좌표와 q좌표 더한 (rx, ry) 좌표 구하기
            rx = px + qx;
            ry = py + qy;
            int minus = 0;

            // (rx, ry) -> (rx + k, ry -k == 0) -> value - k
            while(ry != 1) {
                ry--;
                rx++;
                minus++;
            }

            int start = 1;
            int plus = 2;
            while(rx-- > 1) {
                start += plus;
                plus++;
            }

            start -= minus;

            sb.append("#").append(test_case).append(" ").append(start).append('\n');

        }
        System.out.println(sb.toString());

    }
}
