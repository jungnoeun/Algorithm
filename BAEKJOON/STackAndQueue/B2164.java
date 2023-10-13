package BAEKJOON.STackAndQueue;

import java.util.*;

public class B2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=time; i++) {
            q.add(i);
        }

        while(q.size() > 1) {
            q.poll(); // 맨위 카드 버림
            int rear = q.poll();
            q.add(rear);
        }

        int result = q.poll();
        System.out.println(result);
    }
}
