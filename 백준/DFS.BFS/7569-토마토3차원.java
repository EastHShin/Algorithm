import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static int[][][] visited;
    private static int[] dx = {-1, 0, 1, 0, 0, 0};
    private static int[] dy = {0, -1, 0, 1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};
    private static int N,M,H;
    private static Queue<Integer> q;

    private static int bfs(int[][][] arr) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        q.offer(i);
                        q.offer(j);
                        q.offer(k);
                    }
                }
            }
        }
        int x,y,z;
        int nx, ny, nz;
        while (!q.isEmpty()) {
            z = q.poll();
            x = q.poll();
            y = q.poll();
            if (visited[z][x][y] != 0) {
                continue;
            }

            visited[z][x][y] = 1;

            for (int i = 0; i < 6; i++) {
                nz = z + dz[i];
                nx = x + dx[i];
                ny = y + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) {
                    continue;
                }

                if (arr[nz][nx][ny] == 0 && visited[nz][nx][ny] == 0) {
                    q.offer(nz);
                    q.offer(nx);
                    q.offer(ny);
                    arr[nz][nx][ny] = arr[z][x][y] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[i][j][k] == 0)
                        return -1;

                    max = Math.max(arr[i][j][k], max);
                }
            }
        }
        return max-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[H][N][M];
        visited = new int[H][N][M];
        q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st2.nextToken());
                }
            }
        }
        int res = bfs(arr);

        System.out.println(res);

    }


}

