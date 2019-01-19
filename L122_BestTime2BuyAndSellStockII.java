package LeetCode;

public class L122_BestTime2BuyAndSellStockII {
    public int maxProfit(int[] prices) {//允许多次操作，问题相当于求出差值序列中正值之和
        if(prices.length<2)
            return 0;
        int profit=0;
        for (int i = 1; i <prices.length; i++) {
            profit=((prices[i] - prices[i - 1])>0?(profit+(prices[i] - prices[i - 1])):(profit));
        }
        return profit;
    }
    public static void main(String[] args){
        L122_BestTime2BuyAndSellStockII l122=new L122_BestTime2BuyAndSellStockII();
        //int[] prices={7,1,5,3,6,4};
        int[] prices={1,2,3,4,5};
        System.out.println(l122.maxProfit(prices));
    }
}
