package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem_39 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        f(candidates, target, new ArrayList<>(), 0);
        return new ArrayList<>();
    }
    private void f(int[] candidates, int target, List<Integer> cur, int index){
        if(target <= 0){
            if(target == 0)
                res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index; i < candidates.length && target >= candidates[i]; i++){
            cur.add(candidates[i]);
            f(candidates, target - candidates[i], cur, i);
            cur.remove(cur.size()-1);
        }
    }
}
