package LeetCode;

import java.util.Stack;

public class L190_ReverseBits {
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<31;i++){
            result+=n&1;//取n最低位
            n>>>=1;
            result<<=1;//result=result<<1;左移，移动后原低位在前，高位在后
        }
        result+=n&1;//最后一个在反转后为个位，不右移；放在循环中则执行多次判断
        return result;
    }
    public static void main(String[] args){
        L190_ReverseBits l190=new L190_ReverseBits();
        int n=43261596;
        System.out.println(l190.reverseBits(n));
    }
}