package stack;
import java.util.*;
public class pushBottom {
	
	public static void pushAtBottom(Stack<Integer> s,int data)
	{
		if(s.isEmpty())
		{
			s.push(data);
			return;
		}
		int top = s.pop();
		pushAtBottom(s,data);
		s.push(top);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		s.push(7);
		s.push(8);
		s.push(9);
		pushAtBottom(s, 100);
		System.out.println(s);
		while(!s.isEmpty())
		{
			System.out.println(s.pop());
		}
	

	}
	

}
