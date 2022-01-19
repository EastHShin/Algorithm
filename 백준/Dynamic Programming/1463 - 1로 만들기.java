import java.io.*;
import java.text.ParseException;


public class Main {
    private static int[] dp;

    private static int solution(int N) {
        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                min = Math.min(dp[i/3], min);
            }
            if (i % 2 == 0) {
                min = Math.min(dp[i/2], min);
            }
            min = Math.min(dp[i - 1], min);

            dp[i] = min + 1;
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        int solution = solution(N);
        System.out.println(solution);
    }

}

