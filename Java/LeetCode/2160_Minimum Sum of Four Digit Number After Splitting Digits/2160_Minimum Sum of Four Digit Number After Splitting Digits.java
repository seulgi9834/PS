class Solution {
    public int minimumSum(int num) {
        String str = Integer.toString(num);
        int[] nums = new int[4];
        for(int i=0;i<4;i++){
            nums[i] = str.charAt(i)-'0';
        }
        Arrays.sort(nums);
        return (nums[0]+nums[1])*10+(nums[2]+nums[3]);    
    }
}