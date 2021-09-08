import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int dp(int[] d, int N) {
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i < N + 1; i++) {
            d[i] = (d[i-1] + d[i-2] * 2) % 796796;
        }
        return d[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int res = dp(d, N);
        System.out.println(res);

    }


}

