package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem_609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> fre = new HashMap<>();
        for(String path : paths){
            int index = 0;
            while (index < path.length()){
                int leftIndex = path.indexOf("(", index);
                int rightIndex = path.indexOf(")", leftIndex+1);
                String cur = path.substring(leftIndex, rightIndex+1);
                fre.put(cur, fre.getOrDefault(cur, 0) + 1);
                index = rightIndex+1;
            }
        }
        int i = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(String key : fre.keySet())
            if(fre.get(key) > 1)
                map.put(key, i++);
        for(int j = 0; j < map.size(); j++)
            res.add(new ArrayList<>());
        for(String path : paths){
            int index = path.indexOf(" ", 0);
            String dir = path.substring(0, index) + "/";
            index++;
            while (index < path.length()){
                int leftIndex = path.indexOf("(", index);
                int rightIndex = path.indexOf(")", leftIndex+1);
                String content = path.substring(leftIndex, rightIndex+1);
                String fileName = path.substring(index, leftIndex);
                int p = map.getOrDefault(content, -1);
                if(p != -1)
                    res.get(p).add(dir + fileName);
                index = rightIndex+2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> res = new Problem_609().findDuplicate(paths);
        for(List<String> cur : res)
        {
            for(String s : cur)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
