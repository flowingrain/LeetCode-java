package LeetCode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class L155_MinStack {
   /*  private LinkedList<Integer> stack=null;
    int min=Integer.MAX_VALUE;
    public L155_MinStack() {
        stack=new LinkedList<Integer>();
    }

    public void push(int x) {
        if(x<=min){
            stack.addLast(min);//把之前的min压栈
            min=x;
        }
        stack.addLast(x);
    }

    public void pop() {
        if(min==stack.removeLast())
            min=stack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return min;
    }*/
   //数组实现
      /*实时改变min
   Runtime: 76 ms, faster than 46.13% of Java online submissions for Min Stack.
    */
  /* private Integer[] stack=null;
    private int maxSize=10000;
    private int top=-1;
    int min=Integer.MAX_VALUE;
    public L155_MinStack() {
        stack=new Integer[maxSize];
    }

    public void push(int x) {
        if(top==maxSize-1){//栈满
            maxSize*=2;
            Integer[] temp=stack;
            stack=new Integer[maxSize];
            for(int i=0;i<temp.length;i++){
                stack[i]=temp[i];
            }
        }
        stack[++top]=x;
        if(stack[top]<min)
            min=stack[top];
    }

    public void pop() {
        if(stack[top]==min){
            min=Integer.MAX_VALUE;
            for(int i=0;i<top;i++)
            {
                if(stack[i]<min)
                    min=stack[i];
            }
        }
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return min;
    }*/
   /*注意最小值的保存，否则后边没法求min
   使用java的stack
    */
    private Stack<Integer> stack=null;
    int min=Integer.MAX_VALUE;
    public L155_MinStack() {
        stack=new Stack<Integer>();
    }

    public void push(int x) {//int比Integer快好多啊
        if(x<=min){
            stack.push(min);//把之前的min压栈
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(min==stack.pop())//当前栈顶数字等于最小值，栈顶出栈，最小数字为下方数字，栈顶入栈前的最小数字。不管等不等，pop操作都执行过了
            min=stack.pop();//把最小值出栈，余下正常栈顶
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}