package HashTableSlipWindows;

import java.util.HashMap;

public class q1Hashtable {

    public int[] twoNumSum(int arr[], int target){
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hashMap.containsKey(target-arr[i])){
                return new int[]{i,hashMap.get(target-arr[i])};
            }else{
                hashMap.put(arr[i],i);
            }
        }
        return new int[]{};

    }


}
