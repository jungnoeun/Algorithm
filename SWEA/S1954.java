import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S1954 {

    static int[][] arr;
    static int ln, rn, un, dn, n;
    static int cnt = 1;

    public static void main(String[] args) throws Exception
    {
        // 달팽이 단계를 입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sNum = br.readLine();
        int T = Integer.parseInt(sNum);
//        int[][] arr;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            ln = 0;
            rn = N;
            un = 0;
            dn = N;
            n = N;

            arr = new int[N][N];

            dfs(0,0);

            for (int[] ints : arr) {
                for (int anInt : ints) {
                    System.out.println(anInt + " ");
                }
                System.out.println();
            }

            /**
             * 1. 이차원 배열에 값을 저장 가장 오른쪽 값, 왼쪽 값, 아래 값, 위 값 변수를 설정해서 끝이면 +1 또는 -1하기
             * 2. DFS 로 풀기 (오른쪽, 아래쪽, 왼쪽, 위쪽 순으로 우선순)
             * (0,0) 부터
             *
             */


        }


        br.close();

    }

    public static void dfs(int x, int y) {
        if(cnt >= n*n) {
            arr[x][y] = cnt;
            return;
        }
        else {
            if(x>=0 && x<n && y>=0 && y<n)
            arr[x][y] = cnt;
        }

        if(x == rn-1 && y == un) { // 가장 오른쪽 위
            rn--;
            un++;
            dfs(x,y+1);
        }
        else if(x == ln && y == un) { // 가장 왼쪽 위
            ln++;
            un++;
            dfs(x+1, y);
        }
        else if(y == dn-1 && x == rn-1) { // 가장 오른쪽 아래
            dn--;
            rn--;
            dfs(x-1, y);
        }
        else if(y == dn-1 && x == ln) { // 가장 왼쪽 아래
            dn--;
            ln++;
            dfs(x, y-1);
        }
        else if(x == rn-1)  {
            dfs(x,y+1);
        }
        else if(y == un) {
            dfs(x+1,y);
        }
        else if(x == ln) {
            dfs(x, y-1);
        }
        else if(y == dn-1) {
            dfs(x, y-1);
        }

    }


}
