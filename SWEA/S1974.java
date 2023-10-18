import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1974 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[][] sdq = new int[10][10];
        int[] check = new int[10];
        boolean isFinish = false;
        int input;

        for(int k=0; k<t; k++) {

            isFinish = false;

            // 입력 받기
            for (int i = 1; i <= 9; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(check, 0);
                for (int j = 1; j <= 9; j++) { // 한 행당 입력 겹치는 수가 있는지
                    input = Integer.parseInt(st.nextToken());
                    check[input]++; // 한 행당 각 숫자가 몇번씩 나왔는지 +1
                    sdq[i][j] = input;
                    if(check[input] > 1) { // 겹치는 수가 있으면
                        isFinish = true;
                        break;
                    }
                }

                if(isFinish == true) break;
            }


            if(isFinish == true) {
                System.out.println("#" + (k+1) + " " + 0);
                isFinish = false;
                continue;
            }

            // 한 줄당 겹치는 수가 없을 경우
            // 3*3씩 검증
            Arrays.fill(check, 0);
            for(int i=1; i<=7; i+=3) {
                for(int j=1; j<=7; j+=3) {
                    for(int m=0; m<3; m++) {
                        for(int n=0; n<3; n++) {
                            input = sdq[i+m][j+n];
                            check[input]++;
                            if(check[input] > 1) { // 겹치는 수가 있으면
                                isFinish = true;
                                break;
                            }
                        }
                        if(isFinish == true) break;
                    }
                    if(isFinish == true) break;
                }
                if(isFinish == true) break;

            }

            if(isFinish == true) {
                System.out.println("#" + (k+1) + " " + 0);
                isFinish = false;
                continue;
            } else {
                System.out.println("#" + (k+1) + " " + 1);
                isFinish = false;
            }

        }

    }
}
