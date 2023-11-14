package D3;

import java.util.Scanner;

public class S1213 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T = 10;
        int count = 0;
        boolean isSame = true;
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String tNum = sc.nextLine();
            String findStr = sc.nextLine();
            String totalStr = sc.nextLine();
            count = 0;

            if(!totalStr.contains(findStr)) {
                count = 0;
            } else { // 20 - 10 = 10
                for (int i = 0; i <= totalStr.length() - findStr.length(); i++) {
                    isSame = true;
                    for (int j = 0; j < findStr.length(); j++) {
                        if(totalStr.charAt(i+j) != findStr.charAt(j)) {
                            isSame = false;
                            break;
                        }
                    }
                    if(isSame) {
                        count++;
                    }

                }
            }
            sb.append("#").append(test_case).append(" ").append(count).append('\n');
        }

        System.out.println(sb.toString());
    }
}
