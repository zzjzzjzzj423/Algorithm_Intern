package RecursionAndSort;

import java.util.HashMap;

public class RecursionDemo {
    public int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }

        return n*factorial(n-1);

    }


    public int fibonacci(int n){

        if(n==0 || n==1){
            return n;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }


    public int memoryFibonacci(int n) {

        HashMap<Integer, Integer> memory = new HashMap<>();


        return Fibonacci(memory,n);
    }

    public int Fibonacci(HashMap<Integer, Integer> hashMap, int n){
        if(n==0 || n==1){
            return n;
        }

        if(hashMap.containsKey(n)){
            return hashMap.get(n);
        }
        int result=Fibonacci(hashMap,n-2)+Fibonacci(hashMap,n-1);
        hashMap.put(n,result);
        return  result;


    }



}
