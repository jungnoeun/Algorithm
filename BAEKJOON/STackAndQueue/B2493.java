package BAEKJOON.STackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N];

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // 탑의 높이들을 입력받음
            top[i] = Integer.parseInt(st.nextToken());
            stack.push(top[i]);
        }

        sb.append("0 ");


        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                stack.push(top[j]);
            }
            int now = stack.peek();
            int index = i+1;
            boolean isBig = false;
            while(!stack.isEmpty()) {
                int pop = stack.pop();
                if(pop > now) {
                    isBig = true;
                    break;
                }
                index--;
            }
            if(isBig) {
                sb.append(index).append(" ");
            } else {
                sb.append("0 ");
            }
            stack.clear();

        }

        System.out.println(sb.toString());
        br.close();
    }
}
