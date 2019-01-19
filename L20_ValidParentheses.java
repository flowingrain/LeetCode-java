package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L20_ValidParentheses {
    public boolean isValid(String s) {
        int len=s.length();
        Stack<Character> stack=new Stack<Character>();
        if(len==0)
            return true;
        if(len%2!=0)
            return false;
        Map<Character,Character> map=new HashMap<Character,Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put(')',' ');
        map.put(']',' ');
        map.put('}',' ');
        //stack.push(s.charAt(0));
        for(int i=0;i<len;i++)
        {

            if (stack.empty())//栈为空
                stack.push(s.charAt(i));
            else if(s.charAt(i)!=map.get(stack.peek()))//或输入与栈顶不匹配
                stack.push(s.charAt(i));
            else
                stack.pop();
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        L20_ValidParentheses l20=new L20_ValidParentheses();
        String test="([)]";
        boolean result=l20.isValid(test);
        System.out.println(result);
    }
}