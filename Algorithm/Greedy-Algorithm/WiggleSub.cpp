#leetcode #376

class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        if(nums.size() < 2) {
            return nums.size();
        }
        
        static const int BEGIN = 0;
        static const int UP = 1;
        static const int DOWN = -1;
        
        int state = BEGIN;
        int size = 1;
        
        for(int i = 1; i < nums.size(); i++) {
            switch(state){
                case BEGIN:
                    if(nums[i-1] < nums[i]) {
                        state = UP;
                        size++;
                    }
                    else if(nums[i-1] > nums[i]) {
                        state = DOWN;
                        size++;
                    }
                    break;
                case UP:
                    if(nums[i-1] > nums[i]) {
                        state = DOWN;
                        size++;
                    }
                    break;
                case DOWN:
                    if(nums[i-1] < nums[i]) {
                        state = UP;
                        size++;
                    }
                    break;
            }
        }
        return size;
    }
};
