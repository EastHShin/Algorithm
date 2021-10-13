
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    private static int M;
    private static int N;

    private static int[][] turn90(int[][] key){
        int[][] tmp = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = key[M - j - 1][i];
            }
        }
        return tmp;
    }

    private static boolean checkLock(int[][] lock) {
        for (int i = N; i < N+N; i++) {
            for (int j = N; j < N+N; j++) {
                if(lock[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    private static void revertLock(int[][] new_Lock, int[][] lock) {
        for (int i = N; i < N+N; i++) {
            for (int j = N; j < N+N; j++) {
                new_Lock[i][j] = lock[i - N][j - N];
            }
        }
    }

    private static void sumLockAndKey(int[][] new_Lock, int[][] key, int startRow, int startCol) {
        for (int i = startRow; i < M+startRow; i++) {
            for (int j = startCol; j < M+startCol; j++) {
                new_Lock[i][j] += key[i-startRow][j-startCol];
            }
        }
    }

    private static boolean solution(int[][] key, int[][] lock) {
        int new_N = N * 3;
        int[][] new_Lock = new int[new_N][new_N];


        for (int i = 0; i < new_N - M + 1; i++) {
            for (int j = 0; j < new_N - M + 1; j++) {
                for (int k = 0; k < 4; k++) {
                    revertLock(new_Lock, lock);
                    key = turn90(key);
                    sumLockAndKey(new_Lock, key, i, j);
                    if (checkLock(new_Lock))
                        return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        String input = br.readLine();
        M = 3;
        N = 3;

        int[][] key = {{0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}};
        int[][] lock = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        System.out.println(solution(key, lock));

    }
}

