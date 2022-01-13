
import java.io.*;
import java.text.ParseException;
import java.util.StringTokenizer;


public class Main {

    private static int N,M;
    private static int count;
    private static int[][] dp = new int[30][30];

    private static int recur(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            dp[n][r] = 1;
            return dp[n][r];
        }

        dp[n][r] = recur(n - 1, r - 1) + recur(n - 1, r);
        return dp[n][r];
    }

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = recur(M, N);
            System.out.println(count);
        }
    }

}

