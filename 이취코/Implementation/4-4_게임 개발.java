import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int direction;
    private static int[][] d = new int[50][50];
    private static int dx[] = {-1, 0, 1, 0};
    private static int dy[] = {0, 1, 0, -1};
    private static int arr[][] = new int[50][50];

    private static void turnLeft() {
        direction -= 1;
        if (direction < 0) {
            direction = 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int nx, ny;
        direction = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int res = 1;
        d[x][y] = 1;
        int turnTime = 0;
        while (true) {
            turnLeft();
            nx = x + dx[direction];
            ny = y + dy[direction];
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                res += 1;
                turnTime = 0;
                continue;
            }
            else
                turnTime += 1;

            if (turnTime == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                else break;

                turnTime = 0;
            }
        }

        System.out.println(res);

    }
}



