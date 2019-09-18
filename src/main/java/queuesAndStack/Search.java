package queuesAndStack;



public class Search {
	
	static int f[];
	
	/**
	 * ˳�����
	 * @param arry	�����ҵ�����
	 * @param n		�����ҵ�����Ĵ�С
	 * @param key	�����ҵĹؼ���
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
	 * �۰����
	 * @param arry	�����ҵ�����
	 * @param n		�����ҵ�����Ĵ�С
	 * @param key	�����ҵĹؼ���
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
	 * ������ҷ�
	 * @param arry 	�����ҵ�����
	 * @param n		�����ҵ�����Ĵ�С
	 * @param key 	�����ҵĹؼ���
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
	 * 쳲���������
	 * @param i 쳲��������еĴ�С
	 * @return
	 */
	
	static Integer Fbi (int i)
	{
		if(i<2)
			return i == 0 ? 0 : 1;
		return Fbi(i-1) + Fbi(i-2);
	}
	
	
	/**
	 * ���õ���쳲��������з���������
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
	 * 쳲��������в��ҷ�
	 * @param arry 	�����ҵ�����
	 * @param n		�����ҵ�����Ĵ�С
	 * @param key	�����ҵĹؼ���
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
