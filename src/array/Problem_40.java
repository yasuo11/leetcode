package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_40 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        f(candidates, target, new ArrayList<>(), 0, -1);
        return res;
    }
    private void f(int[] candidates, int target, List<Integer> cur, int index, int pre){
        if(target <= 0){
            if(target == 0)
                res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index; i < candidates.length && target >= candidates[i]; i++){
            if(i != index && candidates[i] == candidates[i-1])
                continue;
            cur.add(candidates[i]);
            f(candidates, target - candidates[i], cur, i+1, pre);
            pre = candidates[i];
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,2,1,2};
        System.out.println(Arrays.toString(new Problem_40().combinationSum2(nums, 5).toArray()));
    }
}
