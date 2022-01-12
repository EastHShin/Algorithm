
import java.io.*;
import java.text.ParseException;


public class Main {
    /*
    DP 풀이
     */
    private static long[] arr;

    private static long fibo(int n) {
        if (n <= 1) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        long a = fibo(n - 1);
        long b = fibo(n - 2);
        arr[n] = a + b;
        return a + b;
    }

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        long result = fibo(n);
        System.out.println(result);
    }

}

