package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_792 {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words);
        for(int k = 0; k < words.length; k++){
            if(k >= 1 && words[k].equals(words[k-1])){
                res += map.containsKey(words[k])? 1 : 0;
                continue;
            }
            int i, j = 0;
            while(j < words[k].length() && map.containsKey(words[k].substring(0, j+1)))
                j++;
            i = j >= 1? map.get(words[k].substring(0, j)) : 0;
            while(i < S.length() && j < words[k].length()){
                if(S.charAt(i) == words[k].charAt(j))
                {
                    j++;
                    map.put(words[k].substring(0, j), i+1);
                }
                i++;
            }
            if(j >= words[k].length())
                res++;
        }
        return res;
    }

    public int numMatchingSubseq2(String S, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0, count = 0;
        boolean sub;
        for (String word : words) {
            if (map.containsKey(word)) {
                count += map.get(word);
            } else {
                index = -1;
                sub = true;
                for (int i = 0; i < word.length(); i++) {
                    index = S.indexOf(word.charAt(i), index + 1);
                    if (index < 0) {
                        sub = false;
                        break;
                    }
                }
                if (sub) {
                    count++;
                    map.put(word, 1);
                } else {
                    map.put(word, 0);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"acd", "ace", "acd"};
        System.out.println(new Problem_792().numMatchingSubseq("acacacd", words));
    }
}
