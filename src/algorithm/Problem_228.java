package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        int head = nums[0];
        int pre = head;
        for(int i = 1; i < nums.length; i++){
            if((long)nums[i] - (long)pre > 1){
                if(pre == head)
                    res.add(head + "");
                else
                    res.add(head + "->" + pre);
                head = nums[i];
                pre = nums[i];
            }
            else
                pre = nums[i];
        }
        if(pre == head)
            res.add(head + "");
        else
            res.add(head + "->" + pre);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483647,2147483647};
        System.out.println(Arrays.toString(new Problem_228().summaryRanges(nums).toArray()));
    }
}
