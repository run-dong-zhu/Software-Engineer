public class BinarySearch {
	
	public int bSearch(int[] nums, int left, int right, int target) {
		if(left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		
		if(target == nums[mid]) {
			return mid;
		}
		else if(target < nums[mid]) {
			return bSearch(nums, left, mid - 1, target);
		}
		else {
			return bSearch(nums, mid + 1, right, target);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 6, 8, 15, 21, 26, 40};
		int[] test = {};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.bSearch(nums, 0, nums.length - 1, 7));
		System.out.println(bs.bSearch(nums, 0, nums.length - 1, 26));
		System.out.println(bs.bSearch(test, 0, test.length - 1, 5));
	}
}
