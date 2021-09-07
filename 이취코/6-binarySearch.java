import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    private static boolean binarySearch(int[] arr, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] == target)
                return true;

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = 5;
        int[] arr = {8, 3, 7, 9, 2};
        int M = 3;
        int[] lst = {5, 7, 9};
        int start = 0;
        int end = arr.length - 1;

        Arrays.sort(arr);
        for (int i = 0; i < lst.length; i++) {
            if (binarySearch(arr, start, end, lst[i])) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }

    }
}

