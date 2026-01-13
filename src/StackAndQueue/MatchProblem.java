package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchProblem {

    public boolean isValid(String str){
        Map<Character, Character> rules=new HashMap<>();
        Stack<Character> stack=new Stack<>();
        rules.put('(',')');
        rules.put('[',']');
        rules.put('{','}');

        for (char item:str.toCharArray()){
            if (rules.containsKey(item)){
                stack.push(item);
            }else if(!stack.isEmpty() && item==rules.get(stack.peek())){
                stack.pop();
            }else{
                return false;
            }
        }

        return stack.isEmpty();
    }

    //priorityOrder="([{" means 优先级(>[>{
    public boolean isValidOrder(String str, String priorityOrder){
        Map<Character, Character> rules=new HashMap<>();
        Stack<Character> stack=new Stack<>();
        rules.put('(',')');
        rules.put('[',']');
        rules.put('{','}');

        for (char item:str.toCharArray()){
            if (rules.containsKey(item)){
                if(!stack.isEmpty()&&(priorityOrder.indexOf(item)<priorityOrder.indexOf(stack.peek()))){
                    return false;
                }
                stack.push(item);
            }else if(!stack.isEmpty() && item==rules.get(stack.peek())){
                stack.pop();
            }else{
                return false;
            }
        }

        return stack.isEmpty();
    }


}
