package D3;

import java.util.Arrays;
import java.util.Scanner;

public class S1244 {

    static int[] arr;
    static int total = 0;
    static int max = 0;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        String num;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            num = sc.next();
            total = sc.nextInt();
            arr = new int[num.length()];

            if(total > num.length()) {
                total = num.length(); // 옮기는 횟수는 숫자의 길이면 전부 옮길 수 있다.
            }

            for (int i = 0; i < num.length() ; i++) {
                arr[i] = num.charAt(i) - '0';
            }

            dfs(0, 0);


            System.out.println("#" + test_case + " " + max);

            // 초기화
            total = 0;
            num = null;
            max =0;


        }
    }

    static void dfs(int start, int cnt) {
        if(total == cnt) { // total만큼 교환을 다했으면 이전 비교값과 이번 탐색을 통해 얻은 값 중 더 큰 값을 max에 저장
            max = Math.max(max, Integer.parseInt(Arrays.toString(arr).replaceAll("[^0-9]", "")));
            return;
        }

        for (int i = start; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                // 하나씩 다 swap해보기 => 완전 탐색
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                // 비교를 위해 dfs 탐색
                dfs(i, cnt+1);

                // 다른 비교를 위해 바꾼 것을 돌려놓음
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }

    }

}
