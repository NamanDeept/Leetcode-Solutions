class Solution {
    public String convert(String s, int numRows) {
        if( numRows >= s.length() || numRows==1) return s;
        
        String output ="";
        for(int k =0 ;k< numRows;k++){
            String res = "";
            int i = k;
            if(k==0 || k == numRows-1){
                while(i < s.length()){
                    res += s.charAt(i);
                    i += 2*(numRows-1);
                }
            }
            else{
                int count=0;
                while(i < s.length()){
                    res+=s.charAt(i);
                    i=(count%2==0)?i+2*(numRows-1-k):i+2*k;
                    count++;
                }
            }
            
            output +=res;
        }
        return output;
    }
}