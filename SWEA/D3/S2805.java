package D3;

import java.util.Scanner;

public class S2805 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int N;
        int[][] arr;
        int value, sum=0;
        int end;
        int start;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt(); // 홀수
            sum = 0;
            int mid = N/2 + 1;

            for (int i = 1; i <= N; i++) {
                String line = sc.next();
                if(i>mid) {
                    start = mid - (N - i);
                    end = mid + (N - i);
                } else {
                    start = mid - (i-1); // 덧셈을 하는 시작
                    end = mid + (i-1); // 덧셈 끝
                }

                for (int j = 1; j <= N; j++) {
                    value = line.charAt(j - 1) - '0';

                    if(j >= start && j<= end) {
                        sum+=value;
                    }

                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
        sc.close();
    }
}
