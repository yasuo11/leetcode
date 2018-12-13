package array;

public class Problem_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0 || duration == 0)
            return 0;
        int sum = duration;
        for(int i = 1; i < timeSeries.length; i++){
            int diff = timeSeries[i] - timeSeries[i-1];
            if(diff >= duration){
                sum += duration;
            }else {
                sum += diff;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1, 2};
        System.out.println(new Problem_495().findPoisonedDuration(timeSeries, 4));
    }
}
