package LeetCode;

public class L240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;//空矩阵
        //重点：两个可移动方向，一个变大一个缩小。
        int row=0,col=matrix[0].length-1;
        while(col>=0&&row<matrix.length){
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                col--;
            else
                row++;
        }
        return false;
    }
    public static void main(String[] args){
      /*  int[][] matrix={
                            {1,   4,  7, 11, 15},
                            {2,   5,  8, 12, 19},
                            {3,   6,  9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}
                        };
        int target=10;*/
        int[][] matrix={
                {   1,  4,  7,  11, 15},
                {   2,  5,  8,  12, 19},
                {   3,  6,  9,  16, 22},
                {   10, 13, 14, 17, 24},
                {   18, 21, 23, 26, 30}
        };
        int target=5;
        L240_SearchA2DMatrixII l240=new L240_SearchA2DMatrixII();
        System.out.println(l240.searchMatrix(matrix,target));
    }
}