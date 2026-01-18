package BinarySearch;


//https://leetcode.cn/problems/valid-perfect-square/
public class q5 {
    public boolean isPerfectSquare(int num) {

        int left=0;
        int right=num;

        while(right>=left){
            int mid=left+(right-left)/2;
            long res=(long)mid*mid;
            if(res>num){
                right=mid-1;
            }else if(res<num){
                left=mid+1;
            }else{
                return true;
            }

        }

        return false;

    }

}

