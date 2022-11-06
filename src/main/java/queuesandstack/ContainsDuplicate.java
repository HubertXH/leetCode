package queuesandstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainsDuplicate {
	
	public boolean contain(int[] nums){
		
		if (nums ==null || nums.length==0) {
			return false;
		}
		
		List<Integer> list =  new ArrayList<>();
		
		for(int i = 0;i<nums.length;i++){
			
			if (list.contains(nums[i])) {
				return false;
			}else {
				list.add(nums[i]);
			}
		}
		return true;
	}	
	
	
	/**
	 * ����һ�����飬������������ظ���Ԫ���򷵻�true���򷵻�false
	 * @param nums
	 * @return
	 */
	public boolean soultion(int[] nums){
		
		Arrays.sort(nums);
		
		if (nums.length ==1) {
			return false;
		}
		
		for(int i = 0;i<nums.length-1;i++){
			if (nums[i] == nums[i+1]) 
				return true;
		}
		return false;
	}
	
	
}
