import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int[][] arr;
    private static int[][] visited;
    private static int count;
    private static int N,M,K;
    private static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return false;
        }
        if(arr[x][y] != 1 || visited[x][y] != 0)
            return false;
        visited[x][y] = 1;

        dfs(x - 1, y); //up
        dfs(x, y - 1); //left
        dfs(x + 1, y); //down
        dfs(x, y + 1); //right

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int a,b;


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visited = new int[N][M];
            count = 0;
            for (int j = 0; j < K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st2.nextToken());
                b = Integer.parseInt(st2.nextToken());
                arr[b][a] = 1;
            }
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if(dfs(row,col))
                        count += 1;
                }
            }
            System.out.println(count);

        }

    }
}

