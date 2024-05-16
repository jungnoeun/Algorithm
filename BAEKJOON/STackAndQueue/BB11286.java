package BAEKJOON.STackAndQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BB11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 리턴값이 음수값이면 앞에 있는 값이 우선순위가 높다. 그래서(그렇게 되기 위해) swap
        // 리턴값이 양수이면 앞에 있는 값이 우선순위가 낮다. 그래서(그렇게 되기 위해) swap
        // 리턴값이 0이면 유지
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if(Math.abs(o1) == Math.abs(o2)) {
                    if(o1 > o2) {
                        return 1; // 양수: 앞이 더 크다는 이야기(내림차순으로 만들고 싶을떄)
                    }
                }
                return -1; // 음수: 앞이 더 작다는 이야기(오름차순으로 만들고 싶을때)
            }
        });

        int input, value;
        for (int i = 0; i < N; i++) {
            input = sc.nextInt();
            // 0이 아닌 값을 입력받았으면 큐에 넣음
            if(input != 0) {
                pq.offer(input);
            } else { // 0인 값을 받았으면 비어있으면 0, 아니면 큐에서 하나 빼서 출력
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    value = pq.poll();
                    System.out.println(value);
                }
            }
        }


        pq.clear();
        sc.close();

    }
}
