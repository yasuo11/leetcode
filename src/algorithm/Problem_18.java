package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_18 {
    private int binarySearch(int[] nums, int l, int r, int key){
        while(l <= r){
            int mid = (r - l)/2 + l;
            if(nums[mid] == key)
                return mid;
            else if(nums[mid] < key)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int m = 0 ; m < nums.length-3 ; m++){
            if(m > 0 && nums[m] == nums[m-1])
                continue;
            for(int i = m+1 ; i < nums.length-2 ; i++){
                if(i > m+1 && nums[i] == nums[i-1])
                    continue;
                for(int j = i+1 ; j < nums.length-1 ; j++){
                    if(j > i+1 && nums[j] == nums[j-1])
                        continue;
                    int index = binarySearch(nums, j+1, nums.length-1, target-nums[m]-nums[i]-nums[j]);
                    if(index != -1){
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[m]); cur.add(nums[i]); cur.add(nums[j]); cur.add(nums[index]);
                        res.add(cur);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(new Problem_18().fourSum(nums, 0));
    }
}
