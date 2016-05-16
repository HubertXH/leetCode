package queuesAndStack;

public class ImplementPow {
	
	public double power(double x,int n){
		
		Math.pow(x, n);
		
		return 0;
	}
	
	
	
	public double myPower(double x,int n){

		double m = x;
		if(n == 0){
			return 1;
		}else if (x == Double.NEGATIVE_INFINITY) {
			return Double.NEGATIVE_INFINITY;
		}else if (n == -1) {
			return 1/x;
			
		}else if (n<0) {
			
			for(int i = -2;i>=n;i--){
				 m =m * x;
			}
			return 1/m;
		}else if (n==1) {
			return x;
			
		}else if (x ==Double.POSITIVE_INFINITY ) {
			return Double.POSITIVE_INFINITY;
		}
		
		else {
			
			 for(int i = 1;i<=n;i++){
				 m = m *x;
			 }
			 return m;
		}
	}
	
}
