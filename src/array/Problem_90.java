package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_90 {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++)
            f(nums, i, 0, new ArrayList<>());
        return res;
    }
    private void f(int[] nums, int n, int start, List<Integer> cur){
        if(cur.size() == n){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1])
                continue;
            cur.add(nums[i]);
            f(nums, n, i+1, cur);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2};
        System.out.println(Arrays.toString(new Problem_90().subsetsWithDup(nums).toArray()));
    }
}
