import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end)
            return;
        int pivot = start;
        int left = start + 1;
        int right = end;
        int tmp;
        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) {
                left += 1;
            }
            while (right > start && arr[right] >= arr[pivot]) {
                right -= 1;
            }
            if (left > right) {
                tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;
            } else {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        quickSort(arr, start, right - 1);
        quickSort(arr, right+1, end);
    }


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = {7,5,9,0,3,1,6,2,4,8};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}



