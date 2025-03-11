import java.util.ArrayList;

public class Queue<C> {
	private Stack<C> data;
	private Stack<C> res;
	public Queue() {
		data = new Stack<C>();
		res = new Stack<C>();
		
	}
	
	/*
	 * add to queue
	 */
	
	public void enqueue(C el) {
		data.push(el);
		
		
	}
	
	public C dequeue() {
		
		
		for(int i = 0; i<data.size()+i; i++) {
			res.push(data.pop());
			
		}
		
		C t = res.pop();
		for(int i = 0; i<res.size()+i; i++) {
			data.push(res.pop());
		}
		   
		return t;
	}
	
	public int size() {
		
		return data.size();
	}
	
	public C peek() {
		
		return data.peek();
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public String toString() {
		String result = "[";
		int l = size();
		for(int i = 0; i<l; i++) {
			C temp = dequeue();
			result+= temp;
			data.push(temp);
			result+=", ";
			
		}
		result = result.substring(0,result.length()-2);
		result+="]";
		return result;
	}
	
}
