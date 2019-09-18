package queuesAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	private Queue<Integer> queueOne = new LinkedList<>();
	private Queue<Integer> queueTwo =  new LinkedList<>();
	private int top;
	public void push(int x){
		queueOne.add(x);
		
		top=x;
	}

	
	public void pop(){
		
		while(queueOne.size()>1){
			
			top = queueOne.remove();
			
			queueTwo.add(top);
		}
		queueOne.remove();
		
		Queue<Integer> temp = queueOne;
		
		queueOne = queueTwo;
		
		queueTwo = temp;
	}
	
	public int top(){
		return top;
	}
	
	public boolean empty()
	{
		return queueOne.isEmpty();
	}
	

}
