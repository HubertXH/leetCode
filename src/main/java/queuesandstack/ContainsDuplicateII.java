package queuesandstack;
/**
 * 
 * 
 * Given an array of integers and an integer k,  
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the difference between i and j is at most k. 
 */
import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicateII {
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	  public boolean containsNearbyDuplicate(int[] nums,int k)
	  {
		  int start = 0, end = 0;
		  Set<Integer> set = new HashSet<>();
		  
		  	for(int i = 0;i<nums.length;i++){
		  		if (!set.contains(nums[i])) {
					set.add(nums[i]);
					end++;
				}else {
					return true;
				}
		  		if (end-start>k) {
					set.remove(nums[start]);
					start++;
				}
		  	}
		  
		  return false;
	  }
}
