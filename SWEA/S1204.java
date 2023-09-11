import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class S1204
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int order;
        int input;
        int i;
        int maxKey = 0, maxValue = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            maxKey = 0;
            maxValue = 0;

            map.clear();

            int cnt = st.countTokens();

            for (i=0; i<cnt; i++) {
                input = Integer.parseInt(st.nextToken());
                if (map.containsKey(input)) {
                    map.put(input, map.get(input) + 1);
                }
                else {
                    map.put(input, 1);
                }
            }

            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() == maxValue) {
                    if(entry.getKey() > maxKey) {
                        maxValue = entry.getValue();
                        maxKey = entry.getKey();


                    }
                }
                else if(entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();

                }
            }

            System.out.println("#" + order + " " + maxKey);

        }
    }
}