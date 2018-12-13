package array;

public class Problem_33 {
    public int search(int[] a, int target) {
        int n = a.length;
        int lo = 0;
        int hi = n - 1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(a[mid]== target)
                return mid;

            if(a[lo]<=a[mid]){//左半边有序
                if(a[lo]<=target && target<=a[mid])//目标值在左半边
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else{//右半边有序
                if(a[mid]<=target && target<=a[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;

    }
}
