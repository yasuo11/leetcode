package array;

import java.util.ArrayList;
import java.util.List;

public class Problem_78 {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++)
            f(nums, i, 0, new ArrayList<>());
        return res;
    }
    private void f(int[] nums, int n, int start, List<Integer> cur){
        if(cur.size() >= n){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            f(nums, n, i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
}
