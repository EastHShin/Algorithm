
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    private static List<Node> houseList = new ArrayList<>();
    private static List<Node> chickenList = new ArrayList<>();
    private static boolean[] visited;
    private static int[] output;
    private static int result;
    private static int N,M;

    private static void chickenDistance(int start, int depth, int[][] city) {
        int chickenListLen = chickenList.size();
        int houseListLen = houseList.size();
        output[depth] = start;

        if (depth == M - 1) {
            int sum = 0;
            for (int i = 0; i < houseListLen; i++) {
                int dist = 1000;
                Node house = houseList.get(i);
                for (int j = 0; j < M; j++) {
                    int calcDist = calcDistance(house, chickenList.get(output[j]));
                    dist = Math.min(calcDist, dist);
                }
                sum += dist;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chickenListLen; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            chickenDistance(i, depth+1, city);
            visited[i] = false;
        }



    }

    private static int calcDistance(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private static void solution(int[][] city) {
        int n = chickenList.size();
        visited = new boolean[n];
        output = new int[M];
        result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            chickenDistance(i, 0, city);
            visited[i] = false;
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] city = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int building = Integer.parseInt(st2.nextToken());
                city[i][j] = building;

                if (building == 1) {
                    houseList.add(new Node(i, j));
                } else if (building == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }
        solution(city);
        System.out.println(result);


    }

    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }



}

