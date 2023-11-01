package D3;

import java.util.Scanner;

public class S3131 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int max = 1000000;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < max; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) { // i의 제곱근까지 나누어지는 수가 있는지 구함
                if(i%j == 0) { // 소수가 아닌 경우 isPrime = false;
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) { // i가 소수인 경우
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());

    }
}
