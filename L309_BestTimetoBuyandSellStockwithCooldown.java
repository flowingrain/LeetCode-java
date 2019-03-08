package LeetCode;

public class L309_BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)//等于1的话没有卖出操作，也就没有利润。
            return 0;
        /*
        两种类型的利润，
        第一种，第i天卖出
        第二种，第i天歇着（卖出后，没有买入。不卖出是不能算利润的。可以是冷却，也可以是不操作）
         */
        int sellProfit=0,restProfit=0,lastSellProfit=0;//lastSellProfit记录上一步的卖出利润
        for(int i=1;i<prices.length;i++){//贪心算法。
            lastSellProfit=sellProfit;//i-1天的卖出利润。
            sellProfit=Math.max(sellProfit+prices[i]-prices[i-1],restProfit);//前边表示撤销前一天的售出，改今天售出的利润；后一个表示到第i-1天的最大利润。第i天售出不可能第i-1天rest的利润。
            restProfit=Math.max(restProfit,lastSellProfit);//第i天rest的利润（跟i-1天卖出做比较)。
        }
        return Math.max(sellProfit,restProfit);//返回最后一天的卖出利润和休息利润中较大的
    }
    public static void main(String[] args){
        L309_BestTimetoBuyandSellStockwithCooldown l309=new L309_BestTimetoBuyandSellStockwithCooldown();
        int[] prices={1,2,3,0,2};
        System.out.println(l309.maxProfit(prices));
    }
}
