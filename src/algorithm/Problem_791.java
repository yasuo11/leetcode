package algorithm;


public class Problem_791 {
    public String customSortString(String S, String T) {
        char[] chars = new char[T.length()];
        boolean[] visited = new boolean[26];
        for(char c : S.toCharArray())
            visited[c - 97] = true;
        int i = 0;
        for (char c : S.toCharArray())
            for(char t : T.toCharArray())
                if(c == t)
                    chars[i++] = c;
        for(char t : T.toCharArray())
            if(!visited[t - 97])
                chars[i++] = t;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        System.out.println(new Problem_791().customSortString("kqep",
                "pekeq"));
        System.out.println((int)'z');
    }
}
