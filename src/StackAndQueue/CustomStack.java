package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class CustomStack {

    Queue<Integer> queue;
    int size;

    public CustomStack(){
        queue=new ArrayDeque<>();
        size=0;
    }


    public int pop(){
        if (queue.isEmpty()){
            return -1;
        }
        size--;
        return queue.poll();
    }

    public void push(int element){
        size++;
        queue.add(element);
        for (int i = 0; i < size - 1; i++){
            queue.add(queue.poll());
        }
    }

    public int peak(){
        if (queue.isEmpty()){
            return -1;
        }
        return queue.peek();

    }


}
