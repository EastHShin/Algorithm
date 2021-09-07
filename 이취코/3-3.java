import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = -100;
        for (int i = 0; i < N; i++) {
            int[] a = Arrays.copyOf(arr[i], arr[i].length);
            Arrays.sort(a);
            if (max < a[0]) {
                max = a[0];
            }
        }
        System.out.println(max);
    }
}
