package StackAndQueue;

import java.util.Stack;

public class CustomQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;


    public CustomQueue(){
        stackIn=new Stack<>();
        stackOut=new Stack<>();
    }

    public int pop(){
        if (stackOut.empty()){
            if(!stackIn.empty()){
            for(int i=0;i<stackIn.size();i++){
                stackOut.push(stackIn.pop());
            }
            }else{
                return -1;
            }
        }
            return stackOut.pop();

    }

    public void push(int element){
        stackIn.push(element);
    }

    public int peak(){
        if (stackOut.empty()){
            if(!stackIn.empty()){
                for(int i=0;i<stackIn.size();i++){
                    stackOut.push(stackIn.pop());
                }
            }else{
                return -1;
            }
        }
        return stackOut.peek();
    }


}
