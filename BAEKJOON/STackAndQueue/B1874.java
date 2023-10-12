package BAEKJOON.STackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // n (몇번인지) 입력 받음
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int input;
        StringBuilder sb = new StringBuilder();

        int start = 0;


        // 하나씩 입력받으면서 pop/push 결정
        for(int i=0; i<time; i++) {
            input = sc.nextInt();

            if(input > start) {
                for(int j=start+1; j<=input; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                start = input;
            } else if(stack.peek() != input) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb.toString());
    }
}
