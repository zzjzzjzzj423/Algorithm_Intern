package RecursionAndSort;

import java.util.Arrays;

public class Sort {


    public void quickSort(int[] arr) {
        if(arr==null||arr.length==0){
            return;
        }
        quickSort(arr, 0,  arr.length-1);

    }

    public void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int pivot=findPivot(arr,left,right);
        quickSort(arr,left,pivot);
        quickSort(arr,pivot+1,right);

    }



    public int findPivot(int[] arr,int left,int right){
        int pivot=arr[left];
        int leftIndex=left+1;
        int rightIndex=right;

        while(rightIndex>=leftIndex){
            if(pivot>arr[leftIndex]){
                leftIndex++;
            }else{
                swap(arr,leftIndex,rightIndex);
                rightIndex--;
            }
        }
        swap(arr,left,rightIndex);
        return rightIndex;
    }

    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }



    public void mergeSort(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }
        mergeSort(arr,0,arr.length-1);

    }


    public void mergeSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }

        int mid=left+(right-left)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }


    public void merge(int[] arr,int left,int mid,int right){
        int arr1[]=new int[mid-left+1];
        int index1=0;
        int arr2[]=new int[right-mid];
        int index2=0;
        for(int i=left;i<=mid;i++){
            arr1[index1]=arr[i];
            index1++;
        }
        index1=0;
        for(int i=mid+1;i<=right;i++){
            arr2[index2]=arr[i];
            index2++;
        }
        index2=0;
        int k=left;
        while (index1<arr1.length&&index2<arr2.length){
            if(arr1[index1]<=arr2[index2]){
                arr[k]=arr1[index1];
                index1++;
            }else{
                arr[k]=arr2[index2];
                index2++;
            }
            k++;
        }

        while(index1<arr1.length){
            arr[k]=arr1[index1];
            index1++;
            k++;
        }

        while(index2<arr2.length){
            arr[k]=arr2[index2];
            index2++;
            k++;
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr=new int[]{6,5,2,3,4,2,9};
        sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }



}
