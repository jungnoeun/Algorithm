import java.util.Scanner;

public class S2072 {

    public static void main(String[] args) {

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int total = 0;
            for(int cnt=1; cnt<=10; cnt++)
            {
                int num = sc.nextInt();
                if(num %2 == 1) {
                    total += num;
                }
            }

            System.out.println("#"+ test_case + " " + total);

        }
    }

}
