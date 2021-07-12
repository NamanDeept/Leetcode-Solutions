class Solution {
    int maxRemovingCharacter = 1;
    public boolean checkValid(char []s, int start, int end, int counter) {
        if(counter > maxRemovingCharacter) return false;
        if(start == end) return true;
        while(start < end) {
            if(s[start] != s[end]) {
                return checkValid(s, start + 1, end, counter + 1) || checkValid(s, start, end - 1, counter + 1);
                
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
       char []str = s.toCharArray();
       return checkValid(str, 0, str.length - 1, 0);
    }
}