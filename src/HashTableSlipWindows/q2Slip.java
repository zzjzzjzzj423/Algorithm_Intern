package HashTableSlipWindows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class q2Slip {

        //找到最长无重复数组
    public int[] longestSubarray(int[] arr){
        int left=0;
        int right=0;
        HashSet<Integer> set=new HashSet<>();
        int max_length=0;
        int maxl=0;
        int maxr=-1;

        while (right<arr.length){
            while(set.contains(arr[right])){
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            if(right-left+1>max_length){
                max_length=right-left+1;
                maxl=left;
                maxr=right;
            }
            right++;
        }

        if(max_length==0){
            return new int[]{};
        }else{
            return Arrays.copyOfRange(arr,maxl,maxr+1);
        }
    }



    public int minSwaps(int[] data) {
        int windowSize=0;
        for(int i=0;i<data.length;i++){
            windowSize+=data[i];
        }
        if(windowSize==0){
            return 0;
        }
        int left=0;
        int right=windowSize-1;
        int min_length=100001;
        int primaryOnes=0;
        for(int i=left;i<right;i++){
            primaryOnes+=data[i];
        }
        while(right<data.length){
            primaryOnes+=data[right];
            int freq=windowSize-primaryOnes;
            if(freq<min_length){
                min_length=freq;
            }
            primaryOnes-=data[left];
            left++;
            right++;
        }
        if(min_length==100001){
            return 0;
        }else{
            return min_length;
        }

    }


    public String minWindow(String s, String t) {
        int[] cntS=new int[128];
        int[] cntT=new int[128];
        char[] arrs=s.toCharArray();
        char[] arrt=t.toCharArray();
        if(arrt.length>arrs.length){
            return "";
        }

        for(char i : arrt){
            cntT[i]++;
        }
        int right=0;
        int left=0;
        int ansL=0;
        int ansR=-1;
        int min_length=100001;
        while(right<arrs.length){
            cntS[arrs[right]]++;

            while(isCovered(cntS,cntT)){

                if((right-left+1)<min_length){
                    min_length = right-left+1;
                    ansL = left;
                    ansR = right;
                }
                cntS[arrs[left]]--;
                left++;
            }

            right++;
        }
        if(ansR == -1){
            return "";
        }else{
            return s.substring(ansL, ansR+1);

        }

    }

    private boolean isCovered(int[] cntS, int[] cntT){
        for(int i='A';i<='Z';i++){
            if(cntS[i]<cntT[i]){
                return false;
            }
        }

        for(int i='a';i<='z';i++){
            if(cntS[i]<cntT[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,1};
        System.out.println(Arrays.toString(new q2Slip().longestSubarray(arr)));

    }




}




