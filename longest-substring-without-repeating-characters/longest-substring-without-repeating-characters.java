class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>hash = new HashMap();
        int res = 0,j=0;
        for(int i=0;i<s.length();i++){  
            if(hash.containsKey(s.charAt(i))){
                j =Math.max(j, hash.get(s.charAt(i))+1);
            }
               res = Math.max(res,i-j+1);
              hash.put(s.charAt(i),i);
        }
        return res;
    }
}