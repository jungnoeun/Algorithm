package BAEKJOON.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 비슷한 코드를 찾았다. 이해에는 이분의 코드가 더 적절할듯 하다.
 * 링크: https://www.acmicpc.net/source/67015799
 */

public class B12891 {

    static int[] time = new int[4]; // 있어야 하는 dna 개수
    static int[] count = new int[4]; // 입력된 dna 개수
    static int check = 0; // 4개의 숫자 조건을 몇개나 만족했는지 개수

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] dna = new char[]{'A', 'C', 'G', 'T'};


        int S = Integer.parseInt(st.nextToken()); // 전체 문자열 개수 10 0~9
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 개수 4 6789
        int result = 0;


        String str = br.readLine();

        st = new StringTokenizer(br.readLine()); // dna 횟수 입력
        for(int i=0; i<4; i++) {
            time[i] = Integer.parseInt(st.nextToken());
            if(time[i] == 0) check++;
        }

        // 첫번쨰 슬라이딩 윈도우 세팅
        // 처음 ~ P번까지 ACGT 중 몇개의 문자가 time을 만족하는지 확인함.
        for (int i=0; i<P; i++) {
            Add(str.charAt(i));
        }
        if(check == 4) result++;

        // 두번째부터 슬라이딩 윈도우 시작
        for(int i=P; i<S; i++) {
            int j = i-P; // j: (왼쪽)앞에 빠지는 문자, i: (오른쪽) 뒤에 추가되는 문자
            Add(str.charAt(i));
            Remove(str.charAt(j));
            if(check == 4) result++;
        }

        System.out.println(result);

    }

    private static void Remove(char c) {
        switch (c){
            case 'A':
                if(count[0] == time[0]) check--; // 기존에 있던 문자열이 똑같았으면 check-1 을 해줌
                count[0]--;
                break;
            case 'C':
                if(count[1] == time[1]) check--; // 기존에 있던 문자열이 똑같았으면 check-1 을 해줌
                count[1]--;
                break;
            case 'G':
                if(count[2] == time[2]) check--; // 기존에 있던 문자열이 똑같았으면 check-1 을 해줌
                count[2]--;
                break;
            case 'T':
                if(count[3] == time[3]) check--; // 기존에 있던 문자열이 똑같았으면 check-1 을 해줌
                count[3]--;
                break;

        }
    }
    private static void Add(char c) {
        switch (c){
            case 'A':
                count[0]++;
                if(count[0] == time[0]) check++;
                break;
            case 'C':
                count[1]++;
                if(count[1] == time[1]) check++;
                break;
            case 'G':
                count[2]++;
                if(count[2] == time[2]) check++;
                break;
            case 'T':
                count[3]++;
                if(count[3] == time[3]) check++;
                break;

        }
    }
}
