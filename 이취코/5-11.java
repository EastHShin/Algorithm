import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] graph;
    private static int N, M;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] visited;

    private static int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        visited[x][y] = 1;
        int X,Y;
        int nx, ny;
        while (queue.peek() != null) {
            X = queue.poll();
            Y = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = X + dx[i];
                ny = Y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    visited[nx][ny] = 1;
                    graph[nx][ny] = graph[X][Y] + 1;
                    queue.offer(nx);
                    queue.offer(ny);
                }

            }

        }

        return graph[N-1][M-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int res = bfs(0,0);
        System.out.println(res);

    }
}



