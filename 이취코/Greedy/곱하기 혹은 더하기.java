import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static String S;
    private static int len;
    private static List<Integer> list;
    private static int greedy(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res + arr[i], res * arr[i]);
        }

        return res;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        len = S.length();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = S.charAt(i) - '0';
        }
        int res = greedy(arr);
        System.out.println(res);
    }
}
