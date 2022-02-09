class Solution {
    public int[] getConcatenation(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N*2];
        for(int i =0;i<ans.length;i++){
            ans[i]=nums[i%N];
        }
        return ans;
    }
}