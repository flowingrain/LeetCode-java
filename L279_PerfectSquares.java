package LeetCode;

public class L279_PerfectSquares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++)//dp[i]表示到i为止的最少平方数的数目
            dp[i]=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int sqrt=(int)Math.sqrt(i);
            if(sqrt*sqrt==i)
            {
                dp[i]=1;
                continue;//后边就不需要执行了
            }
            for(int j=1;j<=sqrt;j++){
                int diff=i-j*j;
                dp[i]=Math.min(dp[i],dp[diff]+1);
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        L279_PerfectSquares l279=new L279_PerfectSquares();
        int n=43;
        //Input
        //43
        //Output
        //4
        //Expected
        //3
        System.out.println(l279.numSquares(n));
    }
}
