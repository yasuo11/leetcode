package array;

import java.util.ArrayList;
import java.util.List;

public class Problem_216 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        f(k, n, 1, new ArrayList<>());
        return res;
    }
    private void f(int k, int n, int start, List<Integer> cur){
        if(cur.size() == k && n == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(cur.size() > k || n < 0)
            return;
        for(int i = start; i <= 9 && n >= i; i++){
            cur.add(i);
            f(k, n - i, i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
}
