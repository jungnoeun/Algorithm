package BAEKJOON.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TFindingParts {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N]; // 현재 있는 부품들
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] order = new int[M]; // 손님이 요청한 부품들
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list); // 부품들 오름차순으로 나열

        for(int i=0; i<M; i++) { // M만큼 반복
            int start = 0, end = N-1;
            int mid = (start + end)/2;
            while(true) {
                if(list[mid] == order[i]) { // 원하는 값을 찾았을때
                    System.out.println("yes");
                    break;
                }
                else if(start >= end) { // list에 찾는 값이 없을 경우
                    System.out.println("no");
                    break;
                }

                else if(list[mid] > order[i]) { // mid위치의 값이 찾는 값보다 클때
                    end = mid-1;
                    mid = (start + end)/2;
                }
                else if(list[mid] < order[i]){ // mid위치의 값이 찾는 값보다 작을때
                    start = mid+1;
                    mid = (start + end)/2;
                }

            }
        }



    }
}
