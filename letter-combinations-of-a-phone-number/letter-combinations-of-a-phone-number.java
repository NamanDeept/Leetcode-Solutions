class Solution {
    //implementing using BFS
    char [][]dp = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String>answer = new ArrayList<>();
        int n = digits.length();
        Queue<String>queue = new LinkedList<>();
        if(digits.length() == 0) return new ArrayList<>();
        int level = 0, counter = 0, index = 0;
        for(char ch : dp[digits.charAt(index)- '0']) {
            queue.add(ch+"");
            level++;
        }
        index++;
        while(queue.size()!=0) {
            String node = queue.remove();
            if(node.length() == n) {
                answer.add(node);
            }
            else {
                for(char ch : dp[digits.charAt(index)- '0']) {
                    queue.add(node+""+ch);
                    counter++;
                }
                level--;
                if(level == 0) {
                    level = counter;
                    counter = 0;
                    index++;
                }
            }
        }
        return answer;
    }
}