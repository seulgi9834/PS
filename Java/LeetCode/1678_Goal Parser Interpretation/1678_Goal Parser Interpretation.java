class Solution {
    public String interpret(String command) {
        String output ="";
        for(int i=0;i<command.length();i++){
            if(i+1<command.length()){
                if(command.charAt(i)=='('&&command.charAt(i+1)==')'){
                output+="o";
                i+=1;
                continue;
                }
            }
            if(i+3<command.length()){
                if(command.charAt(i)=='('&&command.charAt(i+1)=='a'&&command.charAt(i+2)=='l'&&command.charAt(i+3)==')'){
                  output+="al";
                i+=3;
                    continue;
                }
            }
                output+=command.charAt(i);
        }
        return output;
    }
}