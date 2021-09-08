import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int[] d;
    private static int N,M;
    private static int dp(int[] arr) {

        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j < M + 1; j++) {
                d[j] = Math.min(d[j], d[j-arr[i]] + 1);
            }
        }
        if(d[M] == 10001)
            return -1;
        return d[M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        d = new int[M + 1];
        Arrays.fill(d, 10001);
        d[0] = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int res = dp(arr);
        System.out.println(res);

    }


}

