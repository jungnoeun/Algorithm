
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class S1986
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int result = 0;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            result = 0;
            for(int i=1; i<=N; i++) {
                if(i%2 == 0) {
                    result -= i;
                } else {
                    result += i;
                }
            }

            System.out.println("#" + test_case + " " + result);

        }
    }
}