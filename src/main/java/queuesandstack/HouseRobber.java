package queuesandstack;

/**
 *  You are a professional robber planning to rob houses along a street.
 *  Each house has a certain amount of money stashed,the only constraint 
 *  stopping you from robbing each of them is that adjacent houses have 
 *  security system connected and it will automatically contact the police 
 *  if two adjacent houses were broken into on the same night.
 *  
 *  Given a list of non-negative integers representing the amount of money 
 *  of each house, determine the maximum amount of money you can rob tonight 
 *  without alerting the police.
 *  
 * @author Administrator
 *
 */
public class HouseRobber {
	
	public int rob(int[] nums){
		
		int sum = 0;
		int take = 0;
		int notdo = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			take = notdo+nums[i];
			
			notdo = sum;
			
			sum = Math.max(take, notdo);			
		}
		return sum;
	}
}
