package queuesAndStack;



public class Search {
	
	static int f[];
	
	/**
	 * 顺序查找
	 * @param arry	被查找的数组
	 * @param n		被查找的数组的大小
	 * @param key	所查找的关键字
	 * @return
	 */
	
	public static Integer sequentialSearch(int arry[],int n,int key){
		
		int i =0;
		
		arry[0] = key;
		
		i = n;
		
		while(arry[i]!=key){
			i--;
		}
		return i;
	}
	
	
	/**
	 * 折半查找
	 * @param arry	被查找的数组
	 * @param n		被查找的数组的大小
	 * @param key	所查找的关键字
	 * @return
	 */
	public Integer binarySearch(int arry[],int n ,int key){
		int low,high,mid;
		low=1;
		high=n;
		
		while(low<high){
			
			mid=(low+high)/2;
			
			if(key<arry[mid]){
				high = mid -1 ;
			}
			else if(key>arry[mid]){
				low = mid+1;
			}
			else{
				return mid;
			}
		}
		return 0;
	}
	
	
	/**
	 * 插入查找法
	 * @param arry 	被查找的数组
	 * @param n		被查找的数组的大小
	 * @param key 	所查找的关键字
	 * @return
	 */
	public Integer intoSearch(int arry[], int n, int key){
		
		int low,high,mid;
		
		low =1 ;
		high= n ;
		
		while(low<high)
		{
			mid = low +(high-low)*(key-arry[low])/(arry[high]-arry[low]);
			
			if(key<arry[mid]){
				high = mid-1;
			}
			else if(key>arry[mid]){
				low = mid+1;
			}
			else{
				return mid;
			}
		}
		return 0;
	}
	
	
	/**
	 * 斐波那契数列
	 * @param i 斐波那契数列的大小
	 * @return
	 */
	
	static Integer Fbi (int i)
	{
		if(i<2)
			return i == 0 ? 0 : 1;
		return Fbi(i-1) + Fbi(i-2);
	}
	
	
	/**
	 * 将得到的斐波那契数列放入数组中
	 * @param n
	 * @return
	 */
	public static int[] getF(int n){
		
		for(int i = 0; i< n; i++)
		{
			f[i] = Fbi(n);
		}
		
		return f;
	}
 	
	/**
	 * 斐波那契数列查找法
	 * @param arry 	被查找的数组
	 * @param n		被查找的数组的大小
	 * @param key	所查找的关键字
	 * @return
	 */
	public Integer fibonacciSearch(int arry[],int n,int key){
		
		int low,high,mid,i = 0,k;
		
		low = 1;
		high = n;
		k = 0;
		
		while(key>f[i]-1){
			
			k++;
			
			for(i = n;i<f[k]-1;i++){
				
				arry[i] = arry[n];
			}
		}
		
		while(low<high){
			mid = low+f[k-1]-1;
			
			if(key<arry[mid]){
				
				high = mid -1;
				k=k-1;
			}
			else if (key>arry[mid]){
				low = mid+1;
				k=k-2;
			}
			else{
				if(mid<=n){
					return mid;
				}
				else 
				{
					return n;
				}
			}
		}
		
		return 0;
	}
	
}
