import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    private static void selectionSort(int[] arr) {
        int len = arr.length;
        int min, minIdx;
        int tmp;
        for (int i = 0; i < len - 1; i++) {
            min = 10000;
            minIdx = i;
            for (int j = i; j < len; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        selectionSort(arr);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }

    }


}

