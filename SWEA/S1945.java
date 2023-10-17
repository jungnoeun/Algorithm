import java.util.Arrays;
import java.util.Scanner;
        import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class S1945
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] cntArr = new int[5];
        // N=2a x 3b x 5c x 7d x 11e
        /*
        N을 11,7,5,3,2 순서로 나누고
        나머지가 0이면 알파벳+1을 한다.
        */


        for(int test_case = 1; test_case <=T; test_case++) {
            int N = sc.nextInt();
            Arrays.fill(cntArr, 0);
            while(N>1)
            {
                if(N%11 == 0) {
                    N/=11;
                    cntArr[4]++;
                } if(N%7 == 0) {
                N/=7;
                cntArr[3]++;
            }
                if(N%5 == 0) {
                    N/=5;
                    cntArr[2]++;
                }
                if(N%3 == 0) {
                    N/=3;
                    cntArr[1]++;
                }
                if(N%2 == 0) {
                    N/=2;
                    cntArr[0]++;
                }

            }

            System.out.print("#" + test_case );
            for(int i=0; i<5; i++) {
                System.out.print(" " + cntArr[i]);
            }
            System.out.println();
        }


    }
}