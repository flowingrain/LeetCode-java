package LeetCode;

public class L516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if(s.length()<2)
            return 1;
        int len=s.length();
        int[][] dp=new int[len][len];//dp[i][j]表示s(i:j)（包括i,j）之间的回文子串长度
        for(int i=0;i<len;i++){//先给出对角线上的值，然后才可以从左向右从上向下推导其他值
            dp[i][i]=1;
        }
        /*for(int col=0;col<len;col++)//i表示列，j表示行
        {
            for(int row=col-1;row>=0;row--){
                if (s.charAt(col)==s.charAt(row))
                    dp[row][col]=dp[row+1][col-1]+2;//0,0在左下角的矩阵中左上方向
                else
                    dp[row][col]=Math.max(dp[row][col-1],dp[row+1][col]);//左、上
            }
        }*/
        for(int row=len-2;row>=0;row--){//行的循环放在外，列的循环放在内，可以缩短时间。(但理解不直观)，(n-1.n-1)处的值不需要求，前边的单层循环已经给出结果了
            for(int col=row+1;col<len;col++)
            {
                if (s.charAt(col)==s.charAt(row))
                    dp[row][col]=dp[row+1][col-1]+2;//0,0在左下角的矩阵中左上方向
                else
                    dp[row][col]=Math.max(dp[row][col-1],dp[row+1][col]);//左、上
                //System.out.println(row+","+col+":"+dp[row][col]);
            }
        }
        return dp[0][len-1];
    }
    public static void main(String[] args){
        L516_LongestPalindromicSubsequence l516=new L516_LongestPalindromicSubsequence();
        String s="bbbab";
        System.out.println(l516.longestPalindromeSubseq(s));
    }
}
