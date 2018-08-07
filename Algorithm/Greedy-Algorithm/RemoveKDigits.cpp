//leetcode 402

class Solution {
public:
    string removeKdigits(string num, int k) {
        std::vector<int> S;
        std::string result = "";
        for(int i = 0; i < num.length(); i++) {
            int number = num[i] - '0';
            //when stack top smaller than number
            while(S.size() != 0 && S[S.size() - 1] > number && k > 0) {
                S.pop_back();
                k--;
            }
            //avoid the first digit is 0
            if(S.size() != 0 || number != 0) {
                S.push_back(number);
            }
        }
        while(S.size() != 0 && k > 0) {
            S.pop_back();
            k--;
        }
        
        for(int i = 0; i < S.size(); i++) {
            result.append(1, '0' + S[i]);
        }
        if(result == "") {
            result = "0";
        }
        return result;
    }
};
