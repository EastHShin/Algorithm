import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    private static int[] visited;

    private static int[][] arr;
    private static List<Integer> dfsList;
    private static List<Integer> bfsList;
    private static Queue<Integer> q;
    public static void DFS(int v, int len) {
        if(visited[v] != 0)
            return;
        visited[v] = 1;
        dfsList.add(v);
        for (int i = 1; i < len + 1; i++) {
            if (arr[v][i] == 1) {
                DFS(i, len);
            }
        }
    }
    public static void BFS(int x, int len) {
        int v;
        q.offer(x);
        while (!q.isEmpty()) {
            v = q.poll();
            if(visited[v] != 0)
                continue;
            visited[v] = 1;
            bfsList.add(v);
            for (int i = 1; i < len + 1; i++) {
                if(arr[v][i] ==1 && visited[i] == 0)
                    q.offer(i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dfsList = new ArrayList<>();
        bfsList = new ArrayList<>();
        q = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int a,b;
        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st2.nextToken());
            b = Integer.parseInt(st2.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (arr[i][v] == arr[v][i] || arr[i][v] == 1)
                    continue;
                arr[i][v] = 2;
            }
        }
        visited = new int[10000];
        DFS(v, N);
        visited = new int[10000];
        BFS(v, N);
        for (int i = 0; i < dfsList.size(); i++) {
            System.out.print(dfsList.get(i) + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < bfsList.size(); i++) {
            System.out.print(bfsList.get(i) + " ");
        }
    }
}

