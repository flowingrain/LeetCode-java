package LeetCode;

public class L121_BestTime2BuyAndSellStock {
    /*public int maxProfit(int[] prices) {//问题变换，求得差值序列的最大子串和
        int orginLen=prices.length;
        if(orginLen<2)
            return 0;
        int curMax=0,max=0;
        int[] diff = new int[orginLen - 1];
        for (int i = 1; i < orginLen; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        int len = orginLen - 1;
        for (int i = 0; i < len; i++) {
            curMax = Math.max(diff[i], curMax + diff[i]);//注意max函数的第一个参数。
            // 如果前面的子串和小于0，就取当前位置的值；否则取前面子串和与当前位数值的加和
            if (curMax > max) {//如果子串和大于之前的最大值，更新子串和
                max = curMax;
            }
        }
        return max;
    }*/
    public int maxProfit(int[] prices) {
        int orginLen=prices.length;
        if(orginLen<2)
            return 0;
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min)
                min=prices[i];
            if (prices[i] > prices[i - 1])//减少不必要的Math.max运算
                profit=Math.max(profit,prices[i]-min);
        }
        return profit;
    }
    public static void main(String[] args){
        L121_BestTime2BuyAndSellStock l121=new L121_BestTime2BuyAndSellStock();
        int[] prices={7,1,5,3,6,4};
        long timer1=System.currentTimeMillis();
        System.out.println(l121.maxProfit(prices));
        long timer2=System.currentTimeMillis();
    }
}