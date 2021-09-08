import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    public static int bottomUp(int[] arr, int[] d, int n) {
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }
        return d[n - 1];
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 4;
        int[] d = new int[n + 1];
        int[] arr = {1,3,1,5};
        int res = bottomUp(arr,d, n);
        System.out.println(res);

    }
}

