
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    private static boolean check(int n, List<Node> list){
        for (Node node : list) {
            if(node.building == 1){
                if(node.y == 0)
                    continue;
                if (list.contains(new Node(node.x, node.y - 1, 1)) ||
                    list.contains(new Node(node.x - 1, node.y, 2)) ||
                    list.contains(new Node(node.x, node.y, 2))) {
                    continue;
                }
                if(node.x < 0 || node.x > n || node.y < 0 || node.y >= n)
                    return false;

                return false;
            }
            if (node.building == 2) {
                if (list.contains(new Node(node.x - 1, node.y, 2)) &&
                        list.contains(new Node(node.x + 1, node.y, 2))) {
                    continue;
                }
                if (list.contains(new Node(node.x, node.y - 1, 1)) ||
                        list.contains(new Node(node.x + 1, node.y - 1, 1))) {
                    continue;
                }
                if(node.x < 0 || node.x >= n || node.y < 1 || node.y > n)
                    return false;

                return false;
            }
        }
        return true;
    }


    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        List<Node> list = new ArrayList<>();
        int x,y,build, task;
        for (int[] ints : build_frame) {
            x = ints[0];
            y = ints[1];
            build = ints[2];
            task = ints[3];
            if (task == 1) {
                list.add(new Node(x,y,build+1));
                if(!check(n, list))
                    list.remove(list.size()-1);
            } else if (task == 0) {
                list.remove(new Node(x,y, build+1));
                if(!check(n, list))
                    list.add(new Node(x,y, build+1));
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x == o2.x && o1.y == o2.y) {
                    return Integer.compare(o1.building, o2.building);
                }
                if (o1.x == o2.x) {
                    return Integer.compare(o1.y, o2.y);
                }
                return Integer.compare(o1.x, o2.x);
            }
        });
        int i = 0;
        answer = new int[list.size()][3];
        for (Node node : list) {
            answer[i][0] = node.x;
            answer[i][1] = node.y;
            answer[i][2] = node.building -1;
            i += 1;
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
    }

    static class Node{
        int x,y,building;

        public Node(int x, int y, int building) {
            this.x = x;
            this.y = y;
            this.building = building;
        }

        @Override
        public boolean equals(Object object) {
            Node node = (Node)object;

            if (node.x == this.x && node.y == this.y && node.building == this.building) {
                return true;
            }
            return false;
        }

    }



}

