import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int N;
    private static List<Integer> list;
    private static int greedy(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < N; i++) {
            list.add(arr[i]);
            int max = Collections.max(list);
            if(max <= list.size()){
                list.clear();
                count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int res = greedy(arr);
        System.out.println(res);

    }
}
