import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int[][] arr;
    private static int[] visited;
    private static int len;
    private static Queue<Integer> q;
    private static List<Integer> bfsList;

    private static void BFS(int x) {
        q.offer(x);
        int v;
        while (!q.isEmpty()) {
            v = q.poll();
            if(visited[v] != 0)
                continue;
            visited[v] = 1;
            bfsList.add(v);

            for (int i = 1; i < len; i++) {
                if(arr[v][i] == 1 && visited[i] == 0)
                    q.offer(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int a, b;
        arr = new int[N + 1][N + 1];
        len = N + 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (arr[i][j] == 1 || arr[i][j] == arr[j][i])
                    continue;
                arr[i][j] = 2;
            }
        }
        visited = new int[len];
        q = new LinkedList<>();
        bfsList = new ArrayList<>();
        BFS(1);

        System.out.println(bfsList.size() - 1);
    }
}

