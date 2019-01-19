package LeetCode;

public class L70_ClimbingStairs {
    //n个台阶的楼梯的走法等于：
    //ways(n) = ways(n-1) + ways(n-2)
    public int climbStairs(int n) {
        int pre1=0,pre2=1,ways=0;//两步前的走法数、一步前的走法数
        if(n<=0){
            return n;
        }
        for(int i=1;i<=n;i++)
        {
            ways=pre1+pre2;
            pre1=pre2;
            pre2=ways;
        }
        return ways;
    }
}