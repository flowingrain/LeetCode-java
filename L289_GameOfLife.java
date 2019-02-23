package LeetCode;

import java.util.Arrays;

public class L289_GameOfLife {
    private int liveNeighbors(int[][] board,int i,int j){//横向 纵向均有不小于1
        int count=0;
        for(int row=Math.max(i-1,0);row<=Math.min(board.length-1,i+1);row++)//行
        {
            for(int col=Math.max(j-1,0);col<=Math.min(board[0].length-1,j+1);col++)//列
            {
                /*if((row!=i||col!=j)&&board[row][col]==1){
                    count++;
                }*/
                count+=board[row][col]&1;//board[row][col]==1时board[row][col]&1==1，board[row][col]==0时board[row][col]&1==0
            }
        }
        //对board[i][j]进行了一次统计
        return count-(board[i][j]&1);
    }
    public void gameOfLife(int[][] board) {
        int rowNum=board.length;
        int colNum=board[0].length;
        if(board==null||rowNum==0||colNum==0)
            return;
        for(int i=0;i<rowNum;i++)
        {
            for(int j=0;j<colNum;j++)
            {
                int liveNeighbor=liveNeighbors(board,i,j);
                if(board[i][j]==1){
                    if(liveNeighbor<2)
                        next[i][j]=0;
                    else if(liveNeighbor==2||liveNeighbor==3)
                        next[i][j]=1;
                    else if(liveNeighbor>3)
                        next[i][j]=0;
                }else{
                    if(liveNeighbor==3)
                        next[i][j]=1;
                }
            }
            //System.out.println();
        }
        for(int i=0;i<rowNum;i++)
        {
            for(int j=0;j<colNum;j++)
            {
                board[i][j]=board[i][j]>>1;
            }
        }
       /* for(int i=0;i<next.length;i++) {
            System.out.println(Arrays.toString(board[i]));
        }*/
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
