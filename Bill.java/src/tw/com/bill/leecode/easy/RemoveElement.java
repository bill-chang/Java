package tw.com.bill.leecode.easy;

import java.util.ArrayList;

public class RemoveElement {

	public static void main(String[] args) {
		int nums[]= {3,2,2,3};
		int val=3;
		int nums2[]= {0,1,2,2,3,0,4,2};
		int val2=2;
		System.out.println(removeElement(nums, val));
		
		System.out.println(removeElement(nums2, val2));

	}
	public static int removeElement(int[] nums, int val) {
//		if(nums.length==0) {return nums.length;}
//		ArrayList<Integer> art=new ArrayList<>();
//			for(int i=0;i<nums.length;i++) {
//				if(nums[i]!=val) {
//					art.add(nums[i]);
//					System.out.println(art);
//				}
//			}
//		return art.size();
		
		int i = 0;
		
		for (int n : nums) {
			if (n != val) {
				nums[i++] = n;
			}
		}
		
		return i;
	}
	
}
