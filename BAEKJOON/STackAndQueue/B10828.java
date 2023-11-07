package BAEKJOON.STackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String doing = st.nextToken();
            if(doing.equals("push")) {
                int input = Integer.parseInt(st.nextToken());
                stack.push(input);
            } else if(doing.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int top = stack.peek();
                    System.out.println(top);
                }
            } else if(doing.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(doing.equals("pop")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int pop = stack.pop();
                    System.out.println(pop);
                }
            } else if(doing.equals("size")) {
                int size = stack.size();
                System.out.println(size);
            }
        }

    }
}
