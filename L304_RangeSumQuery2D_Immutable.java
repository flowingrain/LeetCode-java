package LeetCode;

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
public class L304_RangeSumQuery2D_Immutable {
    private int[][] matrix;
    /* public L304_RangeSumQuery2D_Immutable(int[][] matrix) {
         this.matrix=matrix;
     }

     public int sumRegion(int row1, int col1, int row2, int col2) {
         int result=0;
         for(int i=row1;i<=row2;i++){
             for(int j=col1;j<=col2;j++){
                 result+=matrix[i][j];
             }
         }
         return  result;
     }*/
    public L304_RangeSumQuery2D_Immutable(int[][] matrix) {
        this.matrix=matrix;
        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j]+=matrix[i][j-1];//同一行使用累加和。
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row2>=matrix.length||col2>=matrix[0].length)
            return 0;
        int result=0;
        if(col1==0){
            for(int i=row1;i<=row2;i++)
                result+=matrix[i][col2];
        }else{
            for(int i=row1;i<=row2;i++)
                result+=(matrix[i][col2]-matrix[i][col1-1]);
        }
        return  result;
    }
    public static void main(String[] args){
        int[][] matrix = {
                            {3, 0, 1, 4, 2},
                            {5, 6, 3, 2, 1},
                            {1, 2, 0, 1, 5},
                            {4, 1, 0, 1, 7},
                            {1, 0, 3, 0, 5}
                        };
        L304_RangeSumQuery2D_Immutable l304=new L304_RangeSumQuery2D_Immutable(matrix);
        System.out.println(l304.sumRegion(2,1,4,3));
    }
}
