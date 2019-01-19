package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class L225_ImplementStackUsingQueues {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    /** Initialize your data structure here. */
    Queue<Integer> queue;

    public L225_ImplementStackUsingQueues() {
        this.queue=new LinkedList<Integer>();
        //this.queue=new PriorityQueue<Integer>();//优先级队列为什么不行？加入到此queue中的元素天然有序，通过java.util.Comparable实现。改变了队列的原有顺序
    }

    /** Push element x onto stack. */
    public void push(int x) {//转换队列中元素的顺序，后进的放在最前
        queue.add( x);
        for(int i=0;i<queue.size()-1;i++)//<queue.size()的话，相当于重新进出一遍，不能实现倒置
            queue.add(queue.poll());
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args){
        L225_ImplementStackUsingQueues l225=new L225_ImplementStackUsingQueues();
        l225.push(1);
        l225.push(2);
        System.out.println(l225.top());
        System.out.println(l225.pop());
        System.out.println(l225.empty());
    }
}