package LeetCode;
import java.util.Arrays;

public class L167_TwoSumII_InputArraySorted {
    public int[] twoSum(int[] numbers, int target) {
        int front=0,back=numbers.length-1;
        while(numbers[front]+numbers[back]!=target){
            if(numbers[front]+numbers[back]>target)
                back--;
            else
                front++;
        }
        return new int[]{front+1,back+1};//下标计数从1开始
    }
    public static void main(String[] args){
        L167_TwoSumII_InputArraySorted l167=new L167_TwoSumII_InputArraySorted();
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result=l167.twoSum(numbers,target);
   /*     for (int res:result) {
            System.out.println(res+"\t");
        }*/
        System.out.println(Arrays.toString(result));
    }
}