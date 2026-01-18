package BinarySearch;



public class q2 {

    public int searchInsert(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;
        int ans=0;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;

            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }

            ans=mid;
        }
        if(nums[ans]>target){
            return ans;
        }else{
            return ans+1;
        }
    }
}
