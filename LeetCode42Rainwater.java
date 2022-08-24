class Solution {
    public int trap(int[] height) {
        // claculate the left max boundry
        int leftmax[] = new int [height.length];
        leftmax[0]=height[0];
        //i=1 bec cant have any water on the 1st block
        for(int i=1; i<height.length; i++)
        {
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }
        //claculating the rightmax boundry
        int n = height.length;
        int rightmax[] = new int [n];
        rightmax[n-1]= height[n-1];
        //i=n-2 bec cant have any water on the last block
        for(int i = n-2 ; i>=0; i--)
        {
            rightmax[i]=Math.max(height[i], rightmax[i+1]);
        }
        int trapped_water=0;
        for(int i=0;i<n; i++){
            int waterlevel = Math.min(leftmax[i],rightmax[i]);
            trapped_water += waterlevel - height[i];
        }
        return trapped_water;
    }
}