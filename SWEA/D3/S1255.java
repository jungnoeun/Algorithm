package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1255 {
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            // 큐에 값 넣기
            for (int i = 0; i < 8; i++) {
                que.offer(Integer.parseInt(st.nextToken()));
            }

            int minus = 0;
            // 큐에서 앞에서 하나씩 뽑아서 -연산하고 다시 넣기
            while(true) {
                int output = que.poll(); // 앞에서부터 하나씩 뺌
                minus = minus % 5 + 1; // 1~5까지 뺴기 가능

                int input = output - minus;

                if(input <= 0) { // 마지막 숫자가 0이 되었으면 큐에 넣고 break
                    que.offer(0);
                    break;
                }

                que.offer(input); // 마지막 숫자가 0이 아니면 큐에 넣고 연산을 계속

            }

            sb.append("#").append(test_case).append(" ");
            while(!que.isEmpty()) {
                sb.append(que.poll()).append(" ");
            }
            sb.append('\n');

            que.clear();

        }
        System.out.println(sb.toString());
        br.close();

    }
}
