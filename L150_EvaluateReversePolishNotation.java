package LeetCode;

import java.util.HashSet;
import java.util.Stack;

public class L150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        HashSet<String> operates=new HashSet<String>();
        operates.add("+");
        operates.add("-");
        operates.add("*");
        operates.add("/");
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++)
        {
            if(!operates.contains(tokens[i]))//非符号
                stack.push(Integer.valueOf(tokens[i]));
            else
            {
                Integer num2=stack.pop();
                Integer num1=stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num1-num2);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num1/num2);
                        break;
                    /*default:
                        stack.push(Integer.valueOf(tokens[i]));
                        break;*/
                }
            }
        }
        return stack.peek();
    }
    public static void main(String[] args){
        L150_EvaluateReversePolishNotation l150=new L150_EvaluateReversePolishNotation();
        //String[] tokens={"2", "1", "+", "3", "*"};
        String[] tokens={"4", "13", "5", "/", "+"};
        System.out.println(l150.evalRPN(tokens));
    }
}