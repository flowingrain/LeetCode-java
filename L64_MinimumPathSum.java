package LeetCode;

public class L64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return -1;
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];//dp[i][j]表示[0][0]到[i][j]之间的距离
        dp[0][0]=grid[0][0];

        //边缘部分初始化
        for(int i=1;i<m;i++){//m行。设置第m行的第0列
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){//n列
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];//上边的，左边的
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        L64_MinimumPathSum l64=new L64_MinimumPathSum();
        int[][] grid=   {
                            {1,3,1},
                            {1,5,1},
                            {4,2,1}
                        };
        /*int[][] grid=   {
                            {1,2},
                            {1,1}
                        };*/
        /*int[][] grid=   {
                {0,1},
                {1,0}
        };*/
        l64.minPathSum(grid);
        //System.out.println(l64.minPathSum(grid));
    }
}
