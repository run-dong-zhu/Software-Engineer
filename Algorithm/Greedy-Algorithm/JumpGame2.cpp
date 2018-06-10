// leetcode 45

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size() < 2) {
            return 0;
        }
        
        int current_max_index = nums[0];
        int pre_max_index = nums[0];
        int jump_min = 1;
        
        for(int i = 0; i < nums.size(); i++) {
            if(current_max_index < i) {
                jump_min++;
                current_max_index = pre_max_index;
            }
            if(pre_max_index < nums[i] + i) {
                pre_max_index = nums[i] + i;
            }
        }
        return jump_min;
    }
};
