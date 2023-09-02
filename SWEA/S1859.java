import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1859 {

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Long V = 0L;
        ArrayList<Long> list = new ArrayList<>();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            list.clear();

            // case 별 숫자값 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int tc = 0; tc<U; tc++) {
                V = Long.parseLong(st.nextToken());
                list.add(V);
            }

            Long result = 0L;

            for (int i = 0; i<list.size()-1; i++) {
                Long maxValue = list.get(i);
                for (int j = i+1; j<list.size(); j++) {
                    maxValue = Math.max(maxValue, list.get(j));
                }
                result += (maxValue - list.get(i));
            }
            System.out.println("#" + test_case + " " + result);


        }
    }

}
