package BAEKJOON.STackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // n (몇번인지) 입력받음
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int[] arr = new int[time];

        for(int i=1; i<=time; i++) {
            arr[i-1] = sc.nextInt();
        }
        int num = 1;
        int input;
        StringBuilder sb = new StringBuilder();
        boolean result = true;

        // 하나씩 입력받으면서 pop/push 결정
        for(int i=0; i<time; i++) {
            input = arr[i];
            if(input >= num) {
                while(input >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop(); // 같게 만들어주고 출력을 위해 pop
                sb.append("-\n");
            } else {
                int pop = stack.pop(); // pop이 5이고 출력해야 하는 값이 3일 경우, 3이 아닌 5를 pop해야 하므로 3이 아닌 값을 출력하게 된다. 그래서 NO.
                if(pop > input) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else { // input과 pop 이 같은 수이면
                    sb.append("-\n");
                }
            }
        }

        if(result) System.out.println(sb.toString());

    }

}