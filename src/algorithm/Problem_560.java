package algorithm;

import java.util.HashMap;

public class Problem_560 {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            sums[i] = i == 0? nums[0] : sums[i-1] + nums[i];
            res += map.getOrDefault(sums[i] - k, 0);
            if(map.containsKey(sums[i]))
                map.put(sums[i], map.get(sums[i]) + 1);
            else
                map.put(sums[i], 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,5};
        System.out.println(new Problem_560().subarraySum(nums, 2));
    }
}
