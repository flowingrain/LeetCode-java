package LeetCode;

import java.util.Stack;

public class L232_ImplementQueueUsingStacks {
    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public L232_ImplementQueueUsingStacks() {
        this.stack1=new Stack<Integer>();
        this.stack2=new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int temp=stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return temp;
    }

    /** Get the front element. */
    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int temp =stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return temp;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args){
        L232_ImplementQueueUsingStacks l232=new L232_ImplementQueueUsingStacks();
        l232.push(1);
        l232.push(2);
        System.out.println(l232.peek());
        System.out.println(l232.pop());
        System.out.println(l232.empty());
    }
}