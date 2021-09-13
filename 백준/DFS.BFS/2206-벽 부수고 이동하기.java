import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    private int x;
    private int y;
    private int crash;

    public Node(int x, int y, int crash) {
        this.x = x;
        this.y = y;
        this.crash = crash;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCrash() {
        return crash;
    }
}
public class Main {

    private static boolean[][][] visited;
    private static int[][] dist;
    private static int N, M;
    private static Queue<Node> q;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static int bfs(int[][] arr, int a, int b) {
        q.offer(new Node(a, b, 0));
        int nx, ny;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            int crash = node.getCrash();
            if (x == N - 1 && y == M - 1) {
                return dist[x][y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    if (!visited[1][nx][ny] && crash == 0) {
                        q.offer(new Node(nx, ny, 1));
                        visited[crash][nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                } else {
                    if (!visited[crash][nx][ny]) {
                        visited[crash][nx][ny] = true;
                        q.offer(new Node(nx, ny, crash));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }


            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        visited = new boolean[2][N][M];

        dist = new int[N][M];
        q = new LinkedList<>();



        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String str = st2.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int a = 0;
        int b = 0;
        res = bfs(arr, a, b);
        System.out.println(res);

    }
}
