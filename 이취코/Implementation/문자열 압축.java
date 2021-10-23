import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    private static int Solution(String s) {
        int len = s.length();
        int answer = len;
        int count;

        for (int i = 1; i < len / 2 + 1; i++) {
            String prev = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            count = 1;
            for (int j = i; j < len; j += i) {
                int nextLen;
                if(j+i > len)
                    nextLen = len;
                else
                    nextLen = j+i;
                String current = s.substring(j, nextLen);
                if(prev.equals(current)){
                    count += 1;
                }
                else{
                    if(count < 2){
                        sb.append(prev);
                    }
                    else{
                        sb.append(count);
                        sb.append(prev);
                    }
                    count = 1;
                    prev = current;
                }
            }
            if(count < 2){
                sb.append(prev);
            }
            else{
                sb.append(count);
                sb.append(prev);
            }

            answer = Math.min(answer,sb.length());
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = br.readLine();
        System.out.println(Solution(s));
    }
}

