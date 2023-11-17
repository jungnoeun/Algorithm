package BAEKJOON.BFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B1697_BFS {

    static int[] visited = new int[100001];
    static int N;
    static int K;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if(N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }


        sc.close();
    }

    static void bfs(int num) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(num);
        visited[num] = 1;

        while(!que.isEmpty()) {
            int temp = que.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if(i == 0) { // 현재위치 + 1
                    next = temp + 1;
                } else if(i == 1) { // 현재 위치 -1
                    next = temp - 1;
                } else {
                    next = temp * 2; // 현재 위치 *2
                }

                if(next == K) { // K에 도착한 경우 return
                    System.out.println(visited[temp]);
                    return;
                }

                // K-1이 최대 값일 수도 있음. 그래서 next <= visited.length로 한 것임
                if(next >= 0 && next <= visited.length && visited[next] == 0) {
                    que.offer(next);
                    visited[next] = visited[temp] + 1;
                }

            }

        }


    }

}
