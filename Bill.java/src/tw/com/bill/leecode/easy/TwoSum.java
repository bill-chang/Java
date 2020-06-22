package tw.com.bill.leecode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	private class TwoSumAdd {
		 public  int[] twoSum(int[] nums, int target) {
		        Map<Integer,Integer> map=new HashMap<>();
		        for(int i=0;i<nums.length;i++){
		            map.put(nums[i],i);
		        }
		        for(int i=0;i<nums.length;i++){
		            int comp=target - nums[i];
		            if (map.containsKey(comp) && map.get(comp) !=i){
		               return new int[]{i,map.get(comp)};
		            }
		       }
		         throw new IllegalArgumentException("No two sum solution");
		    } 	    
	}

}
