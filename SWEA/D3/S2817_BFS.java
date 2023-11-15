package D3;

import java.util.*;

public class S2817_BFS {

    static int[] arr;
    static int K;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        arr = new int[20];

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            //bfs로 풀기
            bfs();
            sb.append("#").append(test_case).append(" ").append(count).append('\n');

            count = 0;
            Arrays.fill(arr, 0);
        }
        System.out.println(sb.toString());

        sc.close();
    }

    static void bfs() {
        Queue<Pair> que = new ArrayDeque<>();
        que.offer(new Pair(0, 0));

        while(!que.isEmpty()) {
            Pair now = que.poll();
            int index = now.index;
            int sum = now.sum;

            if(index == N) {
                if(sum == K) {
                    count++;
                }
                continue;
            }


            if(index < N) {
                que.offer(new Pair(index + 1, sum + arr[index])); // 값을 더하는 경우
                que.offer(new Pair(index + 1, sum)); // 값을 더하지 않는 경우
            }

        }

    }

    static class Pair {
        int index;
        int sum;

        Pair(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}
