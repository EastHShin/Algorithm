import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] visited;
    private static int[][] arr;
    private static Queue<Integer> q;
    private static int M,N;

    private static int bfs() {

        int zeroCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    q.offer(i);
                    q.offer(j);
                }
                else
                    zeroCnt += 1;
            }
        }
        if(zeroCnt == 0)
            return 0;

        int x,y;
        int nx,ny;
        while (!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            if (visited[x][y] != 0) {
                continue;
            }
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                nx = x+ dx[i];
                ny = y+ dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (arr[nx][ny] == 0 && visited[nx][ny] == 0) {
                    q.offer(nx);
                    q.offer(ny);
                    arr[nx][ny] = arr[x][y] + 1;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
                max = Math.max(arr[i][j], max);
            }
        }
        return max - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = new LinkedList<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int a = 0;
        int b = 0;
        visited = new int[N][M];
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int res = bfs();
        System.out.println(res);


    }


}

