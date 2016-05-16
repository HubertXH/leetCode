package queuesAndStack;
import java.util.Stack;
public class ImplementQueueUsingStacks {

	private Stack<Integer> stackOne = new Stack<>();
	private Stack<Integer> stackTwo = new Stack<>();
	private int front;
	
	public void push(int x){
		stackOne.push(x);
	}
	
	public void pop(){
		while(!stackOne.isEmpty()){
			stackTwo.add(stackOne.pop());
		}
		
		stackTwo.pop();
		
		while (!stackTwo.isEmpty()) {
			stackOne.add(stackTwo.pop());
		}
	}
	
	public int peek(){
		while(!stackOne.isEmpty()){
			stackTwo.add(stackOne.pop());
		}
		
		front = stackTwo.peek();
		
		while (!stackTwo.isEmpty()) {
			stackOne.add(stackTwo.pop());
		}
		
		return front;
	}
	
	public boolean empty(){
		return stackOne.isEmpty();
	}
	
}
