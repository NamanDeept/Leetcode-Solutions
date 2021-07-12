class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE,n = nums.length;
        Arrays.sort(nums);
        if(n<3) return result;
        result = nums[0] + nums[1] + nums[2];
        
        for(int i=0;i<n-2;i++){
           if(i==0 || nums[i] !=nums[i-1]){
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target){
                    left++;
                }
                else right--;
                
                if(Math.abs(result - target) > Math.abs(sum - target)){
                    result = sum;
                }
            }
          }
        }
        return result;
    }
}