package BAEKJOON.STackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class B10773 {
    public static void main(String[] args) throws Exception {

        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if(num == 0) { // 입력받은 값이 0일 경우 최근 수를 지움
                stack.pop();
            } else { // 입력받은 값이 0이 아니면 새로 추가
                stack.push(num);
            }
        }

        int sum = 0;

        while(!stack.isEmpty()) {
            int pop = stack.pop();
            sum += pop;
        }

        System.out.println(sum);

    }
}
