package BAEKJOON.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TlawOfLargeNumbers {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        // 리스트 값 입력받기
        Integer[] list = new Integer[N];
        for(int i=0; i<N; i++) {
            list[i] = sc.nextInt();
        }

        // 큰 수를 만들기 위해 가장 큰 값과 두 번째로 큰 값을 골라냄
        Arrays.sort(list, Collections.reverseOrder());
        int max = list[0];
        int sec = list[1];


        // 큰 수 만들기
        for(int i=0; i<M; i++) {
            for(int j=0; j<K; j++) {
                result += max;
                i++;
            }
            result += sec;
            i++;
        }

        System.out.println(result);

    }

}
