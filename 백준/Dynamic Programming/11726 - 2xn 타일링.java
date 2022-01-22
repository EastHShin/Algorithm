import java.io.*;
import java.math.BigInteger;

public class Main {
    private static BigInteger[] dp;

    private static BigInteger solution(int n){
        if (n < 2) {
            return BigInteger.valueOf(n);
        }
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(2);
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new BigInteger[n+1];
        BigInteger solution = solution(n).mod(BigInteger.valueOf(10007));
        System.out.println(solution);
    }

}

