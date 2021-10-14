
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    private static int N, K, L;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static Queue<Node> turnNode = new LinkedList<>();

    private static int turn(char turnDirection, int curDirection) {

        if (turnDirection == 'L') {
            if (curDirection == 3)
                return 0;
            else
                return curDirection + 1;

        } else if (turnDirection == 'D') {
            if(curDirection == 0)
                return 3;
            else
                return curDirection - 1;
        }
        return -1;
    }


    private static int solution(int[][] board) {
        int tailX;
        int tailY;
        int headX = 1;
        int headY = 1;
        int count = 0;
        int direction = 3;
        int nx, ny;
        board[1][1] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(headX);
        q.offer(headY);
        Node node = turnNode.poll();
        int turnCount = node.getCount();
        while(true) {

            nx = headX + dx[direction];
            ny = headY + dy[direction];

            if(nx < 1 || nx > N || ny < 1 || ny > N){
                return count + 1;
            }
            if(board[nx][ny] == 1)
                return count + 1;

            q.offer(nx);
            q.offer(ny);

            if(board[nx][ny] != -1) {
                tailX = q.poll();
                tailY = q.poll();
                board[tailX][tailY] = 0;
            }

            board[nx][ny] = 1;
            headX = nx;
            headY = ny;
            count += 1;
            if (count == turnCount) {
                direction = turn(node.getDirection(), direction);
                if(!turnNode.isEmpty()) {
                    node = turnNode.poll();
                    turnCount = node.getCount();
                }
            }


        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = -1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            turnNode.add(new Node(cnt, dir));
        }

        System.out.println(solution(board));

    }

    static class Node {
        private int count;
        private char direction;

        public Node(int count, char direction) {
            this.count = count;
            this.direction = direction;
        }

        public int getCount() {
            return count;
        }

        public char getDirection() {
            return direction;
        }
    }
}

