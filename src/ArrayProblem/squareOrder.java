package ArrayProblem;


//https://leetcode.cn/problems/squares-of-a-sorted-array/
public class squareOrder {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int ans[] = new int[nums.length];
        int index = right;
        while(left<=right){
            if(nums[left]*nums[left] < nums[right]*nums[right]){
                ans[index] = nums[right]*nums[right];
                right--;
            }else{
                ans[index] = nums[left]*nums[left];
                left++;
            }
            index--;
        }
        return ans;

    }
}
