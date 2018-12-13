package algorithm;

import java.util.List;

public class Problem_120 {
    public int minimumTotal(List<List<Integer>> triangle)
    {
        int length=triangle.size();
        if(length==0)return 0;
        if(length==1)return triangle.get(0).get(0);

        List<Integer> sum=triangle.get(length-1);
        for(int i=length-2;i>=0;i--)
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                int sum1=triangle.get(i).get(j)+sum.get(j);
                int sum2=triangle.get(i).get(j)+sum.get(j+1);
                sum.set(j,Math.min(sum1,sum2));
            }
        }
        return sum.get(0);

    }

}
