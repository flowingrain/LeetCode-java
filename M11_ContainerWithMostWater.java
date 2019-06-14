package LeetCode;

public class M11_ContainerWithMostWater {
    /*public int maxArea(int[] height){
        int len=height.length;
        int max=0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int area=(j-i)*(Math.min(height[i],height[j]));//矩形面积
                if(max<area)
                    max=area;
            }
        }
        return max;
    }*/
    //左侧从左向右，右侧从右向左
    //如果左侧比右侧低，则左侧右侧之间的节点与左侧节点之间面积不必计算;//容器高度按左侧计算，宽度不及到右侧的宽度//可直接左侧右移
    //如果右侧壁左侧第，则左侧右侧之间的节点与右侧节点之间面积不必计算。//可直接右侧左移
    public int maxArea(int[] height){
        int len=height.length;
        int max=0,h=0,w=0;
        for(int i=0,j=len-1;i<j;){
            w=j-i;
            if(height[i]<height[j]){
                h=height[i];
                i++;
            }  else {
                h=height[j];
                j--;
            };
            int area=w*h;//矩形面积
            if(max<area)
                max=area;
        }
        return max;
    }
    public static void main(String[] args){
        M11_ContainerWithMostWater m11=new M11_ContainerWithMostWater();
        int[] input1={1,8,6,2,5,4,8,3,7};
        int[] input2={2,3,4,5,18,17,6};
        System.out.println(m11.maxArea(input2));
    }
}
