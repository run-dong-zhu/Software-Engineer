package dynamic.programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description LeetCode 300, level: Medium
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 */
public class LongestIncreasingSubsequence {
	// O(n ** 2)
	public int solution(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int[] maxSubsequence = new int[nums.length];
		maxSubsequence[0] = 1;
		int maxLength = 1;
		
		for(int i = 1; i < nums.length; i++) {
			maxSubsequence[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j] && maxSubsequence[i] < maxSubsequence[j] + 1) {
					maxSubsequence[i] = maxSubsequence[j] + 1;
				}
			}
			if(maxSubsequence[i] > maxLength) {
				maxLength = maxSubsequence[i];
			}
		}
		return maxLength;
	}
	
	public static int bSearch(List<Integer> list, int target) {
		int index = -1;
		int left = 0;
		int right = list.size() - 1;
		
		while(index == -1) {
			int mid = (left + right) / 2;

			if(target == list.get(mid)) {
				index = mid;
			}
			else if(target < list.get(mid)) {
				if(mid == 0 || target > list.get(mid - 1)) {
					index = mid;
				}
				right = mid - 1;
			}
			else {
				if(mid == list.size() - 1 || target < list.get(mid + 1)) {
					index = mid + 1;
				}
				left = mid + 1;
			}
		}
		return index;
	}
	
	public int solution2(int[] nums) {
		// O(nlogn)
		if(nums.length == 0) {
			return 0;
		}
		
		List<Integer> maxSub = new ArrayList<Integer>();
		maxSub.add(nums[0]);
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] > maxSub.get(maxSub.size() - 1)) {
				maxSub.add(nums[i]);
			}
			else {
				int idx = bSearch(maxSub, nums[i]);
				maxSub.set(idx, nums[i]);
			}
		}
		
		return maxSub.size();
	}

	public static void main(String[] args) {
		int[] nums1 = {4, 10, 4, 3, 8, 9};
		int[] nums2 = {1, 3, 2, 3, 1, 4};
		int[] nums3 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.solution(nums1));
		System.out.println(lis.solution(nums2));
		System.out.println(lis.solution2(nums3));
	}

}
