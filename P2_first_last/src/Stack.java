import java.util.ArrayList;

public class Stack<C> {
	
	private ArrayList<C> data;
	
	public Stack() {
		data = new ArrayList<C>();
	}
	
	public String toString() {
		return data.toString();
	}
	
	public void push(C el) {
		data.add(el);
	}
	
	public C pop() {
		if(data.size() == 0) {
			return null;
		}
		return data.remove(data.size()-1);
	}
	 
	public C peek() {
		if(data.size() == 0) {
			return null;
		}
		return data.get(data.size()-1);
	}
	public int size() {
		return data.size();
	}
	
	

}
