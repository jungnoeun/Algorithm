package BAEKJOON.STackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N];

        Stack<int[]> stack = new Stack<>(); // (탑 높이, 탑 순서)
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) { // 스택이 비어있지 않으면
                if(stack.peek()[0] < now) { // 맨앞의 탑이 현재 탑보다 작으면 pop
                    stack.pop();
                } else { // 맨 앞의 탑이 현재 탑보다 크면 해당 탐의 순서를 출력
                    System.out.print(stack.peek()[1] + " ");
                    break;
                }
            }
            if(stack.isEmpty()) { // 스택이 비어있으면 전부 탐색한 것이므로 0을 출력
                System.out.print("0 ");
            }

            stack.push(new int[]{now, i + 1}); // 탑의 높이와 순서를 하나씩 넣음 6부터...

        }

    }
}
