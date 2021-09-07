import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    private static int[] InsertionSort(int[] arr) {
        int len = arr.length;
        int tmp;

        for (int i = 1; i < len; i++) {
            int j = i-1;
            while (j >= 0 && arr[j] > arr[j+1]) {
                tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
                j -= 1;
            }
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = {7,5,9,0,3,1,6,2,4,8};
        int[] newArr = InsertionSort(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }

    }
}



