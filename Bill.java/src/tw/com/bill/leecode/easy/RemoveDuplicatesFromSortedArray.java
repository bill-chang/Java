package tw.com.bill.leecode.easy;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums= {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));

	}

	public static int removeDuplicates(int[] nums) {
		if(nums.length==0)return 0;
		int x=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]!=nums[x]) {
			
				x++;
				nums[x]=nums[i];
			}
			System.out.println("num:"+nums[i]);
		}
		return x+1;
	}
}
