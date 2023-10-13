package BAEKJOON.STackAndQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11286 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return 1;  // swap
                } else if(Math.abs(o1) == Math.abs(o2)){
                    if(o1 > o2) {
                        return 1; // swap
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();

        for(int i=0; i<time; i++) {
            int x = sc.nextInt();

            if(x == 0) { //x == 0
                if(pq.size() ==0) { // empty
                    System.out.println(0);
                } else { // not empty
                    int pNum = pq.poll();
                    System.out.println(pNum);
                }
            } else { // add
                pq.offer(x);
            }
        }

        pq.clear();

    }
}
