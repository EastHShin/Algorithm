import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    private static int greedy(int[] arr, int len) {
        int res0 = 0;
        int res1 = 0;
        if (arr[0] == 1) {
            res0 += 1;
        } else {
            res1 += 1;
        }
        for (int i = 0; i < len-1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (arr[i+1] == 1) {
                    res0 += 1;
                } else {
                    res1 += 1;
                }
            }

        }
        return Math.min(res0, res1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        int len = str.length();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        int res = greedy(arr, len);
        System.out.println(res);

    }
}

