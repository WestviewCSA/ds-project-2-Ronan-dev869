import java.util.ArrayList;

public class Queue{
	private Stack data;
	private Stack res;
	public Queue() {
		data = new Stack();
		res = new Stack();
		
	}
	
	/*
	 * add to queue
	 */
	
	public void enqueue(Tile el) {
		data.push(el);
		
		
	}
	
	public Tile dequeue() {
		
		
		for(int i = 0; i<data.size()+i; i++) {
			res.push(data.pop());
			
		}
		
		Tile t = res.pop();
		for(int i = 0; i<res.size()+i; i++) {
			data.push(res.pop());
		}
		   
		return t;
	}
	
	public int size() {
		
		return data.size();
	}
	
	public Tile peek() {
		
		return data.peek();
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public String toString() {
		String result = "[";
		int l = size();
		for(int i = 0; i<l; i++) {
			Tile temp = dequeue();
			result+= temp;
			data.push(temp);
			result+=", ";
			
		}
		result = result.substring(0,result.length()-2);
		result+="]";
		return result;
	}
	
}
