package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem_916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> list = new ArrayList<>();

        final int maxn = 26;
        int need[] = new int[maxn];
        int tmp[] = new int[maxn];
        for(int i=0;i<B.length;i++)
        {
            for(int j=0;j<B[i].length();j++)
            {
                tmp[B[i].charAt(j)-'a'] ++;
            }
            for(int j=0;j<maxn;j++)
            {
                if(need[j]<tmp[j]) need[j] = tmp[j];
                tmp[j] = 0;
            }
        }
        for(int i=0;i<A.length;i++)
        {
            boolean f = true;
            for(int j=0;j<A[i].length();j++)
            {
                tmp[A[i].charAt(j)-'a']++;
            }
            for(int j=0;j<maxn;j++)
            {
                if(tmp[j]<need[j]) {
                    f = false;
                }
                tmp[j] = 0;
            }
            if(f) list.add(A[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"le","eo"};
        System.out.println(Arrays.toString(new Problem_916().wordSubsets(A, B).toArray()));
    }
}
