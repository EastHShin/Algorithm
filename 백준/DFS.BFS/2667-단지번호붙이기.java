import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int[][] visited;
    private static int[][] arr;
    private static int count;
    private static int N;
    private static void DFS(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return;
        }
        if(visited[x][y] != 0 || arr[x][y] != 1)
            return;

        count += 1;
        visited[x][y] = 1;

        DFS(x - 1, y);
        DFS(x, y - 1);
        DFS(x + 1, y);
        DFS(x, y + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new int[N][N];
        int totalCnt = 0;
        List<Integer> cnt = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                DFS(i,j);
                if(count != 0) {
                    totalCnt += 1;
                    cnt.add(count);
                }
            }
        }
        System.out.println(totalCnt);
        Collections.sort(cnt);
        for (int i = 0; i < cnt.size(); i++) {
            System.out.println(cnt.get(i));
        }
    }
}

