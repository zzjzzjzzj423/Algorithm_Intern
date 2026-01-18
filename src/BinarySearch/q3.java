package BinarySearch;


//https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class q3 {
    public int findBound(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left-1;
    }

    public int[] searchRange(int[] nums, int target) {
        int tail=findBound(nums,target+1);
        int head=findBound(nums,target)+1;
        if(head>tail){
            int ans[]={-1,-1};
            return ans;
        }else if(nums.length==0){
            int ans[]={-1,-1};
            return ans;
        }else if(nums[tail]!=target){
            int ans[]={-1,-1};
            return ans;
        }
        int[] ans={head, tail};
        return ans;


    }

}
