
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    private static PriorityQueue<Character> pq = new PriorityQueue<>();

    private static void Solution(String input) {
        int len = input.length();
        int numRes = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char s = input.charAt(i);
            if (s >= 'A' && s <= 'Z') {
                pq.add(s);
                continue;
            }
            numRes += (s - '0');
        }
        int pqLen = pq.size();
        for (int i = 0; i < pqLen; i++) {
            stringBuilder.append(pq.poll());
        }
        stringBuilder.append(numRes);
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();
        Solution(input);

    }
}

