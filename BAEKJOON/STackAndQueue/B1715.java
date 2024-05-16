package BAEKJOON.STackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 오름차순

        long input;
        for (int i = 0; i < N; i++) {
            input = sc.nextLong();
            pq.offer(input);
        }

        long sum = 0;
        while(pq.size()>1) { // 2개 이상의 값이 있어야 비교가 가능하다.
            // 작은 값부터 더해나가야 하므로 앞서 뽑았던 값들도 다시 비교하기 위해 큐에 다시 넣어서 연산을 기다리게 한다.
            long value1 = pq.poll();
            long value2 = pq.poll();
            sum += value1 + value2;
            pq.offer(value1 + value2);
        }

        System.out.println(sum);

        sc.close();
    }
}
