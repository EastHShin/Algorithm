import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int col = str.charAt(0) - 'a' + 1;
        int row = str.charAt(1) - '0';

        int[] x = {-2, -2, -1, 1, 2,2,-1,1};
        int[] y = {-1, 1, 2, 2, -1, 1,-2,-2};
        int res = 0;
        for(int i=0; i<8; i++){
            int nextRow = row + x[i];
            int nextCol = col + y[i];
            if (nextRow > 0 && nextCol > 0 && nextRow <= 8 && nextCol <= 8) {
                res += 1;
            }
        }
        System.out.println(res);

    }
}



