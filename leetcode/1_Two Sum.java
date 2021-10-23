import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<len; i++){

                Integer diff = target - nums[i];
                if(map.containsKey(diff)){
                    return new int[] {map.get(diff), i};
                }
                map.put(nums[i], i);
            }

            return null;
        }
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    }


}

