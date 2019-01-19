package LeetCode;

public class L171_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int len=s.length();
        int colNum=0;
        int base=1;//当前位的1表示的大小
        for(int i=len-1;i>=0;i--){
            colNum+=(int)(s.charAt(i)-64)*base;
            base*=26;
        }
        return colNum;
    }
    public static void main(String[] args){
        L171_ExcelSheetColumnNumber l171=new L171_ExcelSheetColumnNumber();
        String s="AB";
        System.out.println(l171.titleToNumber(s));
    }
}
