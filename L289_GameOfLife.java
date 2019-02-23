package LeetCode;

import java.util.Arrays;

public class L289_GameOfLife {
    private int liveNeighbors(int[][] board,int i,int j){//横向 纵向均有不小于1
        int count=0;
        for(int row=Math.max(i-1,0);row<=Math.min(board.length-1,i+1);row++)//行
        {
            for(int col=Math.max(j-1,0);col<=Math.min(board[0].length-1,j+1);col++)//列
            {
                count+=board[row][col]&1;//board[row][col]==1时board[row][col]&1==1，board[row][col]==0时board[row][col]&1==0
            }
        }
        //对board[i][j]进行了一次统计
        return count-(board[i][j]&1);
    }
    public void gameOfLife(int[][] board) {//也可以使用Board的最高位存储当前状态，低位存储存活邻居数
        int rowNum=board.length;
        int colNum=board[0].length;
        if(rowNum==0||colNum==0)
            return;
        for(int i=0;i<rowNum;i++)
        {
            for(int j=0;j<colNum;j++)
            {
                int liveNeighbor=liveNeighbors(board,i,j);
                if(((board[i][j]&1)==1)&&(liveNeighbor==2||liveNeighbor==3)){
                    /*if(liveNeighbor<2||liveNeighbor>3)
                        board[i][j]=1;//当前1 下一步0。此时board[i][j]不需要改变
                    else //(liveNeighbor==2||liveNeighbor==3)
                        board[i][j]=3;//当前1 下一步1*/
                        board[i][j]=3;
                }else if(((board[i][j]&1)==0)&&(liveNeighbor==3))//当前0 下一步1。毕竟与上边的if不是独立的。
                    board[i][j]=2;
            }
        }
        for(int i=0;i<rowNum;i++)
        {
            for(int j=0;j<colNum;j++)
            {
                board[i][j]=board[i][j]>>1;
            }
        }
    }

    public static void main(String[] args){
        L289_GameOfLife l289=new L289_GameOfLife();
        int[][] input= {{0,1,0},
                        {0,0,1},
                        {1,1,1},
                        {0,0,0}};
        l289.gameOfLife(input);
        System.out.println();
        for(int i=0;i<input.length;i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }
}
