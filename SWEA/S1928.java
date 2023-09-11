import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class S1928 {
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++)
        {
            String encoding = br.readLine();
            String decoding = new String(Base64.getDecoder().decode(encoding));
            System.out.println("#" + t + " " + decoding);
        }
    }

}
