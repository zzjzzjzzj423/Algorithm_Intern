package ArrayProblem;
//https://leetcode.cn/problems/minimum-size-subarray-sum/
public class minSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minlength = 100001;
        while(right < nums.length){
            sum += nums[right];
            while(sum >= target){
                if(right-left+1 < minlength){
                    minlength = right-left+1;
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }

        if(minlength == 100001){
            return 0;
        } else{
            return minlength;
        }

    }
}
