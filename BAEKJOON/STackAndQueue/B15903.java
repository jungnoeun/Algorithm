package BAEKJOON.STackAndQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 오름차순
        long input;
        for (int i = 0; i < n; i++) {
            input = sc.nextInt();
            pq.offer(input);
        }

        long value1, value2, sum;
        while (m-- > 0 && pq.size() >= 2) {
            value1 = pq.poll();
            value2 = pq.poll();
            // 큐에서 가장 작은 값 2개를 꺼내서 합을 구함
            sum = 0;
            sum = value1 + value2;

            // 꺼낸 값을 덮어써서 합친 값을 큐에 두번 넣음
            pq.offer(sum);
            pq.offer(sum);
        }

        long result = 0;
        while(!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);

        pq.clear();
        sc.close();

    }
}
