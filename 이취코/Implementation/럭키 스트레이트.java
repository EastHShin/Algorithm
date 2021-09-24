import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    private static int numAdd(int num, int len){
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
    private static String solution(String num) {
        int len = num.length() / 2;
        int num1 = Integer.parseInt(num.substring(0, len));
        int num2 = Integer.parseInt(num.substring(len));
        if (numAdd(num1, len) == numAdd(num2, len)) {
            return "LUCKY";
        } else {
            return "READY";
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = br.readLine();
        System.out.println(solution(N));
    }
}

