class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(int i =0 ;i <sentences.length;i++){
            int temp = 1;
            String str = sentences[i];
            for(int r= 0;r<str.length();r++){
                if(str.charAt(r)==' '){
                    temp++;
                }
            }
            max = Integer.max(max, temp);
        }
        return max;
    }
}