package algorithm;

public class Problem_670 {
    public int maximumSwap(int num) {
        if(num <= 10)
            return num;
        StringBuilder stringBuilder = new StringBuilder();
        while(num > 0){
            stringBuilder.append(num % 10);
            num /= 10;
        }
        String s = stringBuilder.reverse().toString();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length-1; i++){
            int maxIndex = i;
            for(int j = i+1; j < chars.length; j++)
                if(chars[maxIndex] <= chars[j])
                    maxIndex = j;
            if(maxIndex > i && chars[maxIndex] > chars[i]){
                swap(chars, i, maxIndex);
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    private void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_670().maximumSwap(
                98368));
    }
}
