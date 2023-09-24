package BAEKJOON.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12891 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] dna = new char[]{'A', 'C', 'G', 'T'};
        int[] time = new int[4]; // 있어야 하는 dna 개수
        int[] count = new int[4]; // 입력된 dna 개수
        int S = Integer.parseInt(st.nextToken()); // 전체 문자열 개수 10 0~9
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 개수 4 6789
        int result = 0;
        boolean nextFor = false;

        String str = br.readLine();
//        System.out.println("str = " + str);

        st = new StringTokenizer(br.readLine()); // dna 횟수 입력
        for(int i=0; i<4; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<=S-P; i++) {
            Arrays.fill(count, 0);
            nextFor = false;

            for(int j=i; j<P+i; j++) {
//                System.out.print(str.charAt(j) + " ");

                for(int k=0; k<4; k++) { // dna의 값들 하나하나씩 비교
                    if(dna[k] == 0 && dna[k] == str.charAt(j)) {
                        nextFor = true;
                        break;
                    }
                    else if(dna[k] == str.charAt(j)) {
                        count[k]++;
                    }
                }
                if(nextFor == true) break;

            }

            if(nextFor == false) {
                for(int l=0; l<4; l++) {
                    if(time[l] != count[l]){
                        nextFor = true;
                        break;
                    }
                }
            }
            if(nextFor == false)
                result++;

//            System.out.println();

        }

        System.out.println(result);

    }
}
