package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1289 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= N; test_case++) {
            String nums = br.readLine();
            int[] numArr = new int[nums.length()];
            int count = 0;

            for (int i = 0; i < nums.length(); i++) {
                numArr[i] = nums.charAt(i) - '0';
            }

            if(numArr[0] == 1) {
                count++;
            }

            for (int i = 1; i < numArr.length; i++) {
                if(numArr[i] != numArr[i-1]) {
                    count++;
                }
            }

            System.out.println("#" + test_case + " " + count);

        }


        br.close();
    }
}
