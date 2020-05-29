package tw.org.iii.java;

import java.util.HashMap;
import java.util.Map;

public class Try {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] yy= {2,7,11,15};
		int i=18;
		twoSums(yy,i);
	}
	public static void twoSums(int[] nums,int target) {
		 Map<Integer,Integer> map=new HashMap<>();
	        for(int i=0;i<nums.length;i++){
	            map.put(nums[i],i);
	        }
	        for(int i=0;i<nums.length;i++){
	            int comp=target - nums[i];
	            if (map.containsKey(comp) && map.get(comp) !=i){
	            	System.out.println(map.get(comp));
	            }
	          
	       }
	         throw new IllegalArgumentException("No two sum solution");
	    } 	    
	}

