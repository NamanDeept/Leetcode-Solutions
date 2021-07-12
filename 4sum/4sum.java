class Solution {
    class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>result = new ArrayList<>();
        HashMap<Integer,ArrayList<pair>>hash = new HashMap<>();
        if(nums.length<4) return result;
        HashMap<ArrayList,Boolean>hash_ = new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(!hash.containsKey(nums[i] + nums[j])){
                    hash.put(nums[i] + nums[j],new ArrayList(Arrays.asList(new pair(i,j))));
                }
                else {
                    ArrayList al = hash.get(nums[i] + nums[j]);
                    al.add(new pair(i,j));
                }
            }
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int value = nums[i] + nums[j];
                if(hash.containsKey(target-value)){
                    ArrayList<pair>al_ = hash.get(target - value);
                    for(pair p:al_){
                    if(i!=p.x && i!=p.y && j!=p.x && j!=p.y){
                       ArrayList<Integer>al = new ArrayList(Arrays.asList(nums[i],nums[j],nums[p.x],nums[p.y]));
                        Collections.sort(al);
                        if(!hash_.containsKey(al)){
                            result.add(al);
                            hash_.put(al,true);
                        }
                    }
                    }
                }
            }
        }
        return result;
    }
}