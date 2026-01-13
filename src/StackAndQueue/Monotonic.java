package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class Monotonic {

    int[] findNextBiggerElement(int[] arr){
        Stack<Integer> indexStack=new Stack<>();
        int[] ans=new int[arr.length];

        for(int i=0; i<arr.length;i++){
            ans[i]=-1;
            if(indexStack.isEmpty()){
                indexStack.push(i);
            }else{
                while (!indexStack.isEmpty()&&arr[i]>arr[indexStack.peek()]){
                    ans[indexStack.peek()]=arr[i];
                    indexStack.pop();
                }
                indexStack.push(i);
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        int[] arr={9,8,7,6,8,5,2,1};
        System.out.println(Arrays.toString(new Monotonic().findNextBiggerElement(arr)));
    }

}
