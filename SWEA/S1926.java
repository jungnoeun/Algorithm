import java.util.Scanner;

public class S1926 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int count, num, last;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            count = 0;
            num = test_case;

            while(num>0) {
                last = num % 10; // 뒤에서 부터 하나씩 비교
                num = num/10;
                if (last == 3 || last == 6 || last == 9) {
                    count++;
                }
            }
            if(count>0) {
                while(count>0) {
                    System.out.print("-");
                    count--;
                }
            }
            else {
                System.out.print(test_case);
            }
            System.out.print(" ");

        }
    }
}
