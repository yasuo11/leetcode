package array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


public class Problem_870 {
    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a : A)
            map.put(a, map.getOrDefault(a, 0) + 1);
        for(int i = 0; i < B.length; i++){
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(B[i]+1);
            if(entry == null)
                res[i] = -1;
            else {
                res[i] = entry.getKey();
                if(entry.getValue() == 1)
                    map.remove(entry.getKey());
                else
                    map.put(entry.getKey(), entry.getValue()-1);
            }
        }
        int j = 0;
        for(int key : map.keySet()){
            int val = map.get(key);
            while(j < res.length && val > 0)
            {
                if(res[j] == -1){
                    res[j] = key;
                    val--;
                }
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {12,24,8,32};
        int[] B = {13,25,32,11};
        System.out.println(Arrays.toString(new Problem_870().advantageCount(A, B)));
    }
}
