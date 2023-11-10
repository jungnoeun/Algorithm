package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class S1215 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int[][] chArr = new int[8][8];
        int count = 0;

        for (int test_case = 1; test_case <= 10; test_case++) {
            count = 0;

            int N = Integer.parseInt(br.readLine()); // 탐색 개수
            int mid; // stack에 몇번째까지 넣을지
            if(N%2 == 0) { // N이 짝수인 경우
                mid = N/2;
            } else { // N이 홀수인 경우
                mid = N/2 + 1;
            }

            // 글자판 입력받기
            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    chArr[i][j] = str.charAt(j) - '0';
                }
            }


            // 글자판 가로 탐색
            for (int i = 0; i < 8; i++) { // N = 5, 76543
                for (int j = 0; j <= 8 - N; j++) {

                    for (int k = j; k < j + mid; k++) {
                        stack.push(chArr[i][k]);
                    }

                    if(N%2 == 1) {
                        stack.pop();
                    }

                    for (int k = j+mid; k < j + N; k++) {
                        if(stack.peek() == chArr[i][k]) {  // 회문이 성립한다면
                            stack.pop(); // 스택에서 값을 빼냄
                        }
                    }

                    if(stack.isEmpty()) { // 만약 스택이 비어있다면 회문 성립
                        count++;
                    } else { // stack이 안비어져 있으면 다음 연산을 위해 스택을 비움
                        stack.clear();
                    }

                }
            }


            // 글자판 세로 탐색
            for (int i = 0; i < 8; i++) { // N = 5, 76543
                for (int j = 0; j <= 8 - N; j++) {

                    for (int k = j; k < j + mid; k++) { // N=4, 2345
                        stack.push(chArr[k][i]);
                    }

                    if(N%2 == 1) {
                        stack.pop();
                    }

                    for (int k = j+mid; k < j + N; k++) {
                        if(stack.peek() == chArr[k][i]) {  // 회문이 성립한다면
                            stack.pop(); // 스택에서 값을 빼냄
                        }
                    }

                    if(stack.isEmpty()) { // 만약 스택이 비어있다면 회문 성립
                        count++;
                    } else { // stack이 안비어져 있으면 다음 연산을 위해 스택을 비움
                        stack.clear();
                    }

                }
            }


            System.out.println("#" + test_case + " " + count);

        }


        br.close();

    }
}
