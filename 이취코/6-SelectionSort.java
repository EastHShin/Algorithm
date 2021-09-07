import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    private static int[] selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex = 0;
        int tmp;
        for (int i = 0; i < len-1; i++) {
            minIndex = i;
            for (int j = i+1; j < len; j++) {     //minIndex 찾기
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = {3,1,5,6,4,2,5};
        int[] newArr = selectionSort(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }

    }
}



