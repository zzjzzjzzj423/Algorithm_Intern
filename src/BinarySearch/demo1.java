package BinarySearch;

import java.util.Arrays;

public class demo1 {


    public int binarySearch(int[] nums, int target){

        int left=0;
        int right=nums.length-1;


        while(right>=left){

            int mid=left+(right-left)/2;


            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;


    }


    //square

    public int findSquare(int question){


        int left=0;
        int right=question;
        int ans=0;


        while(right>=left){

            int mid=left+(right-left)/2;

            int tempRes=mid*mid;
            if (tempRes>question){
                right=mid-1;
            } else if (tempRes<question) {
                if(mid>ans){
                    ans=mid;
                }
                left=mid+1;
            }else{
                return mid;
            }
        }
        return ans;


    }


    public int findSpinArray(int[] nums, int target){
        int left=0;
        int right=nums.length-1;

        while(right>=left){
            int mid=left+(right-left)/2;

            if (nums[mid]>right){
                if(nums[mid]>target){
                    if(nums[left]<target){
                        right=mid-1;
                    }else if(nums[left]>target){
                        left=mid+1;
                    }else{
                        return left;
                    }

                }else if(nums[mid]<target){
                    left=mid+1;
                }else{
                    return mid;
                }
            }else{
                if(nums[mid]>target){
                    right=mid-1;
                }else if(nums[mid]<target){
                    if(nums[right]>target){
                        left=mid+1;
                    } else if (nums[right]<target) {
                        right=mid-1;
                    }else{
                        return right;
                    }

                }else{
                    return mid;
                }



            }




        }
        return -1;


    }


    public static void main(String[] args) {
        System.out.println(new demo1().findSquare(1));

        int array1[]={1,2,3,4,5,6,7,8};

        System.out.println(new demo1().binarySearch(array1,7));

        int array2[]={4,5,6,7,1,2,3};

        System.out.println(new demo1().findSpinArray(array2,7));

    }


}
