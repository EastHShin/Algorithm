import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int[] visited;
    private static int N, K;
    private static Queue<Integer> q;
    private static int[] dx = {-1,1,2};

    private static int bfs(int[] arr) {
        if(K < N)
            return N-K;
        q.offer(N);
        int x;
        int nx;


        while (!q.isEmpty()) {
            x = q.poll();
            if (visited[x] != 0) {
                continue;
            }
            visited[x] = 1;

            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    nx = x * dx[i];
                } else {
                    nx = x + dx[i];
                }

                if(nx<0 || nx > 100000)
                    continue;



                if (arr[nx] == 0 && visited[nx] == 0) {
                        q.offer(nx);
                        arr[nx] = arr[x] + 1;
                    }

            }

        }
        return arr[K];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();

        int[] arr = new int[100001];
        visited = new int[100001];

        int res = bfs(arr);
        System.out.println(res);

    }


}

