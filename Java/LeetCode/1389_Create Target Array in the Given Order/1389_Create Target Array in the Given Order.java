class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] out = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            out[i] = -1; 
        }
        for(int i=0;i<nums.length;i++){
            if(out[index[i]]!=-1){
                for(int r=nums.length-1;r>index[i];r--){
                    out[r] = out[r-1];
                }
                out[index[i]]=nums[i];
            }
            else{
                out[index[i]]=nums[i];
            }
        }
        return out;
    }
}