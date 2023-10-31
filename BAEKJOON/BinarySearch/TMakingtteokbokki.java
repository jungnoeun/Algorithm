package BAEKJOON.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class TMakingtteokbokki {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] ts = new int[N];
        for(int i=0; i<N; i++) { // 떡길이 입력
            ts[i] = sc.nextInt();
        }

        Arrays.sort(ts);
        int start = 0, end = ts[N - 1];
        int mid = (start+end)/2; // 자를 떡길이 기준
        int notFound = 0;

        while(true) {
            if(calcLength(ts, mid) == M) { // 요청한 떡길이를 찾은 경우
                System.out.println("찾았다" + mid);
                break;
            }
            else if(start >= end) { // start와 end가 같아지면 M에 꼭맞는 값은 찾지 못한 경우이다. 즉, 꼭맞지는 못해도 적어도 M이상을 가지는 최대한의 높이이다.
                System.out.println("비슷하게 찾았다" + notFound);
                break;
            }
            else if(calcLength(ts, mid) > M) { // 계산한 떡길이가 M보다 큰 경우 mid를 좀더 크게하여 계산해본다.
                start = mid+1;
                notFound = mid;
                mid = (start+end)/2;
            }
            else if(calcLength(ts, mid) < M) { // 계산한 떡길이가 M보다 작은 경우 mid를 좀 더 크게한다.
                end = mid-1;
                notFound = mid;
                mid = (start+end)/2;
            }

        }

    }

    static int calcLength(int[] ts, int len) { // 떡길이 계산 함수
        int sum = 0;
        for(int i=0; i<ts.length; i++) {
            if(ts[i] > len) {
                sum += ts[i]-len;
            }
        }
        return sum;
    }
}
