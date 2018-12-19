package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String cur : words){
            HashMap<Character, Character> map1 = new HashMap<>();
            HashMap<Character, Character> map2 = new HashMap<>();
            int i;
            for(i = 0; i < pattern.length(); i++){
                char c = cur.charAt(i);
                char p = pattern.charAt(i);
                if(map1.containsKey(p) && c != map1.get(p))
                    break;
                if(map2.containsKey(c) && p != map2.get(c))
                    break;
                map1.put(p, c);
                map2.put(c, p);
            }
            if(i == pattern.length())
                res.add(cur);
        }
        return res;
    }
}
