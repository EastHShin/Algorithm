import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int N, M;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] visited;
    private static Queue<Integer> q;

    private static int bfs(int[][] arr, int a, int b) {
        q.offer(a);
        q.offer(b);
        int x, y;
        int nx, ny;
        while (!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            if (visited[x][y] != 0)
                continue;

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                    q.offer(nx);
                    q.offer(ny);
                    arr[nx][ny] = arr[x][y] + 1;
                }
            }
        }
        return arr[N-1][M-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        visited = new int[N][M];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String str = st2.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int res = bfs(arr, 0,0);
        System.out.println(res);
    }


}

