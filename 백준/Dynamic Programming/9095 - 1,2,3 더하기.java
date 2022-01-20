import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;


public class Main {
    private static int[] dp;

    private static void solution(int N){
        for (int i = 4; i <= N; i++) {
            if (dp[i] > 0) {
                continue;
            }
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        System.out.println(dp[N]);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[12];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i = 0; i < T; i++) {
            solution(Integer.parseInt(br.readLine()));
        }

    }

}

