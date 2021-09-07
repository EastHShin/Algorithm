import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String moving = br.readLine();
        String[] movingArr = moving.split(" ");
        int X = 1;
        int Y = 1;
        for (int i = 0; i < movingArr.length; i++) {
            if(movingArr[i].equals("L")){
                if(Y > 1)
                    Y -= 1;
            }
            else if(movingArr[i].equals("R")){
                if(Y < N)
                    Y += 1;
            }
            else if(movingArr[i].equals("U")){
                if(X > 1)
                    X -= 1;
            }
            else if(movingArr[i].equals("D")){
                if(X < N)
                    X += 1;
            }
        }
        System.out.println(X + " " + Y);
    }
}
