package BinarySearch;

//https://leetcode.cn/problems/sqrtx/submissions/692212091/
public class q4 {


    //注意这里不止mid有溢出问题， 乘法也有！！！
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        int ans=0;
        while(right>=left){
            int mid=left+(right-left)/2;
            long res=(long)mid*(long)mid;
            if (res>x){
                right=mid-1;
            }else if(res<x){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return left-1;
    }
}
